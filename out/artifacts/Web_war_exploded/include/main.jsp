<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/11
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     头部标题 <br/>
     主体部分 <br/>

     <%--静态包含
        不会翻译
     <%@ include file="/include/foot.jsp"%>
     --%>
<%--    <%@ include file="/include/foot.jsp"%>--%>
    <%-- 动态包含
        会翻译
        可以传递参数
    --%>
    <jsp:include page="/include/foot.jsp">
        <jsp:param name="username" value="admin"/>
        <jsp:param name="password" value="admin"/>
    </jsp:include>
</body>
</html>
