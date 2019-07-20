<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/17 0017
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
    <script type="text/javascript">
        function onAddCommodity(){
            var goodsinfo_name=document.getElementById("goodsinfo_name");
            var goodsinfo_pic=document.getElementById("goodsinfo_pic");
            var goodsinfo_price=document.getElementById("goodsinfo_price");
            var goodsinfo_descri=document.getElementById("goodsinfo_descri");
            var goodsinfo_stock=document.getElementById("goodsinfo_stock");
            if (goodsinfo_name.value==null || goodsinfo_name.value.trim()==""){
                alert("请填写商品名")
               return false;
            } if (goodsinfo_pic.value==null||goodsinfo_pic.value.trim()==""){
                alert("请添加图片")
                return false;
            } if(goodsinfo_price.value==null||goodsinfo_price.value.trim()==""){
                alert("请填写价格")
                return false;
            } if(goodsinfo_descri.value==null || goodsinfo_descri.value.trim()==""){
                alert("套你猴子说明一下商品")
                return false;
            } if(goodsinfo_stock.value==null|| goodsinfo_stock.value.trim()==""){
               alert("套你猴子还有多少个");
                return false;
            }else {
                return true;
            }

        }
    </script>
</head>
<body>
<form action="/addcommodityServlet" method="post"  enctype="multipart/form-data" onsubmit="return onAddCommodity() ">
<table border="1">
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
    <tr>
        <td><input type="text" id="goodsinfo_name" name="goodsinfo_name"></td>
        <td><input type="file" id="goodsinfo_pic" name="goodsinfo_pic"></td>
        <td><input type="text" id="goodsinfo_price" name="goodsinfo_price"></td>
        <td><input type="text" id="goodsinfo_descri" name="goodsinfo_descri"></td>
        <td><input type="text" id="goodsinfo_stock" name="goodsinfo_stock"></td>
    </tr>
    <th>
        <input type="submit" value="提交" onclick="onAddCommodity()">
    </th>
    </tbody>
</table>
</form>
</body>
</html>
