package com.book.filter;

import com.book.utils.JDBCUtil;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lijichen
 * @date 2020/10/19 - 19:10
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest,servletResponse);
            //提交事务
            JDBCUtil.commitAndClose();
        } catch (Exception e) {
            //回滚事务
            JDBCUtil.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);//将错误抛给tomcat，让tomcat显示错误页面
        }

    }

    @Override
    public void destroy() {

    }
}
