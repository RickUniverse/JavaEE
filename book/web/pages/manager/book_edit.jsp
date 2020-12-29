<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/14
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--通过静态导入导入头--%>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
    <%--添加--%>
    <form action="manager/bookServlet" method="get">
        <%--记录操作的页数--%>
        <input type="hidden" name="pageNo" value="${param.pageNo}">
        <%--修改还是添加操作--%>
        <input type="hidden" name="action" value="${ empty param.id ? "add" : "update"}">
        <%--当前书的id--%>
        <input type="hidden" name="id" value="${ requestScope.book.id }">

        <label for="name">书名</label>
        <input type="text" name="name" value="${requestScope.book.name}" id="name">
        <label for="price">价格</label>
        <input type="text" name="price" value="${requestScope.book.price}" id="price">
        <label for="author">作者</label>
        <input type="text" name="author" value="${requestScope.book.author}" id="author">
        <label for="sales">销量</label>
        <input type="text" name="sales" value="${requestScope.book.sales}" id="sales">
        <label for="stock">库存</label>
        <input type="text" name="stock" value="${requestScope.book.stock}" id="stock">

        <input type="submit" value="提交">

    </form>
</body>
</html>
