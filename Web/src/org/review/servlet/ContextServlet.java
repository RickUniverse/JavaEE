package org.review.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取上下文对象
        ServletContext servletContext = getServletConfig().getServletContext();
        //获取上下文配置信息
        String username = servletContext.getInitParameter("username");
        System.out.println(username+servletContext.getInitParameter("password"));
        // 获取项目根路径
        System.out.println(servletContext.getContextPath());
        //获取工程部署后在服务器硬盘上的绝对路径,/ 表示工程的web目录
        System.out.println(servletContext.getRealPath("/"));
        System.out.println(servletContext.getRealPath("/imgs/1.png"));
    }
}
