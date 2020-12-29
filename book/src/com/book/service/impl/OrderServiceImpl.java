package com.book.service.impl;

import com.book.dao.BookDao;
import com.book.dao.OrderDao;
import com.book.dao.OrderItemDao;
import com.book.dao.impl.BookDaoImpl;
import com.book.dao.impl.OrderDaoImpl;
import com.book.dao.impl.OrderItemDaoImpl;
import com.book.pojo.*;
import com.book.service.OrderService;

import java.util.Date;

/**
 * @author lijichen
 * @date 2020/10/18 - 18:36
 */
public class OrderServiceImpl implements OrderService {

    private static OrderDao orderDao = new OrderDaoImpl();
    private static OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private static BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        //生成订单号
        String orderId = System.currentTimeMillis() + "" + userId;
        //生成订单
        orderDao.saveOrder(new Order(orderId, new Date(),cart.getTotalPrice(),0,userId));

        //模拟错误
        int wrong = 1 / 0;

        //巡皇生成订单项，生成订单项
        for (CartItem cartItem : cart.getItems().values()) {
            orderItemDao.saveOrderItem(new OrderItem(null,cartItem.getName(),
                    cartItem.getCount(),
                    cartItem.getPrice(),
                    cartItem.getTotalPrice(),
                    orderId));
            //修改每个书的价格
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
            System.out.println(book);
        }
        //清空购物车
        cart.clear();
        //返回订单id
        return orderId;
    }
}
