<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>client</title>
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
<hr/>
<div>
    <span><a href="pages/cart/cart.jsp">去购物车</a></span>
</div>

<div id="showInfo">
    <c:if test="${empty sessionScope.cart || empty sessionScope.cart.items}">
        <div>
            <span style="color: red;">当前购物车为空</span>
        </div>
    </c:if>
    <c:if test="${not empty sessionScope.cart && not empty sessionScope.cart.items}">
        <span id="totalCount">当前购物车内商品数量为 <strong>${sessionScope.cart.totalCount}</strong></span>
        <div>
            <span id="addLastName">您刚刚将<strong style="color: red;">${sessionScope.lastName}</strong>  添加到了购物车</span>
        </div>
    </c:if>
</div>

<hr/>
<div>
    <form action="client/bookServlet" method="get">
        <%--查询方式--%>
        <input type="hidden" name="action" value="pageByPrice">

        <label for="minPrice">从:</label>
        <input type="text" name="minPrice" value="${param.minPrice}" id="minPrice">
        <label for="maxPrice">-到-</label>
        <input type="text" name="maxPrice" value="${param.maxPrice}" id="maxPrice">

        <input type="submit" value="提交">
    </form>
</div>

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
                <button bookId="${book.id}" class="addToCart">加入购物车</button>
            </td>
        </tr>
    </c:forEach>
    <script type="text/javascript" >
        $(function () {
            $('button.addToCart').click(function () {
               var bookId = $(this).attr('bookId');
               //提交
               // location.href = "cartServlet?action=addItem&id="+bookId+"";
                $.getJSON("cartServlet",{action:"ajaxAddItem",id:bookId},function (e) {
                    // $("#totalCount").html("当前购物车内商品数量为 <strong>" + e.totalCount + "</strong>");
                    // $("#addLastName").html("您刚刚将<strong style=\"color: red;\">"+ e.addLastName +"</strong>  添加到了购物车");
                    $("#showInfo").html("<span id=\"totalCount\">当前购物车内商品数量为 <strong>" + e.totalCount + "</strong></span>\n" +
                        "        <div>\n" +
                        "            <span id=\"addLastName\">您刚刚将<strong style=\"color: red;\">"+ e.addLastName +"</strong>  添加到了购物车</span>\n" +
                        "        </div>");
                })
            });
        });
    </script>
</table>
<%--静态导入分页--%>
<%@ include file="/pages/common/page_nav.jsp"%>
</body>
</html>
