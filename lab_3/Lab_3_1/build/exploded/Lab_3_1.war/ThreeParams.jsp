<%-- 
    Document   : ThreeParams
    Created on : Mar 7, 2023, 1:32:05 PM
    Author     : vy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body  style="background-color: pink">
        <h1>Collect 3 parameter</h1>
        <form action="GetThreeParams" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td>First parameter:</td>
                        <td><input type="text" name="param_1" size="20"></td>
                    </tr>
                    <tr>
                        <td>Second parameter:</td>
                        <td><input type="text" name="param_2" size="20"></td>
                    </tr>
                    <tr>
                        <td>Third parameter:</td>
                        <td><input type="text" name="param_3" size="20"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Submit"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
