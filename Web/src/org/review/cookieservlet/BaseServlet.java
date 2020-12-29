package org.review.cookieservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 抽取共有的方法，如post
 * @author lijichen
 * @date 2020/10/13 - 19:46
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接收参数判断是什么操作
        String action = req.getParameter("action");

        //使用反射获取方法然后调用
        try {
            //第一个参数是方法名，第二个参数是该方法参数的类型，第三个同第二
            Method method = method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //执行对应的方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*if ("login".equals(action)) {
            //登录操作
            login(req,resp);
        } else if ("regist".equals(action)) {
            //注册操作
            regist(req,resp);
        }*/

    }
}
