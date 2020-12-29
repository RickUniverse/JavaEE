package org.review.sessionservlet;

import org.review.cookieservlet.BaseServlet;
import org.review.util.CharsetUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lijichen
 * @date 2020/10/17 - 14:22
 */
public class SessionServlet extends BaseServlet {

    public void createAndGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CharsetUtils.setServletCharset(req,resp);

        //获取session会话
        HttpSession session = req.getSession();
        //获取session 的id
        String id = session.getId();
        //是否是新创建的session
        boolean aNew = session.isNew();

        resp.getWriter().write("id："+id+"<br/>");
        resp.getWriter().write("isNew："+aNew+"<br/>");
    }

    /**
     * 存值
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void setSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CharsetUtils.setServletCharset(req,resp);

        //获取session会话
        HttpSession session = req.getSession();
        //存值
        session.setAttribute("key1","value2");

        resp.getWriter().write("存值成功！");
    }
    /**
     * 取值
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void getSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CharsetUtils.setServletCharset(req,resp);

        //获取session会话
        HttpSession session = req.getSession();
        //存值
        Object key1 = session.getAttribute("key1");

        resp.getWriter().write("值是：" + key1);
    }
    /**
     * 默认生命
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CharsetUtils.setServletCharset(req,resp);

        //获取session会话
        HttpSession session = req.getSession();


        resp.getWriter().write("默认生命：" + session.getMaxInactiveInterval());
    }
    /**
     * 设置生命
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void setLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CharsetUtils.setServletCharset(req,resp);

        //获取session会话
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(3);

        resp.getWriter().write("生命值是：" + session.getMaxInactiveInterval());
    }
    /**
     * 取值
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CharsetUtils.setServletCharset(req,resp);

        //获取session会话
        HttpSession session = req.getSession();

        session.invalidate();

        resp.getWriter().write("session已经失效，生命值是：" + session.getMaxInactiveInterval());
    }
}
