package com.book.service;

import com.book.pojo.Cart;

/**
 * @author lijichen
 * @date 2020/10/18 - 18:35
 */
public interface OrderService {
    String createOrder(Cart cart, Integer userId);
}
