<%-- 
    Document   : account
    Created on : Apr 26, 2023, 1:07:04 PM
    Author     : vy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Information</title>
    </head>
    <body>
        <%
            request.setAttribute("acc", null);
            request.setAttribute("inventory", null);
        %>
        <h1>Please provide your account information</h1>
        <form method="post" action="ShoppingServlet">
            <table>
                <tbody>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>VISA Card Number:</td>
                        <td><input type="number" name="visaCardNum"></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input type="text" name="address"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="submit" value="Submit"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
