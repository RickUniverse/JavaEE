<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/12
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=request.getScheme()%>
    协议：${ pageContext.request.scheme } <br>
    服务器ip：${ pageContext.request.serverName } <br>
    服务器端口：${ pageContext.request.serverPort } <br>
    获取工程路径：${ pageContext.request.contextPath } <br>
    获取请求方式：${ pageContext.request.method } <br>
    获取客户端ip地址：${ pageContext.request.remoteHost } <br>
    获取会话的id编号：${ pageContext.session.id } <br>

</body>
</html>
