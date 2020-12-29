package org.review.util;

import javax.servlet.http.Cookie;

/**
 * @author lijichen
 * @date 2020/10/16 - 18:00
 */
public class CookieUtils {

    /**
     * 根据名字找到对应的cookie
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookieByName(String name, Cookie[] cookies) {
        if (name == null || name == "" || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
