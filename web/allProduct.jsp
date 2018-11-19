<%--
  Created by IntelliJ IDEA.
  User: administrator
  Date: 25.10.2018
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>All Product</title>
</head>
<body>

<c:forEach var="products" items="${allProduct}">
    <ul>
    <li>
        <a href="./product.do?id=${products.id}">${products.name}</a>
    </li>
    </ul>
</c:forEach>
</body>
</html>
