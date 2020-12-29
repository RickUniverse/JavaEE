package org.review.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lijichen
 * @date 2020/10/19 - 15:58
 */
public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("filter2前置代码");
        System.out.println("filter2线程名：" + Thread.currentThread().getName());
        System.out.println("filter2获取请求的参数：" + servletRequest.getParameter("param"));
        System.out.println("filter2获取filter1保存的参数：" + servletRequest.getAttribute("key1"));

        //这一行很重要
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("filter2线程名：" + Thread.currentThread().getName());
        System.out.println("filter2后置代码");

    }

    @Override
    public void destroy() {

    }
}
