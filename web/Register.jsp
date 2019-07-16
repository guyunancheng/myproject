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
</head>
<body>
<form action="userServlet" method="post">
    <table border="1">
        <caption>请填写信息</caption>
        <tbody>
        <tr>
            <td>用户名：<input type="text" name="username2"/></td>
        </tr>
        <tr>
            <td>密&nbsp&nbsp&nbsp码：<input type="password" name="password2"/></td>
        </tr>
        <tr>
            <td>确认密码：<input type="password" id="password3"/></td>
        </tr>
        <tr>
            <td>
                性别：
                <select name="sex">
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
            手机号：<input type="text" name="phone"/>
            </td>
        </tr>
        <tr>
        <td>邮箱：<input type="text" name="email"/></td>
        </tr>
        <tr><td>地址：<input type="text" name="addrs"/> </td></tr>

        </tbody>
    </table>
    <input type="submit" value="提交" onclick="" />
</form>
</body>
</html>
