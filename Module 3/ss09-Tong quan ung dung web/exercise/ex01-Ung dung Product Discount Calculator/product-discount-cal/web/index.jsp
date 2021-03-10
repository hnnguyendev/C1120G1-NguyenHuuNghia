<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/10/2021
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>
<form action="/discountcalculator" method="post">
    <input type="text" name="productDescription" placeholder="Product Description"><br>
    <input type="number" name="listPrice" placeholder="List Price"><br>
    <input type="number" name="discountPercent" placeholder="Discount Percent"><br>
    <input type="submit" value="Calculator">
</form>
</body>
</html>
