package org.review.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 实现servlet接口实现servlet程序
 * @author lijichen
 * @date 2020/10/9 - 14:45
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1，构造器方法被调用");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2,init实例化");
        //获取servlet的别名
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);
        //获取初始化参数
        String username = servletConfig.getInitParameter("username");
        System.out.println(username);
        String url = servletConfig.getInitParameter("url");
        System.out.println(url);
        //获取servletcontext对象
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /*
    * 服务器主要访问的方法
    * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3，service方法被访问了");
        //子接口有getMethod方法能得到请求的类型
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if (method.equals("GET")) {
            doGet();
        } else if (method.equals("POST")) {
            doPost();
        }
    }

    //get请求
    public void doGet() {
        System.out.println("做get请求");
        System.out.println("做get请求");
    }

    //post请求
    public void doPost() {
        System.out.println("做post请求");
        System.out.println("做post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4,destroy销毁");
    }
}
