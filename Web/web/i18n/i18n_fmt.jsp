<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--1,使用标签设置locale信息--%>
    <fmt:setLocale value="${param.locale}" />
    <%--2,使用标签设置baseName--%>
    <fmt:setBundle basename="i18n" />
    <%--3,使用标签输出国际化信息--%>
    <%--<fmt:message key="username" />--%>
    <div>
        <a href="i18n_fmt.jsp?locale=zh_CN">中文</a>
        <a href="i18n_fmt.jsp?locale=en_US">English</a>
    </div>
    <fmt:message key="username" /> : <input type="text">
    <fmt:message key="password" /> : <input type="text">
</body>
</html>
