package com.book.dao.impl;

import com.book.dao.OrderDao;
import com.book.pojo.Order;

/**
 * @author lijichen
 * @date 2020/10/18 - 18:16
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) VALUES(?,?,?,?,?)";
        return update(sql,order.getOrderId(),
                order.getCreateTime(),
                order.getPrice(),
                order.getStatus(),
                order.getUserId());
    }
}
