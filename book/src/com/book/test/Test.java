package com.book.test;

import com.book.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lijichen
 * @date 2020/10/13 - 20:53
 */
public class Test {
    public static void main(String[] args) {
        User user = new User();
        Map map = new HashMap();
        map.put("username","asdf");
        try {
            BeanUtils.populate(user, map);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
