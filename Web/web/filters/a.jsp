<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/19
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("a.jsp代码");
        System.out.println("a.jsp线程名：" + Thread.currentThread().getName());
        System.out.println("a.jsp获取请求的参数：" + request.getParameter("param"));
        System.out.println("a.jsp获取filter1保存的参数：" + request.getAttribute("key1"));
    %>
</body>
</html>
