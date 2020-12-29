<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%--通过静态导入导入头--%>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
    <table border="1">
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <%--如果没有商品--%>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="client/bookServlet?action=page">当前购物车为空</a></td>
            </tr>
        </c:if>
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value["name"]}</td>
                    <td><input type="text"
                               name="count"
                               bookId="${entry.value["id"]}"
                               value="${entry.value["count"]}"></td>
                    <td>${entry.value["price"]}</td>
                    <td>${entry.value["totalPrice"]}</td>
                    <td><a onclick="return confirm('确定要删除吗？')" href="cartServlet?action=deleteItem&id=${entry.value["id"]}">删除</a></td>
                </tr>
            </c:forEach>
            <script type="text/javascript">
                $(function () {
                    $('input[name=count]').change(function () {
                        //名字
                        var name = $(this).parent().parent().find("td:first").text();
                        //修改的数量
                        var count = $(this).val();
                        //要修改书的id
                        var id = $(this).attr('bookId');
                        if (confirm('确定要修改【'+name+'】为'+count+' 吗？')) {
                            //确定要修改
                            location.href = "cartServlet?action=updateCount&id="+id+"&count="+count+"";
                        } else {
                            this.value = this.defaultValue;
                        }
                    })
                })
            </script>
        </c:if>
    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div>
            <span>购物车中共有 <strong>${sessionScope.cart.totalCount}</strong> 件商品</span>
            <span>总金额为 <strong>${sessionScope.cart.totalPrice}</strong> </span>
            <span><a onclick="return confirm('确定要清空吗？')" href="cartServlet?action=clear">清空购物车</a></span>
            <span><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>
</body>
</html>
