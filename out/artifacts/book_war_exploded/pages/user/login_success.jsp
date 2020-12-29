<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%--静态包含head内容--%>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>

    <%--如果用户没有登录--%>
    <c:if test="${empty sessionScope.user}">
        <div>
            <a href="pages/user/login.jsp">登录</a>
            <a href="pages/user/regist.jsp">注册</a>
        </div>
    </c:if>
    <%--如果已经登录--%>
    <c:if test="${not empty sessionScope.user}">
        <div>
            <h1>登录成功!</h1>
            <h3>欢迎${sessionScope.user.username}</h3>
            <a href="userServlet?action=logout">退出登录</a>
        </div>
    </c:if>

    <hr/>
    <h2>
        <a href="manager/bookServlet?action=page">查看所有的图书</a>
        <a href="pages/cart/cart.jsp">购物车</a>
    </h2>

    <hr>
    <%--静态包含footer页脚--%>
    <%@include file="/pages/common/footer.jsp"%>
</body>
</html>