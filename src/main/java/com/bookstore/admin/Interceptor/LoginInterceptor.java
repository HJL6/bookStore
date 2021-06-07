package com.bookstore.admin.Interceptor;

import com.bookstore.commons.beans.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    //在还没有登录之前的一些预处理
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURI();
        //如果请求的路径以login的处理器 则放行
        //拦截器只会拦截处理器方法
        if(url.endsWith("/login")||url.endsWith("logout")){
            return true;
        }
       User login_user= (User) request.getSession().getAttribute("login_user");
        if(login_user!=null){
            if("超级用户".equals(login_user.getRole())){
                return true;
            }else{
                response.sendRedirect(request.getContextPath()+"/admin/error/privilege.jsp");
                return false;
            }
        }else{//当前用户没有登录
            response.sendRedirect(request.getContextPath()+"/admin/error/privilege.jsp");
            return false;
        }

    }
}
