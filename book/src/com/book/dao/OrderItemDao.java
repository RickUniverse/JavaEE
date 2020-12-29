package com.book.dao;

import com.book.pojo.OrderItem;

/**
 * 订单项表
 * @author lijichen
 * @date 2020/10/18 - 18:20
 */
public interface OrderItemDao {
    int saveOrderItem(OrderItem orderItem);
}
