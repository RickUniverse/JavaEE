package org.review.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get请求不需要处理编码集
        String name = request.getParameter("name");
        String[] hoppies = request.getParameterValues("hoppy");

        System.out.println(name);
        System.out.println(Arrays.asList(hoppies));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post请求需要处理
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String[] hoppies = request.getParameterValues("hoppy");

        System.out.println(name);
        System.out.println(Arrays.asList(hoppies));
    }
}
