<%--
  Created by IntelliJ IDEA.
  User: administrator
  Date: 26.10.2018
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<h1>Selected product:</h1>
    <br>ID : ${product.id}
    <br> Name : ${product.name}
    <br><a href="/addProductInBasket.do?id=${product.id}">Add to basket.</a>
    <br>
<br><h3><a href="allProduct.do">Back to Index.</a> </h3>
<h2>Products</h2>
<c:forEach var="products" items="${AllProductInBasket}">
    <ul>
        <li><a href="./product.do?id=${products.key.id}">${products.key.name}
        </a> - ${products.value} , price - ${products.value * products.key.price}
            (<a href="/removeProductInBasket.do?id=${products.key.id}">Delete.</a>) </li>
    </ul>
</c:forEach>
</body>
</html>
