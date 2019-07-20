<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/16 0016
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Commodity商品</title>
    <script type="text/javascript">
            function onupdateCommodity(id){
                window.location.href="updatecommodityServlet?id="+id;
            }
            function onDeleteCommodity(goodsinfo_name) {
                window.location.href="deleteGoodsServlet?goodsinfo_name="+goodsinfo_name;
            }
            function onCommodityDetails(goodsinfo_name) {
                window.location.href="commodityDetails?goodsinfo_name="+goodsinfo_name;

            }
    </script>
</head>
<body>
<table border="1">
    <a href="AddCommodity.jsp" >添加</a><br/>
    <h5 style="color: red">欢迎：${msg}</h5>
    <caption>商品信息表</caption>
    <thead>
    <tr>
        <th>序号</th>
        <th>商品名</th>
        <th>商品图片</th>
        <th>商品价格</th>
        <th>商品描述</th>
        <th>商品库存</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${byGoods}" var="goods" varStatus="s">
    <tr>
        <td width="200" height="50">${goods.id}</td>
        <td width="200" height="50" name="goodsinfo_name03">${goods.goodsinfo_name}</td>
        <td><img src="upload/${goods.goodsinfo_pic}" width="200" height="100"></td>
        <td width="200" height="50">${goods.goodsinfo_price}</td>
        <td width="200" height="50">${goods.goodsinfo_descri}</td>
        <td width="200" height="50">${goods.goodsinfo_stock}</td>
        <td>
            <input type="button" value="修改" onclick="onupdateCommodity(${goods.id})">
            <input type="button" value="删除" onclick="onDeleteCommodity('${goods.goodsinfo_name}')">
            <input type="button" value="详情" onclick="onCommodityDetails('${goods.goodsinfo_name}')">
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
