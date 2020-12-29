package com.book.web;

import com.book.pojo.Book;
import com.book.pojo.Page;
import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import com.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lijichen
 * @date 2020/10/14 - 17:08
 */
public class BookServlet extends BaseServlet {

    private static BookService bookService = new BookServiceImpl();

    /**
     * 分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取页码和分页条数
        Integer pageNo = WebUtils.parseInteger(req.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInteger(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //调用分页获取item
        Page<Book> page = bookService.queryPageByBeginAndPageSize(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        //添加到request域中
        req.setAttribute("page",page);
        //请求转发
        req.getRequestDispatcher("/pages/manager/manager.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //添加图书
        //注入bean
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.add(book);
        //使用重定向
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" +
                (WebUtils.parseInteger(req.getParameter("pageNo"),1) + 1));
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        req.getParameter("id");
        bookService.deleteBook(WebUtils.parseInteger(req.getParameter("id"),0));
        //重定向
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" +
                WebUtils.parseInteger(req.getParameter("pageNo"),1));
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //修改book
        bookService.updateBook(WebUtils.copyParamToBean(req.getParameterMap(),new Book()));
        //重定向跳转到list展示页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" +
                WebUtils.parseInteger(req.getParameter("pageNo"),1));
    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //忘request域中放入数据
        req.setAttribute("book",bookService.queryBook(WebUtils.parseInteger(req.getParameter("id"),0)));
        //转发到页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //查询所有书,并添加到request域中
        req.setAttribute("books",bookService.queryBooks());

        //请求转发到页面
        req.getRequestDispatcher("/pages/manager/manager.jsp").forward(req,resp);
    }
}
