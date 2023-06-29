package com.bookstore.admin.orders.handler;

import com.bookstore.admin.orders.service.IadminOrdersService;
import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/orders")
public class OrdersHandler {
    @Autowired
    IadminOrdersService adminOrdersService;
    @RequestMapping("/findOrders")
    /*订单管理*/
    public String findOrders(Model model){
        //先查询出所有的订单
       List<Order> orders= adminOrdersService.findOrders();
       //查完之后把orders放在域对象，然后在页面中进行显示
        model.addAttribute("orders",orders);
       /* //检查查询的输出结果
        for(Order o:orders){
            System.out.println(o);
        }*/
        return "/admin/orders/list.jsp";

    }
    /*根据多个条件查询订单信息*/
    @RequestMapping("/findOrderByManyCondition")
    public String findOrderByManyCondition(Order order,Model model){//用来接收id和receiverName
       List<Order> orders= adminOrdersService.findOrderByManyCondition(order);
         model.addAttribute("orders",orders);
        return "/admin/orders/list.jsp";
    }
    /*查看订单的详细信息*/
    @RequestMapping("/findOrderById")
    public String findOrderById(String id,Model model){
       List<OrderItem> items=adminOrdersService.findOrderById(id);
        model.addAttribute("items",items);
        return "/admin/orders/view.jsp";
    }

    /*删除订单*/
    @RequestMapping("/removeOrderById")
    public String removeOrderById(String id){
        adminOrdersService.removeOrderById(id);
        return "/admin/orders/findOrders";

    }

}
