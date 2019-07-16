<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15 0015
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript">
        function onshow2(){
            window.location.href="Register.jsp";
        }
    </script>
</head>
<body>
<form action="#" method="post">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    <input type="submit" value="登录" onclick=""/>
    <input type="button" value="注册" onclick="onshow2()"/>
</form>
</body>
</html>
