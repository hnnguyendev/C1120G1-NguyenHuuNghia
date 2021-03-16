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
    <title>View User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.css">
</head>
<body>
<div class="container">
    <h2>User Detail</h2>
    <p>
        <a href="/users">Back to user list</a>
    </p>
    <table>
        <tr>
            <td>Name:</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>Country:</td>
            <td>${user.country}</td>
        </tr>
    </table>
</div>
</body>
</html>
