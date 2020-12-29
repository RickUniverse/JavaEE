package org.review.ajaxservlet;

import com.google.gson.Gson;
import org.review.json.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lijichen
 * @date 2020/10/20 - 16:03
 */
public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //响应数据
        Map<String, Person> personMap = new HashMap<>();
        personMap.put("one",new Person(1,"张三1！"));
        personMap.put("two",new Person(2,"张三2！"));
        personMap.put("three",new Person(3,"张三3！"));

        //响应数据
        resp.getWriter().write(new Gson().toJson(personMap));
    }
    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //响应数据
        Map<String, Person> personMap = new HashMap<>();
        personMap.put("one",new Person(1,"张三1！"));
        personMap.put("two",new Person(2,"张三2！"));
        personMap.put("three",new Person(3,"张三3！"));

        //响应数据
        resp.getWriter().write(new Gson().toJson(personMap));
    }
    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //响应数据
        Map<String, Person> personMap = new HashMap<>();
        personMap.put("one",new Person(1,"张三1！"));
        personMap.put("two",new Person(2,"张三2！"));
        personMap.put("three",new Person(3,"张三3！"));

        //响应数据
        resp.getWriter().write(new Gson().toJson(personMap));
    }
    protected void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //响应数据
        Map<String, Person> personMap = new HashMap<>();
        personMap.put("one",new Person(1,"张三1！"));
        personMap.put("two",new Person(2,"张三2！"));
        personMap.put("three",new Person(3,"张三3！"));

        //响应数据
        resp.getWriter().write(new Gson().toJson(personMap));
    }
    protected void jQueryGetSerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));

        //响应数据
        Map<String, Person> personMap = new HashMap<>();
        personMap.put("one",new Person(1,"张三1！"));
        personMap.put("two",new Person(2,"张三2！"));
        personMap.put("three",new Person(3,"张三3！"));

        //响应数据
        resp.getWriter().write(new Gson().toJson(personMap));
    }
}
