<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%--静态包含head内容--%>
    <%@include file="/pages/common/head.jsp"%>

    <script type="text/javascript">
        $(function () {
            // alert($);
            // console.log($)
        })
    </script>
</head>
<body>
    <%--<img src="imgs/1.png" alt="">--%>
    <form action="userServlet" method="post">
        <%--隐藏域用户区分操作--%>
        <input type="hidden" name="action" value="login">

        <h4>${requestScope.msg eq null ? "清输入用户名或密码..." : requestScope.msg}</h4>
        <label for="username">用户名</label>
        <input type="text" name="username" value="${empty requestScope.username ? cookie["username"].value : requestScope.username }" id="username">
        <label for="password">密码</label>
        <input type="text" name="password" value="${empty requestScope.password ? cookie["password"].value : requestScope.password }" id="password">

        <input type="submit" value="登录">
    </form>
<%--    <c:forEach begin="0" end="10" var="i">--%>
<%--        <h1>${i}</h1>--%>
<%--    </c:forEach>--%>
    <hr>
    <%--静态包含footer页脚--%>
    <%@include file="/pages/common/footer.jsp"%>
</body>
</html>