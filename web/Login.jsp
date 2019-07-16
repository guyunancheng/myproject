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
        function onshow1(){
            var username=document.getElementById("username").value;
            var password=document.getElementById("password").value;
            if (username==null||""==username.trim()||password==null||password.trim()==""){
               alert("账号密码不能为空")
            } else {
                window.location.href="/goodsServlet";
            }

        }
        function onshow2(){
            window.location.href="Register.jsp";
        }
    </script>
</head>
<body>
<form action="/goodsServlet" method="post">
    用户名：<input type="text" name="username1" id="username"/><br/>
    密码：<input type="password" name="password1" id="password"/><br/>
    <input type="submit" value="登录" />
    <input type="button" value="注册" onclick="onshow2()"/>

</form>
</body>
</html>
