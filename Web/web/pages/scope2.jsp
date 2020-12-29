<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/11
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope2</h1>
<%
    out.print(1);
%>
request:<%=request.getAttribute("key")%>
pageContext:<%=pageContext.getAttribute("key")%>
session:<%=session.getAttribute("key")%>
application:<%=application.getAttribute("key")%>
</body>
</html>
