package com.book.web;

import com.book.pojo.Cart;
import com.book.pojo.User;
import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import com.book.utils.CharsetUtils;
import com.book.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author lijichen
 * @date 2020/10/13 - 19:03
 */
public class UserServlet extends BaseServlet {

    private static UserService userService = new UserServiceImpl();

    /**
     * 查看用户名是否存在
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean existsUsername = userService.existsUsername(req.getParameter("username"));

        Map<String,Object> map = new HashMap<>();
        map.put("existsUsername",existsUsername);

        resp.getWriter().write(new Gson().toJson(map));

    }
    /**
     * 注销的模块
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/pages/user/login_success.jsp");
    }
    /**
     * 登录的模块
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        user = userService.login(user);

        //判断是否正确
        if (user == null) {

            //提示信息错误
            req.setAttribute("msg","用户名或密码错误!");
            req.setAttribute("username",user.getUsername());
            req.setAttribute("password",user.getPassword());

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            System.out.println("登录成功！");
            //清空request的username和password
//            req.setAttribute("username",null);
//            req.setAttribute("password",null);
            /*
             * 人性化登录
             * 下次登录免密码
             * */
            //创建cookie
            Cookie cookie = new Cookie("username",user.getUsername());
            Cookie cookie1 = new Cookie("password",user.getPassword());
            //设置有效时间为一周
            cookie.setMaxAge(60 * 60 * 24 * 7);
            cookie1.setMaxAge(60 * 60 * 24 * 7);
            //设置只能登录页面查看
            cookie.setPath(req.getContextPath() + "/pages/user");
            cookie1.setPath(req.getContextPath() + "/pages/user");
            //通知客户端
            resp.addCookie(cookie);
            resp.addCookie(cookie1);

            /*
            * 保存用户到客户端
            * */
            req.getSession().setAttribute("user",user);
            //判断跳转到那个页面
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            if (cart != null && cart.getItems().size() > 0) {
                req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req,resp);
                return;
            }
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    /**
     * 注册的模块
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CharsetUtils.setServletCharset(req,resp);

        /*
        * 使用谷歌验证码验证
        * */
        String kaptcha = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //马上删除session中的 验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //获取code，比较是否是第一次提交
        String code = req.getParameter("code");


        //获取参数
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        //先判断验证码是否为abcd
        if (kaptcha != null && kaptcha.equalsIgnoreCase(code)) {
            //正确 -》流程
            //用户名是否存在
            if (userService.existsUsername(user.getUsername())) {

                req.setAttribute("msg","用户名已存在！");

                req.setAttribute("username",user.getUsername());
                req.setAttribute("password",user.getPassword());
                req.setAttribute("email",user.getEmail());
                req.setAttribute("code",code);
                //存在流程
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

            } else {
                //不存在流程
                userService.regisUser(user);

                //注册成功后重定向页面
                resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
            }
        } else {
            req.setAttribute("msg","验证码错误！");


            req.setAttribute("username",user.getUsername());
            req.setAttribute("password",user.getPassword());
            req.setAttribute("email",user.getEmail());
            req.setAttribute("code",code);

            //验证码的错误流程
//            resp.sendRedirect(req.getContextPath() + "/pages/user/regist.jsp");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);


//            resp.getWriter().write("阿斯顿发送到发送到发");
//            resp.getWriter().write("<script type=\"text/javascript\">alert('aaa')</script>");
        }
    }
}
