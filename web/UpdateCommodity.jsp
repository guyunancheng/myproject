<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/18 0018
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改商品</title>
</head>
<body>
<form action="/updateCommodityServlet02" method="post"  >
    <%--enctype="multipart/form-data"--%>
    <table border="1">
        <thead>
        <tr>
            <th>序号</th>
            <th>商品名字</th>
            <th>商品图片</th>
            <th>商品价格</th>
            <th>商品描述</th>
            <th>商品库存</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listid}" var="goods" varStatus="g">
        <tr>
            <td><input type="hidden" name="id2" value="${goods.id}">${goods.id}</td>
            <td><input type="text" id="goodsinfo_name2" name="goodsinfo_name2" value="${goods.goodsinfo_name}"></td>

            <td><img src="upload/${goods.goodsinfo_pic}" width="100" height="50"><br/>
                    <%--<input type="file" id="goodsinfo_pic2" name="goodsinfo_pic2" value="${goods.goodsinfo_pic}">--%>
            </td>
            <td><input type="text" id="goodsinfo_price2" name="goodsinfo_price2" value="${goods.goodsinfo_price}"></td>
            <td><input type="text" id="goodsinfo_descri2" name="goodsinfo_descri2" value="${goods.goodsinfo_descri}"></td>
            <td><input type="text" id="goodsinfo_stock2" name="goodsinfo_stock2" value="${goods.goodsinfo_stock}"></td>
        </tr>
        </c:forEach>
        <th>
            <input type="submit" value="保存" >
        </th>
        </tbody>
    </table>
</form>
</body>
</html>
