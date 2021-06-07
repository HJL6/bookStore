package com.bookstore.admin.notice.service;

import com.bookstore.admin.notice.dao.IAdminNoticeDao;
import com.bookstore.admin.orders.service.IadminOrdersService;
import com.bookstore.commons.beans.Notice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class IAdminNoticeServiceImpl implements IAdminNoticeService {
    @Resource
    IAdminNoticeDao adminNoticeDao;
    @Override
    public List<Notice> findNotice() {
        return adminNoticeDao.selectNotice();
    }

  /*  @Override
    public Notice AddNoticeServlet(String title, String details) {
        return adminNoticeDao.insertNotice(title,details);
    }*/

    @Override
    public void deleteNoticeById(String id) {
      adminNoticeDao.deleteNoticeById(id);
    }

    @Override
    public void AddNoticeServlet(String title, String details) {
        adminNoticeDao.insertNotice(title,details);
    }

    @Override
    public Notice findNoticeById(String id) {
        return adminNoticeDao.selectNoticeById(id);
    }

    @Override
    public void EditNoticeServlet(String id,String title,String details) {
        adminNoticeDao.updateNoticeServlet(id,title,details);
    }




}
