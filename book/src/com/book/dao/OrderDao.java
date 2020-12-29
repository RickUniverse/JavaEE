package com.book.dao;

import com.book.pojo.Order;

/**
 * @author lijichen
 * @date 2020/10/18 - 18:16
 */
public interface OrderDao {
    int saveOrder(Order order);
}
