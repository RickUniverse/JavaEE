<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/20
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <a href="i18n.jsp?country=cn">中文</a>
        <a href="i18n.jsp?country=usa">English</a>
    </div>
    <%
        Locale locale = null;

        String country = request.getParameter("country");
        if (country != null) {
            if (country.equals("cn")) {
                locale = locale.CHINA;
            } else if (country.equals("usa")) {
                locale = locale.US;
            }
        } else {
            locale = request.getLocale();
        }

        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
    %>
    <%=bundle.getString("username")%> : <input type="text">
    <%=bundle.getString("password")%> : <input type="text">
</body>
</html>
