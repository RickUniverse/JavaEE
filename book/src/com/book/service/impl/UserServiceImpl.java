package com.book.service.impl;

import com.book.dao.UserDao;
import com.book.dao.impl.UserDaoImpl;
import com.book.pojo.User;
import com.book.service.UserService;

/**
 * @author lijichen
 * @date 2020/10/11 - 13:47
 */
public class UserServiceImpl implements UserService {

    private static UserDao userDao = new UserDaoImpl();

    @Override
    public void regisUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String name) {
        return userDao.queryUserByUsername(name) == null ? false : true;
    }
}
