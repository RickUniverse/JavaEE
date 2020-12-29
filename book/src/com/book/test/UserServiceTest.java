package com.book.test;

import com.book.pojo.User;
import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    private static UserService userService = new UserServiceImpl();
    @Test
    public void regisUser() {
        userService.regisUser(new User(1,"aa","ddd","sss"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(0, "admin", "admin", "s")));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("admins"));
    }
}