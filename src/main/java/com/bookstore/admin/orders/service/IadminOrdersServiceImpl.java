package com.bookstore.admin.orders.service;

import com.bookstore.admin.orders.dao.IadminOrdersDao;
import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class IadminOrdersServiceImpl implements IadminOrdersService{
    @Resource
    IadminOrdersDao adminOrdersDao;
    @Override
    public List<Order> findOrders() {
        return adminOrdersDao.selectOrders();
    }

    @Override
    public List<Order> findOrderByManyCondition(Order order) {
        return adminOrdersDao.selectOrderByManyCondition(order);
    }

    @Override
    public List<OrderItem> findOrderById(String id) {
        return adminOrdersDao.selectOrderItemById(id);
    }

    @Override
    public void removeOrderById(String id) {
           adminOrdersDao.deleteOrderById(id);
           adminOrdersDao.deleteOrderItemById(id);
    }


}
