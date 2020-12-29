package com.book.web;

import com.book.pojo.User;
import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 废弃
 * @author lijichen
 * @date 2020/10/11 - 14:28
 */
@Deprecated
public class RegistServlet extends HttpServlet {

    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //先判断验证码是否为abcd
        if ("abcd".equalsIgnoreCase(code)) {
            //正确 -》流程
            //用户名是否存在
            if (userService.existsUsername(username)) {

                req.setAttribute("msg","用户名已存在！");

                req.setAttribute("username",username);
                req.setAttribute("password",password);
                req.setAttribute("email",email);
                req.setAttribute("code",code);
                //存在流程
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else {
                //不存在流程
                userService.regisUser(new User(0,username,password,email));

                //注册成功后跳转页面
                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
            }
        } else {
            req.setAttribute("msg","验证码错误！");

            req.setAttribute("username",username);
            req.setAttribute("password",password);
            req.setAttribute("email",email);
            req.setAttribute("code",code);
            //错误流程
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
