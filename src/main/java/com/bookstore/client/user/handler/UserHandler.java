package com.bookstore.client.user.handler;

import com.bookstore.client.user.service.IUserService;
import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;
import com.bookstore.commons.beans.User;
import com.bookstore.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/client/user")
public class UserHandler {
    @Autowired
    IUserService userService;
    @RequestMapping("/register")
    public String register(User user, String checkCode, HttpSession session, HttpServletRequest request){
        user.setActiveCode(IdUtils.getUUID());
        //从session中获取校验码
        String checkcode_session= (String) session.getAttribute("checkcode_session");
        //判断校验码是否正确
        if(checkcode_session.equals(checkCode)){
        int rows= userService.addUser(user,request);
        if(rows>0){
            return "redirect:/client/registersuccess.jsp";
        }
        else{
            request.setAttribute("fail","新用户注册失败，请重试");
            return  "/client/register.jsp";
        }
        }else{//校验码不正确
            request.setAttribute("check_error","校验码错误，请重新输入");
             return  "/client/register.jsp";
        }
    }
    //用户激活
    @RequestMapping("/activeUser")
    public String activeUser(String activeCode){
        System.out.println("激活码为"+activeCode);
        //开始判断有没有激活成功
        int rows= userService.activeUser(activeCode);
        if(rows>0){
            return "redirect:/client/activesuccess.jsp";
        }else{
            return "redirect:/client/activeFail.jsp";
        }

    }
    //检测注册邮箱是否被占用
    @RequestMapping("/findEmail")
    @ResponseBody
    public String findEmail(String email){
       // System.out.println("注册的邮箱:"+email);
       User user= userService.findEmail(email);
       if(user!=null){
           return "EXIST";
       }else{
           return "OK";
       }

    }
    @RequestMapping("/findUsername")
    @ResponseBody
    public String findUsername(String username){
      User user= userService.findUsername(username);
      if(user!=null){
          return "EXIST";
      }else {
          return "OK";
      }
    }

    //我的账户对应的方法
    @RequestMapping("/myAccount")
    public String myAccount(HttpSession session,HttpServletRequest request){//从session中获取信息
      User login_user= (User) session.getAttribute("login_user");//这里需要进行强制类型转换，因为从session中得到的都是Object类型
        if(login_user==null){//用户未登录
            //判断自动登录是否成功,调用自动登录方法
          login_user =autologin(request);
          if(login_user!=null){//如果自动登录成功，就到我的账户页面
              //自动登录成功，把登录用户信息放到session
              session.setAttribute("login_user",login_user);
              return "/client/myAccount.jsp";
          }
            return "/client/login.jsp";//点击我的账户到登录页面

        }else{//用户已登录
            return "/client/myAccount.jsp";//显示我的账户信息
        }
    }



    //用户登录且验证状态码是否为1
    @RequestMapping("/login")
    public String login(User user, String remember, String autologin,HttpServletRequest request, HttpServletResponse response,HttpSession session){

        //select 用户名，密码，return user
      User  login_user=userService.findUserByLogin(user);
      //登录完成后,进行登录到myAccount.jsp
      if(login_user!=null){//用户名密码都正确
          if(login_user.getState()==1){//且用户已激活
              if("1".equals(autologin)){
                 //save 用户名密码 -》cookie
                  addCookie(autologin,user,request,response);
              }
              else if("1".equals(remember)){
                  //save 用户名密码 -》cookie
                  addCookie(autologin,user,request,response);
              }
              //把查出来的信息放在session中
              session.setAttribute("login_user",login_user);
              return "/index.jsp";

          }else{//用户未激活
              request.setAttribute("login_error","用户未激活，请激活后使用");
              return "/client/login.jsp";
          }

      }else{//没有登录成功，进到login.jsp页面
         request.setAttribute("login_error","用户名或密码错误，请重新登录");
          return "/client/login.jsp";
      }
    }



    //第一步：把用户名保存到cookie，保存用户名和密码的方法
    //*1、先定义一个cookie对象*/
     public void addCookie(String autologin, User user, HttpServletRequest request, HttpServletResponse response){
        //记住用户名
         Cookie cookie1 = new Cookie("bookstore_username",user.getUsername());

         cookie1.setMaxAge(60*60*24*7);

         cookie1.setPath(request.getContextPath()+"/");

         response.addCookie(cookie1);
         //记住密码
         if("1".equals(autologin)){

             Cookie cookie2 = new Cookie("bookstore_password",user.getPassword());

             cookie2.setMaxAge(60*60*24*7);

             cookie2.setPath(request.getContextPath()+"/");

             response.addCookie(cookie2);
         }
     }
     //第二步：自动登录
    private User autologin(HttpServletRequest request) {
         String username=null;
         String password=null;
         //用cookie中获取值
       Cookie[] cookies= request.getCookies();//获取到全部的cookie信息
        for (Cookie cookie:cookies){
            if("bookstore_username".equals(cookie.getName())){
               username= cookie.getValue();
            }if("bookstore_password".equals(cookie.getName())){
                password=cookie.getValue();
            }
        }
        User user=new User();
        user.setUsername(username);//把从session获取的值赋值后user
        user.setPassword(password);
        userService.findUserByLogin(user);
        return userService.findUserByLogin(user);
    }

  //用户退出
    @RequestMapping("/logout")
    public String logout(HttpSession session,HttpServletRequest request,HttpServletResponse response, Model model){
         //从cookie中移除
         session.removeAttribute("login_user");
        //从cookie中移除保存的用户名
        Cookie cookie1 = new Cookie("bookstore_username",null);
        cookie1.setMaxAge(0);
        cookie1.setPath(request.getContextPath()+"/");
        response.addCookie(cookie1);
        //从cookie中移除保存的密码
        //创建cookie对象
        Cookie cookie2 = new Cookie("bookstore_password",null);
        cookie2.setMaxAge(0);
        cookie2.setPath(request.getContextPath()+"/");

        //通知客户端保存cookie
        response.addCookie(cookie2);
        model.addAttribute("login_error","用户退出成功，请重新登录!");
        return "/client/login.jsp";

    }
    //用户信息修改
    @RequestMapping("modifyUser")
    public String modifyUser(User user,HttpSession session,Model model){
      //从session中获取当前登录用户
        User login_user= (User) session.getAttribute("login_user");
       //把当前登录用户的id赋值给后台的user的id
        user.setId(login_user.getId());
        //再去调用service方法
       int rows= userService.modifyUser(user);
       if(rows>0){
           model.addAttribute("login_error","用户信息修改成功，请重新登录!");
           return "/client/login.jsp";
       }else{
           model.addAttribute("fail","用户信息修改失败，请重试!");
           return "client/modifyUserInfo.jsp";
       }
    }

    //订单查询
    @RequestMapping("/findOrderByUser")
    public String findOrderByUser(HttpSession session,Model model){
        User login_user = (User) session.getAttribute("login_user");
       List<Order> orders= userService.findOrderByUser(login_user.getId());
       model.addAttribute("orders",orders);
       return "/client/orderlist.jsp";
    }

    /*查看订单的详细信息*/
    @RequestMapping("/findOrderById")
    public String findOrderById(String id,Model model){
     List <OrderItem> items =userService.findOrderItemById(id);
     model.addAttribute("items",items);
     return "/client/orderInfo.jsp";
    }
    /*删除订单*/
    @RequestMapping("/removeOrderById")
    public String removeOrderById(String id,String flag) {
        userService.removeOrderById(id,flag);
        return "redirect:/client/user/findOrderByUser";
    }
}
