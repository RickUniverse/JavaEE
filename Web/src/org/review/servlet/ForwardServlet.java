package org.review.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String username = request.getParameter("username");
        System.out.println("servlet1 get " + username);
        //模仿盖章
        request.setAttribute("key"+username , "ok");

        //转发 （问路怎么走）
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/forwardServlet2");
        // 向forwardServlet2 走
        requestDispatcher.forward(request,response);

    }
}
