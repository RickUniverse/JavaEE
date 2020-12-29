<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/12
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        HashMap hashMap = new HashMap();
        hashMap.put("key+key+key","value");
        pageContext.setAttribute("key",hashMap);
        pageContext.setAttribute("key1","pageContext");
        request.setAttribute("key1","request");
        session.setAttribute("key1","session");
        session.setAttribute("key2","session2");
        session.setAttribute("key3","session3");
        application.setAttribute("key1","application");
    %>

<%--    el内置对象--%>
    ${ sessionScope }<br/>
    ${ sessionScope.key1 }<br/>

   <%-- ${ empty key  }
    <br/>
    ${ key['key+key+key'] }
    <br/>三元表达式<br/>
    ${ 12 == 12 ? "yes" : "no" }--%>
</body>
</html>
