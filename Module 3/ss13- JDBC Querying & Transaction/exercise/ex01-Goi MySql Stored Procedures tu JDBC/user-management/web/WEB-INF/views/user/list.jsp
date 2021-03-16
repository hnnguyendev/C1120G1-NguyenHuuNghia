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
    <title>User List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.css">
</head>
<body>
<div class="container">
    <h2>User List</h2>
    <c:if test="${not empty message}">
        <h3 class="alert-success text-center">${message}</h3>
    </c:if>
    <form method="post">
        <input hidden="hidden" name="action" value="search">
        <input type="text" name="txtSearch" placeholder="User's country">
        <button type="submit">Search</button>
    </form>
    <a href="/users?action=create">
        <button class="btn btn-primary">Create</button>
    </a>
    <table class="table table-hover">
        <thead class="thead-dark">
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <th>${user.id}</th>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td>
                    <a href="/users?action=view&id=${user.id}">
                        <button class="btn btn-success">View</button>
                    </a>
                </td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">
                        <button class="btn btn-warning">Edit</button>
                    </a>
                </td>
                <td>
                    <a href="/users?action=delete&id=${user.id}">
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
