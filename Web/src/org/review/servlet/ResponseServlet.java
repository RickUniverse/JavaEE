package org.review.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //修改服务器响应编码
//        response.setCharacterEncoding("UTF-8");
//        //修改浏览器接收数据的编码,响应头
//        response.setHeader("Content-Type","text/html; charset=UTF-8");

//        //同时设置服务器编码和响应头
//        response.setContentType("text/html; charset=UTF-8");
//        //响应数据
//        response.getWriter().write("response·s context！响应数据");

//        //请求重定向
//        response.setStatus(302);//设置响应状态码
//        //设置响应头说明新的地址在哪
//        response.setHeader("Location","http://www.baidu.com");

        response.sendRedirect("http://www.baidu.com");

    }
}
