package com.book.web;

import com.book.pojo.Book;
import com.book.pojo.Cart;
import com.book.pojo.CartItem;
import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import com.book.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lijichen
 * @date 2020/10/18 - 15:12
 */
public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 修改数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的客户端的session内的购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            //修改
            cart.updateCount(
                    WebUtils.parseInteger(req.getParameter("id"),0),
                    WebUtils.parseInteger(req.getParameter("count"),1)
            );
        }
        //重定向回请求的页面
        resp.sendRedirect(req.getHeader("Referer"));
    }
    /**
     * 清空购物车内商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的客户端的session内的购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
        }
        //重定向回请求的页面
        resp.sendRedirect(req.getHeader("Referer"));
    }
    /**
     * 删除购物车内商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的客户端的session内的购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            //删除
            cart.delete(WebUtils.parseInteger(req.getParameter("id"),0));
        }
        //重定向回请求的页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 添加商品到购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要添加的商品
        Book book = bookService.queryBook(WebUtils.parseInteger(req.getParameter("id"), 0));

        //添加购物车项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //创建购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            //如果没有就创建一个，并加入到session域中
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        //最后添加的商品名
        req.getSession().setAttribute("lastName",book.getName());

        cart.addItem(cartItem);
        //重定向到原来的页面
        resp.sendRedirect(req.getHeader("Referer"));

    }
    /**
     * 使用ajax添加商品到购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要添加的商品
        Book book = bookService.queryBook(WebUtils.parseInteger(req.getParameter("id"), 0));

        //添加购物车项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //创建购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            //如果没有就创建一个，并加入到session域中
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        //最后添加的商品名
        req.getSession().setAttribute("lastName",book.getName());

        cart.addItem(cartItem);

        Map<String,Object> map = new HashMap<>();
        map.put("totalCount",cart.getTotalCount());
        map.put("addLastName",book.getName());

        resp.getWriter().write(new Gson().toJson(map));
    }
}
