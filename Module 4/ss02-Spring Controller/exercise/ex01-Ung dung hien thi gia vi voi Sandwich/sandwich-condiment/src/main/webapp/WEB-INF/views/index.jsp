<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/29/2021
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich Condiments</title>
    <style type="text/css">
        select {
            width: 200px;
            height: 20px;
        }
    </style>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form id="condiment" action="save" method="post">
    <input type="checkbox" id="lettuce" name="condiment" value="Lettuce">
    <label for="lettuce">Lettuce</label><br>
    <input type="checkbox" id="tomato" name="condiment" value="Tomato">
    <label for="tomato">Tomato</label><br>
    <input type="checkbox" id="mustard" name="condiment" value="Mustard">
    <label for="mustard">Mustard</label><br>
    <input type="checkbox" id="sprouts" name="condiment" value="Sprouts">
    <label for="sprouts">Sprouts</label><br><br>
    <input type="submit" value="Save">
</form>
<c:forEach items="${condimentList}" var="condiment">
    <h4>${condiment}</h4>
</c:forEach>
</body>
</html>
