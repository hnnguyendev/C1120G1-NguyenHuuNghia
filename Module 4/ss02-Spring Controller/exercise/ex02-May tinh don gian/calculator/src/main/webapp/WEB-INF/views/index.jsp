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
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/calculator" method="post">
    <input type="number" name="firstOperand">
    <input type="number" name="secondOperand"><br><br>
    <button type="submit" value="+" name="operator">Addition(+)</button>
    <button type="submit" value="-" name="operator">Subtraction(-)</button>
    <button type="submit" value="*" name="operator">Multiplication(*)</button>
    <button type="submit" value="/" name="operator">Division(/)</button>
</form>
<c:choose>
    <c:when test="${not empty message}">
        <p style="color: red;">${message}</p>
    </c:when>
    <c:otherwise>
        <c:if test="${not empty result}">
            <p>Result ${txtOperator} : ${result}</p>
        </c:if>
    </c:otherwise>
</c:choose>

</body>
</html>
