package org.review.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的资源路径
        System.out.println(req.getRequestURI());
        //获取请求的资源路径绝对路径,统一资源定位符
        System.out.println(req.getRequestURL());
        //获取客户端地址
        System.out.println(req.getRemoteHost());
        // 获取请求头 ：User-Agent
        System.out.println(req.getHeader("User-Agent"));
        // 获取请求的方式
        System.out.println(req.getMethod());
    }
}
