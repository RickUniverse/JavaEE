package org.review.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现httpservlet类实现servlet程序
 * @author lijichen
 * @date 2020/10/9 - 15:59
 */
public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        /*
        * 重写init方法之后需要调用父类的保存servletconfig的方法
        * 这样不会丢失servletconfig信息
        * */
        super.init(config);
        System.out.println("重写了init方法！");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("helloservlet2 的doget方法");

        //获取当前servlet程序的配置文件
        ServletConfig servletConfig = getServletConfig();
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("helloservlet2 的dopost方法");
    }
}
