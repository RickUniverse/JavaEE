package com.book.utils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author lijichen
 * @date 2020/10/17 - 14:28
 */
public class CharsetUtils {
    public static void setServletCharset(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
        } catch (UnsupportedEncodingException e) {

        }
    }
}
