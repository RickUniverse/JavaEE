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

/**
 * @author lijichen
 * @date 2020/10/16 - 15:21
 */
public class ClientBookServlet extends BaseServlet {

    private static BookService bookService = new BookServiceImpl();

    /**
     * 分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("client");
        //获取页码和分页条数
        Integer pageNo = WebUtils.parseInteger(req.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInteger(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //调用分页获取item
        Page<Book> page = bookService.queryPageByBeginAndPageSize(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        //添加到request域中
        req.setAttribute("page",page);
        //请求转发
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }



    /**
     * 按照价格分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取最大价格和最小价格
        Integer minPrice = WebUtils.parseInteger(req.getParameter("minPrice"), 0);
        Integer maxPrice = WebUtils.parseInteger(req.getParameter("maxPrice"), Integer.MAX_VALUE);
        //获取页码和分页条数
        Integer pageNo = WebUtils.parseInteger(req.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInteger(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //调用分页获取item
        Page<Book> page = bookService.queryPageByBeginAndPageSize(minPrice,maxPrice,pageNo,pageSize);
        //解决分页丢失价格
        StringBuilder url = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (minPrice != null) {
            url.append("&minPrice=").append(minPrice);
        }
        if (maxPrice != null) {
            url.append("&maxPrice=").append(maxPrice);
        }
        //解决分页丢失价格2
//        page.setUrl("client/bookServlet?action=pageByPrice&minPrice="+minPrice+"&maxPrice="+maxPrice+"");
        //添加到request域中
        req.setAttribute("page",page);
        //请求转发
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }



}
