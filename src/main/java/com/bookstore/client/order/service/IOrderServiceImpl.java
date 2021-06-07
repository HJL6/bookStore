package com.bookstore.client.order.service;

import com.bookstore.client.order.dao.IOrderDao;
import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;
import com.bookstore.commons.beans.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class IOrderServiceImpl implements IOrderService{
    @Resource
    IOrderDao orderDao;
    @Override
    public void CreateOrder(Order order, Map<Product, Integer> cart) {
        for(Product p:cart.keySet()){
            OrderItem item=new OrderItem();
            item.setProduct(p);
            item.setOrder(order);
            item.setBuynum(cart.get(p));
            orderDao.insertOrderItem(item);
            //插入订单后，修改库存
            orderDao.updateProductnum(item);
        }

        orderDao.insertOrder(order);
    }

    @Override
    public void paySuccess(String order_id) {
        orderDao.updatePaystate(order_id);
    }
}
