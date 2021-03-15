<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/13/2021
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.css">
</head>
<body>
<div class="container">
    <h2 class="text-center">Create User</h2>
    <c:if test="${not empty message}">
        <h3 class="alert-success text-center">${message}</h3>
    </c:if>
    <form method="post">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="Enter name">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" name="email" id="email" placeholder="Enter email">
        </div>
        <div class="form-group">
            <label for="country">Country</label>
            <input type="text" class="form-control" name="country" id="country" placeholder="Enter country">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
