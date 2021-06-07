package com.bookstore.utils;

import com.bookstore.commons.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class LoginTag extends SimpleTagSupport {
    //自定义标签

    @Override
    public void doTag() throws JspException, IOException {
        //判断用户有没有登录
        //为了获取session可以先获取PageContext
        PageContext context= (PageContext) this.getJspContext();
        HttpServletRequest request= (HttpServletRequest) context.getRequest();
        HttpServletResponse response= (HttpServletResponse) context.getResponse();
        //从session获取登录信息login_user
      User login_user= (User) context.getSession().getAttribute("login_user");
      //如果用户未登录，则重定向到权限不足的页面
      if(login_user==null){
          response.sendRedirect(request.getContextPath()+"/client/error/privilege.jsp");
      }
        super.doTag();
    }
}
