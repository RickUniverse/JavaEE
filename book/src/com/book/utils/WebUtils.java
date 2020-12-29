package com.book.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 使用baseutils进行sql注入
 * @author lijichen
 * @date 2020/10/13 - 20:20
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 转换字符串为Integer类型数据，
     * @param parse 需要转换的值
     * @param defaultValue 转化失败的默认值
     * @return
     */
    public static Integer parseInteger(String parse, Integer defaultValue) {
        try {
            return Integer.valueOf(parse);
        } catch (NumberFormatException e) {
//            System.out.println(e.getMessage());
        }
        return defaultValue;
    }
}
