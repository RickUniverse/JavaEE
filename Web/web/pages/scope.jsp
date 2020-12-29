<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/11
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope</h1>
    <%
        request.setAttribute("key","request");
        pageContext.setAttribute("key","pageContext");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    request:<%=request.getAttribute("key")%>
    pageContext:<%=pageContext.getAttribute("key")%>
    session:<%=session.getAttribute("key")%>
    application:<%=application.getAttribute("key")%>

    <%
//        request.getRequestDispatcher("scope2.jsp").forward(request,response);
    %>
<%--    转发标签--%>
    <jsp:forward page="scope2.jsp"></jsp:forward>
</body>
</html>
