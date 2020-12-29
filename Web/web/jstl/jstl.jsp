<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/12
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <c:forEach begin="0" end="10" var="i">--%>
<%--        <h1>${i}</h1>--%>
<%--    </c:forEach>--%>
<%--    <c:set scope="request" var="key" value="value"></c:set>--%>
<%--    <c:choose>--%>
<%--        <c:when test="${requestScope.key eq 'value'}">--%>
<%--            <h1>value</h1>--%>
<%--        </c:when>--%>
<%--    </c:choose>--%>

    <%--遍历map--%>
    <%
        Map map = new HashMap();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        request.setAttribute("map",map);
    %>
    <%--step 步长--%>
    <c:forEach begin="1" end="2" items="${requestScope.map}" step="2" var="entry" >
        <h1>${entry.value }=${ entry.key}</h1>
    </c:forEach>
</body>
</html>
