package com.bookstore.client.products.handler;

import com.bookstore.client.products.service.IProductService;
import com.bookstore.commons.beans.Notice;
import com.bookstore.commons.beans.Product;
import com.bookstore.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("client/product")
public class ProduceHandler {
    @Autowired
    IProductService productService;
    //按照商品类别进行查询
    @RequestMapping("/findProductByCategory")
    public String findProductByCategory(@RequestParam(defaultValue = "1") int pageIndex, String category, Model model){
        PageModel pageModel=new PageModel();
        pageModel.setPageIndex(pageIndex);
       List<Product> products= productService.findProductByCategory(category,pageModel);
       int recordCount=productService.findProductCountByCategory(category);
       pageModel.setRecordCount(recordCount);
       model.addAttribute("category",category);
       model.addAttribute("products",products);
       model.addAttribute("pageModel",pageModel);
       return "/client/product_list.jsp";
    }
    //按照商品名字进行查询
    @RequestMapping("/findProductByName")
    public String findProductByName(@RequestParam(defaultValue = "1") int pageIndex,Model model,PageModel pageModel,String name){
        PageModel pageModel1= new PageModel();
        pageModel.setPageIndex(pageIndex);

      List<Product> products=  productService.findProductByName(name,pageModel);
      int recordCount=productService.findProductByNameCount(name);
      pageModel.setRecordCount(recordCount);

     //查出来之后，需要把products放到model中
        model.addAttribute("products",products);
        //查询出书本数量后，也需要把查询出来的pageModel放到model域中
        model.addAttribute("pageModel",pageModel);
        //进行数据回显，在搜索框中，输入“java”，查询后仍显示“java”
        model.addAttribute("name",name);
        return "/client/product_search_list.jsp";
    }
    /*查询图书的详细信息*/
    @RequestMapping("/findProductById")
    public  String findProductById(String id,Model model){
        Product product=productService.findProductById(id);
        model.addAttribute("p",product);
        return "/client/info.jsp";

    }
    /*首页显示页面*/
    @RequestMapping("/showIndex")
    public String showIndex(Model model){
      Notice notice=  productService.findNoticeRecent();//查找最新的相关信息
        model.addAttribute("n",notice);
//        查询本周热卖
      List<Product> products=  productService.findWeekHotProduct();
      model.addAttribute("products",products);
        return "/client/index.jsp";
    }
}
