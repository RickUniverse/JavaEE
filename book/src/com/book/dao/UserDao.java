package com.book.dao;

import com.book.pojo.User;

/**
 * 用户接口
 * @author lijichen
 * @date 2020/10/10 - 19:25
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null表示用户名可用，反之不能
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码登录
     * @param username 用户名
     * @param password 密码
     * @return 如果返回null表示用户名或密码错误，否则可以登录
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 添加用户
     * @param use 包装需要添加的用户
     * @return 大于0表示添加成功，-1 为失败并报错
     */
    int saveUser(User use);
}
