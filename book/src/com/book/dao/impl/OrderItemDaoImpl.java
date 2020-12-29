package com.book.dao.impl;

import com.book.dao.OrderItemDao;
import com.book.pojo.OrderItem;

/**
 * @author lijichen
 * @date 2020/10/18 - 18:22
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) VALUES(?,?,?,?,?)";
        return update(sql,orderItem.getName(),
                orderItem.getCount(),
                orderItem.getPrice(),
                orderItem.getTotalPrice(),
                orderItem.getOrderId());
    }
}
