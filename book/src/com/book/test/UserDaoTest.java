package com.book.test;

import com.book.dao.UserDao;
import com.book.dao.impl.UserDaoImpl;
import com.book.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    UserDao userImpl = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        System.out.println(userImpl.queryUserByUsername("admin"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userImpl.queryUserByUsernameAndPassword("admin", "admin"));
    }

    @Test
    public void saveUser() {
        System.out.println(userImpl.saveUser(new User(0,"admin123","ss","ss")));
    }
}