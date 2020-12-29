package org.review.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author lijichen
 * @date 2020/10/11 - 19:12
 */
public class MyServletContextListener implements ServletContextListener {

    /*
    * 在servletcontext对象创建之后马上调用
    * */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("servletcontext init！！");
    }
    /*
     * 在servletcontext对象销毁之后调用
     * */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servletcontext destroy!!");
    }
}
