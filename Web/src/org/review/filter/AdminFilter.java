package org.review.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lijichen
 * @date 2020/10/19 - 14:52
 */
public class AdminFilter implements Filter {

    public AdminFilter(){
        System.out.println("构造器方法！");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init方法");
        System.out.println("filterConfig.getFilterName():" + filterConfig.getFilterName());
        System.out.println("filterConfig.getInitParameter(\"url\"):"+filterConfig.getInitParameter("url"));
        System.out.println("filterConfig.getInitParameter(\"username\"):"+filterConfig.getInitParameter("username"));
        System.out.println("filterConfig.getServletContext():"+filterConfig.getServletContext());
    }

    /**
     * doFiler用于拦截请求，可以做权限检查
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter方法");
        //转换类型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取用户
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            servletRequest.getRequestDispatcher("/pages/login.jsp").forward(servletRequest,servletResponse);
            return;
        } else {
            // 允许程序往下访问资源
            /*
            * 必须要有
            * */
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("destory销毁方法");
    }
}
