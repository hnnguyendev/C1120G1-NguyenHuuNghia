<%--
  Created by IntelliJ IDEA.
  User: duytr
  Date: 3/30/2021
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Create Student</h3>
<form method="post" action="/student/create">
    <p>Id: <input type="text" name="id"></p>
    <p>Name: <input type="text" name="name"></p>
    <p>Age: <input type="text" name="age"></p>
    <input type="submit" value="Create">
</form>
</body>
</html>
