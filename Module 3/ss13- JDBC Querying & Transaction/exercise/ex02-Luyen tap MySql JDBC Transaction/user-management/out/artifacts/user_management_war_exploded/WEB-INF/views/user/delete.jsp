<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/13/2021
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.css">
</head>
<body>
<div class="container">
    <h1>Delete User</h1>
    <p>
        <a href="/users">Back to user list</a>
    </p>
    <form method="post">
        <h3>Are you sure?</h3>
        <fieldset>
            <legend>User information</legend>
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
                <tr>
                    <td><input type="submit" value="Delete"></td>
                    <td><a href="/users">Cancel</a></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>

</body>
</html>
