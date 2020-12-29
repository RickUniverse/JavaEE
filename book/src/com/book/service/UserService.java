package com.book.service;

import com.book.pojo.User;

/**
 *
 * @author lijichen
 * @date 2020/10/11 - 13:43
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void regisUser(User user);

    /**
     * 登录
     * @param user
     * @return 登陆成功返回一个user，失败返回null
     */
    public User login(User user);

    /**
     *查询用户名是否存在
     * @param name
     * @return 如果存在返回true，不存在返回false
     */
    public boolean existsUsername(String name);
}
