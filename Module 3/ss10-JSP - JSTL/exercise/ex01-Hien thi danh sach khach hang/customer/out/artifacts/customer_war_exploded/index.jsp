<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/11/2021
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/resource/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resource/css/style.css">
</head>
<body>
<div class="container">
    <h2>Customer List</h2>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Address</th>
            <th scope="col">Image</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <th scope="row">${customer.id}</th>
                <td>${customer.customerName}</td>
                <td>${customer.birthday}</td>
                <td>${customer.address}</td>
                <td><img src="resource/images/${customer.image}" alt="" width="50px" height="50px"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
