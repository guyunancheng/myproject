<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/18 0018
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品详情</title>
    <script type="text/javascript">
        function onFANHUI(){
            window.history.go(-1)
        }

    </script>
</head>
<body>
<table >
    <thead>
    <tr>
        <th>商品名字</th>
        <th>商品图片</th>
        <th>商品价格</th>
        <th>商品描述</th>
        <th>商品库存</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${byGoods4}" var="goods" varStatus="s">
        <tr>
            <td width="100" height="250" >${goods.goodsinfo_name}</td>
            <td><img src="upload/${goods.goodsinfo_pic}" width="300" height="250"></td>
            <td width="100" height="250">${goods.goodsinfo_price}</td>
            <td width="100" height="250">${goods.goodsinfo_descri}</td>
            <td width="100" height="250">${goods.goodsinfo_stock}</td>
        </tr>
        <input type="button" value="返回" onclick="onFANHUI()">
    </c:forEach>
    </tbody>
</table>
</body>
</html>
