package com.bookstore.admin.notice.handler.manager;

import com.bookstore.admin.notice.service.IAdminNoticeService;
import com.bookstore.commons.beans.Notice;
import com.bookstore.commons.beans.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/notice/manager")
public class NoticeHandler {
    @Autowired
    IAdminNoticeService adminNoticeService;
    @RequestMapping("/ListNoticeServlet")
    /*查询全部的公告信息*/
    public String ListNoticeServlet(Model model){
       List<Notice> notices= adminNoticeService.findNotice();
       model.addAttribute("notices",notices);

       return "/admin/notices/list.jsp";
    }
/*添加公告：*/
    @RequestMapping("/AddNoticeServlet")
    public String AddNoticeServlet(String title,String details,Model model){
        //Notice notice=adminNoticeService.AddNoticeServlet(title,details);
        //model.addAttribute("title",notice);
        //model.addAttribute("details",notice);
        adminNoticeService.AddNoticeServlet(title,details);

        return "/admin/notice/manager/ListNoticeServlet";
    }
    /*根据id进行公告编辑,先要查询到要修改的id信息，然后进行修改*/
    @RequestMapping("/findOrderById")
    public String findOrderById(String id,Model model){
        Notice notice=adminNoticeService.findNoticeById(id);
        model.addAttribute("n",notice);
        return "/admin/notices/edit.jsp";
    }
    /*进行公告的修改*/
    @RequestMapping("/EditNoticeServlet")
    public String EditNoticeServlet(String id,String title,String details){
        adminNoticeService.EditNoticeServlet(id,title,details);

     return "/admin/notice/manager/ListNoticeServlet";
    }

    /*公告删除*/
@RequestMapping("/DeleteNoticeServlet")
    public String DeleteNoticeServlet(String id){
    adminNoticeService.deleteNoticeById(id);
    return "/admin/notice/manager/ListNoticeServlet";

}
}
