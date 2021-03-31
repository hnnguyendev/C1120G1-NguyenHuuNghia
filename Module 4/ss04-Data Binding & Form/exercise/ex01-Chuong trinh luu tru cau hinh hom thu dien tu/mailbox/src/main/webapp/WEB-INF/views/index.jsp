<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/29/2021
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Email</title>
</head>
<body>
<%--<h2>Settings</h2>--%>
<%--<form:form method="post" action="/update" modelAttribute="email">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td><form:label path="language">Language: </form:label></td>--%>
<%--            <td>--%>
<%--                <form:select path="language">--%>
<%--                    <form:option value="English">English</form:option>--%>
<%--                    <form:option value="Vietnamese">Vietnamese</form:option>--%>
<%--                    <form:option value="Japanese">Japanese</form:option>--%>
<%--                    <form:option value="Chinese">Chinese</form:option>--%>
<%--                </form:select>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:label path="pageSize">Page size: </form:label></td>--%>
<%--            <td>--%>
<%--                <span>Show </span>--%>
<%--                <form:select path="pageSize">--%>
<%--                    <form:option value="5">5</form:option>--%>
<%--                    <form:option value="10">10</form:option>--%>
<%--                    <form:option value="15">15</form:option>--%>
<%--                    <form:option value="20">20</form:option>--%>
<%--                    <form:option value="25">25</form:option>--%>
<%--                    <form:option value="50">50</form:option>--%>
<%--                    <form:option value="100">100</form:option>--%>
<%--                </form:select>--%>
<%--                <span> emails per page</span>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Spams filter: </td>--%>
<%--            <td>--%>
<%--                <form:checkbox path="spamFilter"/> Enable spams filter--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Signature: </td>--%>
<%--            <td>--%>
<%--                <form:textarea path="signature" rows="4" cols="25"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><input type="submit" value="Submit"/></td>--%>
<%--            <td><input type="button" value="Cancel"></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form:form>--%>

<h2>Settings</h2>
<form:form method="post" action="/update" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="language">Language: </form:label></td>
            <td>
                <form:select path="language" items="${languageList}"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page size: </form:label></td>
            <td>
                <span>Show </span>
                <form:select path="pageSize" items="${pageSizeList}"/>
                <span> emails per page</span>
            </td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td>
                <form:checkbox path="spamFilter"/> Enable spams filter
            </td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>
                <form:textarea path="signature" rows="4" cols="25"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
            <td><input type="reset" value="Cancel"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
