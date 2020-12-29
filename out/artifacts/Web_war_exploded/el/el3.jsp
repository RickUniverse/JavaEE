<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/12
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--请求参数的获取--%>
    ${ param } <br>
    ${ param.username } <br>
    <%--多个值--%>
    ${ paramValues } <br>
    ${ paramValues.hoppy[0] } <br>
    ${ paramValues.hoppy[1] } <br>

    <%--请求头--%>
    ${ header }<br><br><br><br>
    ${ header['User-Agent'] }<br><br><br>
    ${ header.Connection }<br><br><br>

    <%--cookie--%>
    ${ cookie.JSESSIONID.name }<br><br><br>
    ${ cookie.JSESSIONID.value }<br><br><br>

    <%--获取context-param参数--%>
    ${ initParam }<br>
    ${ initParam.url }<br>
    ${ initParam.username }<br>
</body>
</html>
