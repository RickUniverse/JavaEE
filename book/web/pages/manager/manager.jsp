<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/14
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%--通过静态导入导入头--%>
    <%@include file="/pages/common/head.jsp"%>

    <style>
        *{
            list-style: none;
            margin: 0px;
            padding: 0px;
        }
        .page_nav ul:after{
            clear: both;
            content: " ";
            display: block;
        }
        .page_nav ul li{
            float: left;
            padding: 2px 10px 2px 10px;
            border: 1px solid rgba(0,0,0,.3);
        }
        #pageNo{
            width: 40px;
        }
    </style>

    <script type="text/javascript" >
        $(function () {
            $('a.deleteBook').click(function () {
                return confirm("确定删除"+$(this).parent().parent().find("td:first").text()+"吗？");
            })
        })
    </script>
</head>
<body>
    <table border="1">
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td>
                    <a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a>
                    <a class="deleteBook" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a>
            </td>
        </tr>
    </table>

    <%--静态导入分页--%>
    <%@ include file="/pages/common/page_nav.jsp"%>
</body>
</html>
