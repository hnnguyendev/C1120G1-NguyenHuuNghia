<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/12/2021
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<div class="container">
    <h2 class="text-center">Customer List</h2>
    <p>
        <c:if test="${not empty message}">
            <span class="message">${message}</span>
        </c:if>
    </p>
    <div>
        <a href="/customers?action=create">
            <button class="btn btn-primary">Create</button>
        </a>
    </div>
    <table class="table table-hover">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">View</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <th scope="row">${customer.id}</th>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>
                    <a href="/customers?action=view&id=${customer.id}">
                        <button class="btn btn-success">View</button>
                    </a>
                </td>
                <td>
                    <a href="/customers?action=edit&id=${customer.id}">
                        <button class="btn btn-warning">Edit</button>
                    </a>
                </td>
                <td>
                    <a href="/customers?action=delete&id=${customer.id}">
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
