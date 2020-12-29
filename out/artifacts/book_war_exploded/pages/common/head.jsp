<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/13
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--头部标签的导入--%>

<%--动态获取项目路径的base--%>
<%
    String basePath = request.getScheme()
    + "://"
    + request.getServerName()
    + ":"
    + request.getServerPort()
    + request.getContextPath()
    + "/";
%>
<!--参照工程路径-->
<base href="<%=basePath%>>">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
