package org.review.cookieservlet;

import org.review.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lijichen
 * @date 2020/10/16 - 17:28
 */
public class CookieServlet extends BaseServlet {

    /**
     * 创建cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        //创建cookie
        Cookie cookie = new Cookie("key1", "value121");
        Cookie cookie2 = new Cookie("key2", "value222");
        /*
        * 如果已经有JSESSIONID则会再次创建一个
        * */
        Cookie JSESSIONID = new Cookie("JSESSIONID", "23232");

        //通知客户端保存修改
        resp.addCookie(cookie);
        resp.addCookie(cookie2);
        resp.addCookie(JSESSIONID);

        resp.getWriter().write("cookie创建成功！");
    }

    /**
     * 获取cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write(cookie.getName() + "==" + cookie.getValue() + "<br/>");
        }

        Cookie iWantCookie = CookieUtils.findCookieByName("key1",cookies);

        resp.getWriter().write("找到了：" + iWantCookie.getName() + "==" + iWantCookie.getValue() + "<br/>");
    }
    /**
     * 修改cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        Cookie cookie = CookieUtils.findCookieByName("key1", req.getCookies());
        //如果不为空
        if (cookie != null) {
            cookie.setValue("newValue");
            resp.addCookie(cookie);
        }
    }
    /**
     * cookie默认存活时间
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife","defaultLife");
        //默认值就是-1，浏览器关闭后销毁，（会话结束）
        cookie.setMaxAge(-1);
        //通知浏览器更新信息
        resp.addCookie(cookie);
    }
    /**
     * 马上删除cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("deleteNow","deleteNow");
        //马上删除
        cookie.setMaxAge(0);
        //通知浏览器更新信息
        resp.addCookie(cookie);
    }
    /**
     * 一个小时存活时间的cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600","life3600");
        //一个小时后
        cookie.setMaxAge(60 * 60);
        //通知浏览器更新信息
        resp.addCookie(cookie);
    }
    /**
     * 设置cookie有效路径
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("testPath","testPath");
        //设置cookie有效路径
        cookie.setPath(req.getContextPath() + "/test");
        //通知浏览器更新信息
        resp.addCookie(cookie);
    }
}
