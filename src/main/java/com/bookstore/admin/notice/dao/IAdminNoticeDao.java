package com.bookstore.admin.notice.dao;

import com.bookstore.commons.beans.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAdminNoticeDao {
    List<Notice> selectNotice();

   /* Notice insertNotice(@Param("title") String title, @Param("details") String details );*/


    void deleteNoticeById(String id);

    void insertNotice(@Param("title") String title, @Param("details") String details);


    Notice selectNoticeById(String id);





    void updateNoticeServlet(@Param("id") String id,@Param("title") String title,@Param("details") String details);
}
