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

    </script>
</head>
<body>
<table border="1">
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
    <%--if (goods.getId()!=0){--%>
    <%--sb.append("and id=?");--%>
    <%--paramlist.add(goods.getId());--%>
    <%--}--%>
    <%--if (goods.getGoodsinfo_name()!=null){--%>
    <%--sb.append("and getGoodsinfo_name=?");--%>
    <%--paramlist.add(goods.getGoodsinfo_name());--%>
    <%--}--%>
    <%--if (goods.getGoodsinfo_pic()!=null){--%>
    <%--sb.append("and getGoodsinfo_pic=?");--%>
    <%--paramlist.add(goods.getGoodsinfo_pic());--%>
    <%--}--%>
    <%--if (goods.getGoodsinfo_price()!=null){--%>
    <%--sb.append("and getGoodsinfo_price=?");--%>
    <%--paramlist.add(goods.getGoodsinfo_price());--%>
    <%--}--%>
    <%--if (goods.getGoodsinfo_descri()!=null){--%>
    <%--sb.append("and getGoodsinfo_descri=?");--%>
    <%--paramlist.add(goods.getGoodsinfo_descri());--%>
    <%--}--%>
    <%--if (goods.getGoodsinfo_stook()!=0){--%>
    <%--sb.append("and getGoodsinfo_stook=?");--%>
    <%--paramlist.add(goods.getGoodsinfo_stook());--%>
    <%--}--%>
    <c:forEach items="${byGoods}" var="goods" varStatus="s">
    <tr>
        <td>${goods.id}</td>
        <td>${goods.goodsinfo_name}</td>
        <td>${goods.goodsinfo_pic}</td>
        <td>${goods.goodsinfo_price}</td>
        <td>${goods.goodsinfo_descri}</td>
        <td>${goods.goodsinfo_stock}</td>
        <td>
            <input type="button" name="amend" value="修改" onclick="">
            <input type="button" name="delete" value="删除" onclick="">
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
