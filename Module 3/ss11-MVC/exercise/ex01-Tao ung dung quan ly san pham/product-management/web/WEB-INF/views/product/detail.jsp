<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/12/2021
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
</head>
<body>
<div class="container">
    <h2>Product Detail</h2>
    <p>
        <a href="/products">Back to product list</a>
    </p>
    <table>
        <tr>
            <td>Name:</td>
            <td>${product.name}</td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>${product.price}</td>
        </tr>
        <tr>
            <td>Description:</td>
            <td>${product.description}</td>
        </tr>
        <tr>
            <td>Manufacturing:</td>
            <td>${product.manufacturing}</td>
        </tr>
    </table>
</div>
</body>
</html>
