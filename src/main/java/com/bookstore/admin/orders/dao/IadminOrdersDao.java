package com.bookstore.admin.orders.dao;

import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IadminOrdersDao {
    List<Order> selectOrders();

    List<Order> selectOrderByManyCondition(@Param("order") Order order);


    List<OrderItem> selectOrderItemById(String id);

    void deleteOrderById(String id);

    void deleteOrderItemById(String id);
}
