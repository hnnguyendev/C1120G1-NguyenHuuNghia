<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/11/2021
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

<h1>Result:</h1>
<c:if test="${empty error}">
    <h3>${firstO} ${operator} ${secondO} = ${result}</h3>
</c:if>
<c:if test="${not empty error}">
    ${error}
</c:if>

</body>
</html>
