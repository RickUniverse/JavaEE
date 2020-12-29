package com.book.test;

import com.book.pojo.Cart;
import com.book.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"qwe",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"qwe",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"qwe2",1,new BigDecimal(100),new BigDecimal(100)));

        System.out.println(cart);
    }

    @Test
    public void delete() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"qwe",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"qwe",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"qwe2",1,new BigDecimal(100),new BigDecimal(100)));

        cart.delete(2);

        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"qwe",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"qwe",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"qwe2",1,new BigDecimal(100),new BigDecimal(100)));

        cart.delete(2);
        cart.clear();

        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"qwe",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"qwe",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"qwe2",1,new BigDecimal(100),new BigDecimal(100)));

        cart.updateCount(1,10);

        System.out.println(cart);
    }
}