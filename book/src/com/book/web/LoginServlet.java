package com.book.web;

import com.book.pojo.User;
import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.io.IOException;

/**
 * 废弃
 * @author lijichen
 * @date 2020/10/11 - 15:19
 */
@Deprecated
public class LoginServlet extends HttpServlet {

    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //判断是否正确
        if (userService.login(new User(0,username,password,"")) == null) {

            //提示信息错误
            req.setAttribute("msg","用户名或密码错误!");
            req.setAttribute("username",username);
            req.setAttribute("password",password);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            System.out.println("登录成功！");

            //清空request的username和password
            req.setAttribute("username",null);
            req.setAttribute("password",null);

            /*
            * 人性化登录
            * 下次登录免密码
            * */
            //创建cookie
            Cookie cookie = new Cookie("username",username);
            Cookie cookie1 = new Cookie("password",password);
            //设置有效时间为一周
            cookie.setMaxAge(60 * 60 * 24 * 7);
            cookie1.setMaxAge(60 * 60 * 24 * 7);
            //设置只能登录页面查看
            cookie.setPath(req.getContextPath() + "/pages/user");
            cookie1.setPath(req.getContextPath() + "/pages/user");
            //通知客户端
            resp.addCookie(cookie);
            resp.addCookie(cookie1);

            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
