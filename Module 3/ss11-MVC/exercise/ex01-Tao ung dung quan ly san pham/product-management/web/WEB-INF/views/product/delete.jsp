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
    <title>Deleting Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
</head>
<body>
<div class="container">
    <h1>Delete Product</h1>
    <p>
        <a href="/products">Back to product list</a>
    </p>
    <form method="post">
        <h3>Are you sure?</h3>
        <fieldset>
            <legend>Product information</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td>${product.name}</td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td>${product.price}</td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td>${product.description}</td>
                </tr>
                <tr>
                    <td>Manufacturing:</td>
                    <td>${product.manufacturing}</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Delete"></td>
                    <td><a href="/products">Cancel</a></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>

</body>
</html>
