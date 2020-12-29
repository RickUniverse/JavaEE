package com.book.dao.impl;

import com.book.dao.UserDao;
import com.book.pojo.User;

/**
 * 实现类
 * @author lijichen
 * @date 2020/10/10 - 19:31
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User use) {
        String sql = "insert into t_user(`username`, `password`, `email`) value(?,?,?)";
        return update(sql,use.getUsername(),use.getPassword(),use.getEmail());
    }
}
