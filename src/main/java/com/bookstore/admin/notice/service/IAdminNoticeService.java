package com.bookstore.admin.notice.service;

import com.bookstore.commons.beans.Notice;

import java.util.List;

public interface IAdminNoticeService {

    List<Notice> findNotice();

    //Notice AddNoticeServlet( String title, String details);

    void deleteNoticeById(String id);

    void AddNoticeServlet(String title, String details);


    Notice findNoticeById(String id);



    void EditNoticeServlet(String id,String title,String details);
}
