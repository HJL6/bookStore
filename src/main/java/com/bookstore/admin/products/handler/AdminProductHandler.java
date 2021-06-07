package com.bookstore.admin.products.handler;

import com.bookstore.admin.products.service.IAdminProductService;
import com.bookstore.commons.beans.Product;
import com.bookstore.commons.beans.ProductList;
import com.bookstore.utils.IdUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class AdminProductHandler {
    @Autowired
    IAdminProductService adminProductService;
    @RequestMapping("/listProduct")
    /*获取商品列表*/
    public String listProduct(Model model){
       List<Product> products= adminProductService.findProduct();
       model.addAttribute("products",products);
       return "/admin/products/list.jsp";
    }
    /*按照条件查询商品信息*/
    @RequestMapping("/findProductByManyCondition")
    public  String findProductByManyCondition(Product product,Double minprice,Double maxprice,Model model){
      List<Product>products=  adminProductService.findProductByManyCondition(product,minprice,maxprice);
      model.addAttribute("products",products);
      model.addAttribute("minprice",minprice);
      model.addAttribute("maxprice",maxprice);
        return "/admin/products/list.jsp";
    }
      /*添加商品*/
    @RequestMapping("/addProduct")
    public String addProduct(Product product, MultipartFile upload, HttpSession session) throws IOException {
        //保存图片
        String path1="C:\\Users\\yaya\\Desktop\\bookstore\\src\\main\\webapp\\productImg";
        String path=session.getServletContext().getRealPath("/productImg");
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        String filename= IdUtils.getUUID()+"-"+upload.getOriginalFilename();
        upload.transferTo(new File(path,filename));
       // upload.transferTo(new File(path1,filename));
        //文件拷贝
        FileUtils.copyFile(new File(path,filename),new File(path1,filename));
        product.setId(IdUtils.getUUID());
        product.setImgurl("/productImg/"+filename);
        adminProductService.addProduct(product);
        return "redirect:/admin/products/listProduct";
    }
    /*商品编辑*/
    /*查找要修改的原始商品*/
    @RequestMapping("/findProductById")
    public String findProductById(String id,Model model){
        Product product=adminProductService.findProductById(id);
        model.addAttribute("p",product);
        return "/admin/products/edit.jsp";
    }
    /*修改商品信息*/
    @RequestMapping("/editProduct")
    public String editProduct(Product product,MultipartFile upload,HttpSession session) throws IOException {
        //如果上传了新的图片
        if(!upload.isEmpty()){
            //先删除原始图片
            Product target=adminProductService.findProductById(product.getId());
            //删除原始图片
            File targetFile=new File(session.getServletContext().getRealPath("/")+target.getImgurl());
            if(targetFile.exists()){
                targetFile.delete();
            }

            // 再保存新的图片
            String path=session.getServletContext().getRealPath("/productImg");
            String filename=IdUtils.getUUID()+"-"+upload.getOriginalFilename();

            upload.transferTo(new File(path,filename));

            //如果上传了新的图片，给product的imgurl赋予新的图片地址
            product.setImgurl("/productImg/"+filename);
        }
        //修改数据库信息
       adminProductService.editProduct(product);
        return "redirect:/admin/products/listProduct";

    }
    /*商品删除*/
    @RequestMapping("/removeProduct")
    public String removeProduct(String id,HttpSession session){
        Product target=adminProductService.findProductById(id);
        File targetFile=new File(session.getServletContext().getRealPath("/")+target.getImgurl());
        if(targetFile.exists()){
            targetFile.delete();
        }
        adminProductService.removeProduct(id);
        return "redirect:/admin/products/listProduct";
    }


    //调用此函数 对fileName针对不同浏览器采用字节回退重新编码后 将fileName返回
    public String processFileName(HttpServletRequest request, String fileName) throws UnsupportedEncodingException, UnsupportedEncodingException {
        //采用字节回退，解决文件名中文乱码问题
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) { //IE浏览器处理
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {                                                           // 非IE浏览器的处理：
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        return fileName;
    }


    //销售榜单
    @RequestMapping("/download")
    public void download(String year, String month, HttpServletResponse response,HttpServletRequest request) throws IOException {
        List<ProductList> pList = adminProductService.findProductSalList(year,month);
        String filename = year + "年" + month +"月销售榜单";
        String sheetName = month + "月销售榜单";
        String titleName = year + "年" +month +"月销售榜单";
        String[] columnName = {"商品名称","商品销量"};

        String[][] dataList = new String[pList.size()][2];
        for (int i = 0;i<pList.size();i++){
            dataList[i][0] = pList.get(i).getName();
            dataList[i][1] = pList.get(i).getSalnum();
        }
        for (ProductList pl:pList){
            System.out.println(pl);
        }

        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建excel中的sheet，在wb的基础上创建表
        HSSFSheet sheet = wb.createSheet(sheetName);
        //创建sheet的第一行，在sheet的基础上创建行，索引从0开始
        HSSFRow row1 = sheet.createRow(0);
        //创建第一行的第一个单元格
        HSSFCell cell = row1.createCell(0);
        //合并第一行的两个单元格，参数是CellRangeAddress，对象的参数是第一行，最后一行，第一列，最后一列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
        cell.setCellValue(titleName);
        //创建第二行，对应columnName = {"商品名称","商品销量"};
        HSSFRow row = sheet.createRow(1);
        for (int i = 0;i<2;i++){
            row.createCell(i).setCellValue((columnName[i]));
        }
        //创建第三行及以下，数据行
        for (int i = 0;i<dataList.length;i++){//二维数组的长度就是行的长度
            row = sheet.createRow(i+2);
            for (int j = 0;j<2;j++){
                row.createCell(j).setCellValue(dataList[i][j]);
            }
        }

        String fileName = filename + ".xls";
        response.setContentType("application/ms-excel;charset=UTF-8");//设置响应回去的响应内容
        response.setHeader("content-Disposition","attachment;filename="+processFileName(request,fileName));
        OutputStream out = response.getOutputStream();
        wb.write(out);
    }

}
