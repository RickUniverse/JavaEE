package org.review.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        System.out.println("保存前："+servletContext.getAttribute("key1"));
        servletContext.setAttribute("key1","你好！");
        System.out.println("保存后："+servletContext.getAttribute("key1"));
        System.out.println("servletcontext实例！");
        System.out.println(servletContext);
    }
}
