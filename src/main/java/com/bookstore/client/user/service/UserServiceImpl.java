package com.bookstore.client.user.service;

import com.bookstore.client.user.dao.IUserDao;
import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;
import com.bookstore.commons.beans.User;
import com.bookstore.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  IUserDao userDao;
    @Override
    public int addUser(User user, HttpServletRequest request) {
      String emailMsg="感谢您注册网上书城，请复制该地址=>localhost:8080"+
              request.getContextPath()+"/client/user/activeUser?activeCode="+user.getActiveCode()+"<=进行激活后使用";
      try {
        MailUtil.sendMail(user.getEmail(),emailMsg);//两个参数：第一个往哪个邮箱发邮件，即注册的邮件，第二个邮件的内容
      } catch (MessagingException e) {
        e.printStackTrace();
      }
      return userDao.insertUser(user) ;
    }

  @Override
  public int activeUser(String activeCode) {
    return userDao.activeUser(activeCode);
  }

  @Override
  public User findEmail(String email) {
    return userDao.selectEmail(email);
  }

  @Override
  public User findUsername(String username) {
    return userDao.selectUsername(username);
  }

  @Override
  public User findUserByLogin(User user) {
    return userDao.selectUserByLogin(user);
  }

  @Override
  public int modifyUser(User user) {
    return userDao.updateUser(user);
  }

  @Override
  public List<Order> findOrderByUser(Integer id) {
    return userDao.selectOrderByUser(id);
  }

  @Override
  public List<OrderItem> findOrderItemById(String id) {
    return userDao.selectOrderItemById(id);
  }
/*删除订单*/
  @Override
  public void removeOrderById(String id, String flag) {
    if(flag==null){
      //加回库存
      List<OrderItem> items=userDao.selectOrderItemById(id);
      for(OrderItem item:items){
        userDao.updateProductnum(item);
      }

    }
    //删除订单和订单项
    userDao.deleteOrderById(id);
    userDao.deleteOrderItemById(id);

  }

}
