package com.book.web;

import com.book.pojo.Cart;
import com.book.pojo.User;
import com.book.service.OrderService;
import com.book.service.impl.OrderServiceImpl;
import com.book.utils.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lijichen
 * @date 2020/10/18 - 19:00
 */
public class OrderServlet extends BaseServlet {

    private static OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车内信息
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取用户信息
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        } else if (cart.getItems().size() == 0) {
            req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req,resp);
            return;
        }
        //生成订单
        /*
        * 事务操作
        * */
        String orderId = orderService.createOrder(cart, user.getId());

        //保存订单号
        req.getSession().setAttribute("orderId",orderId);
        //重定向到创建订单成功的页面
//        req.getRequestDispatcher("").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/cart_success.jsp");
    }
}
