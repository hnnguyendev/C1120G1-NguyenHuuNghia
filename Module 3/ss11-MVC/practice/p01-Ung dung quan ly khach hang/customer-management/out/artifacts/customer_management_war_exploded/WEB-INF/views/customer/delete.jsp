<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/12/2021
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting customer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
</head>
<body>
<div class="container">
    <h1>Delete customer</h1>
    <p>
        <a href="/customers">Back to customer list</a>
    </p>
    <form method="post">
        <h3>Are you sure?</h3>
        <fieldset>
            <legend>Customer information</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td>${customer.name}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>${customer.email}</td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td>${customer.address}</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Delete customer"></td>
                    <td><a href="/customers">Cancel</a></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>

</body>
</html>
