package com.book.test;

import com.book.pojo.Cart;
import com.book.pojo.CartItem;
import com.book.service.OrderService;
import com.book.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"qwe",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"qwe",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"qwe2",1,new BigDecimal(100),new BigDecimal(100)));

        System.out.println(orderService.createOrder(cart, 1));
    }
}