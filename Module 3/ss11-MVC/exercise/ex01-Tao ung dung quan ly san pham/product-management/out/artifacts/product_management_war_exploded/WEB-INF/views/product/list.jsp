<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/13/2021
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<div class="container">
    <h2>Product List</h2>
    <c:if test="${not empty message}">
        <h3 class="alert-success text-center">${message}</h3>
    </c:if>
    <form method="post">
        <input hidden="hidden" name="action" value="search">
        <input type="text" name="txtSearch" placeholder="Product name">
        <button type="submit">Search</button>
    </form>
    <a href="/products?action=create">
        <button class="btn btn-primary">Create</button>
    </a>
    <table class="table table-hover">
        <thead class="thead-dark">
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Manufacturing</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="product">
            <tr>
                <th>${product.id}</th>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.manufacturing}</td>
                <td>
                    <a href="/products?action=view&id=${product.id}">
                        <button class="btn btn-success">View</button>
                    </a>
                </td>
                <td>
                    <a href="/products?action=edit&id=${product.id}">
                        <button class="btn btn-warning">Edit</button>
                    </a>
                </td>
                <td>
                    <a href="/products?action=delete&id=${product.id}">
                        <button class="btn btn-danger">Delete</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
