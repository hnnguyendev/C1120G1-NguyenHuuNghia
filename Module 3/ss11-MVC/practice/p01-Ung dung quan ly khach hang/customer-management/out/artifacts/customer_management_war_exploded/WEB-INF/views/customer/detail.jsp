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
    <title>View customer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
</head>
<body>
<div class="container">
    <h1>Customer details</h1>
    <p>
        <a href="/customers">Back to customer list</a>
    </p>
    <table>
        <tr>
            <td>Name:</td>
            <td>${customer.name}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${customer.email}</td>
        </tr>
        <tr>
            <td>Address:</td>
            <td>${customer.address}</td>
        </tr>
    </table>
</div>
</body>
</html>
