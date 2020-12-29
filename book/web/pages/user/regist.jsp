<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%--静态包含head内容--%>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
    <form action="userServlet" method="post">
        <%--隐藏域用户区分操作--%>
        <input type="hidden" name="action" value="regist">

        <h4 id="msg">${requestScope.msg eq null? "清输入..." : requestScope.msg}</h4>

        <label for="username">用户名</label>
        <input type="text" name="username" value="${username}" id="username">
        <label for="password">密码</label>
        <input type="text" name="password" value="${password}" id="password">
        <label for="email">邮箱</label>
        <input type="text" name="email" value="${email}" id="email">
        <label for="code">验证码</label>
        <input type="text" name="code" value="${code}" id="code">
        <img id="code_img" src="kaptcha.jpg" width="100px" height="30px">

        <input type="submit" value="注册">
    </form>
    <script type="text/javascript">
        $(function () {
            //点击图片更换验证码
            $('#code_img').click(function () {
                /*
                * 考虑到缓存问题，需要加上new Date();
                * */
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            })

            $("#username").blur(function () {
               $.getJSON("userServlet",{action:"ajaxExistsUsername",username:$(this).val()},function (e) {
                    if (e.existsUsername) {
                        $("#msg").text("用户名已经存在！")
                    } else {
                        $("#msg").text("用户名可用！")
                    }
               })
            });
        })
    </script>

    <hr>
    <%--静态包含footer页脚--%>
    <%@include file="/pages/common/footer.jsp"%>
</body>
</html>