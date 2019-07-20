<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15 0015
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>注册表</title>
    <script type="text/javascript">
        function onRegister() {
            var fals=true;
            fals=fals && onusername2();
            fals=fals && onValidateEmail();
            fals=fals && onValidateConfPassword();
            fals=fals && onValidatePassword();
            fals=fals && onValidatesex();

            return fals;
        }
        function onusername2() {
            var username=document.getElementById("username2")
            if(username.value==null||username.value.trim()==""){
                alert("请填写用户名");
                return false;

            }else {
                return true;
            }

        }
        function onValidatesex() {
            var cityObj = document.getElementById("sex");
            if(cityObj.value==null||cityObj.value.trim()==""){
                alert("性别必须选择");
                return false;

            }else{
                return true;
            }
        }

        // 验证确认密码
        // 密码与确认密码必须一致
        function onValidateConfPassword() {
            var passwordObj = document.getElementById("password2");
            var confPwd = document.getElementById("password3");
            if(passwordObj.value!=confPwd.value){
                alert("密码和确认密码必须一致");
                return false;
            }
            return true;
        }

        // 验证密码
        // 不能为空且长度必须大于等于6
        function onValidatePassword() {
            var passwordObj = document.getElementById("password2");
            if(passwordObj.value){
                if(passwordObj.value.length<6){
                    alert("密码长度必须大于等于6");
                    return false;
                }
                return true;
            }else{
                alert("密码不能为空");
                return false;
            }
        }

        // 验证邮箱格式是否合法
        function onValidateEmail() {
            var emailObj = document.getElementById("email");
            if(emailObj.value){
                // 判断是否包含@和.符号
                var index1 = emailObj.value.indexOf("@");
                var index2 = emailObj.value.indexOf(".");
                if(index1==-1 || index2==-1){
                    alert("邮箱格式非法：必须包含@和.符号");
                    return false;
                }
                // @和.符号都不能在首尾字符
                if(index1==0 || index2==0
                    || index1==emailObj.value.length-1
                    || index2==emailObj.value.length-1){
                    alert("邮箱格式非法：@和.符号都不能在首尾字符");
                    return false;
                }
                // @不能在.符号之后
                if(index1>index2){
                    alert("邮箱格式非法：@不能在.符号之后");
                    return false;
                }
                // @和.符号不能相邻
                if(index1==index2-1){
                    alert("邮箱格式非法：@和.符号不能相邻");
                    return false;
                }

                return true;
            }else{
                alert("邮箱不能为空");
                return false;
            }
        }
    </script>
</head>
<body>
<form action="userServlet" method="post" onsubmit="return onRegister()">
    <table border="1">
        <caption>请填写信息</caption>
        <tbody>
        <tr>
            <td>用户名：<input type="text" name="username2" id="username2"/><span style="color: red">*</span> </td>
        </tr>
        <tr>
            <td>密&nbsp码：<input type="password" name="password2" id="password2"/><span style="color: red">*</span></td>
        </tr>
        <tr>
            <td>确认密码：<input type="password" id="password3"/><span style="color: red">*</span></td>
        </tr>
        <tr>
            <td>
                性别：
                <select name="sex" id="sex">
                    <option>--请选择--</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>
        </tr>
        <tr>

            <td>
                兴趣：
                <input type="checkbox" name="hobbys" value="游戏"/>
                游戏
                <input type="checkbox" name="hobbys" value="电影"/>
                电影
                <input type="checkbox" name="hobbys" value="旅游"/>
                旅游
                <input type="checkbox" name="hobbys" value="工作"/>
                工作
            </td>
        </tr>
        <tr>
            <td>
            手机号：<input type="text" name="phone" id="phone"/>
                <span style="color: red">*</span>
            </td>
        </tr>
        <tr>
        <td>邮箱：<input type="text" name="email" id="email"/><span style="color: red">*</span></td>
        </tr>
        <tr><td>地址：<input type="text" name="addrs"/> </td></tr>

        </tbody>
    </table>
    <input type="submit" value="提交" />
</form>
</body>
</html>
