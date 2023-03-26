<%-- 
    Document   : Example3
    Created on : Mar 25, 2023, 6:27:34 PM
    Author     : vy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Print out the cookies</h1>
        <hr>
        <form method="post" action="CookieExample">
            <table>
                <tbody>
                    <tr>
                        <td>Input cookie name:</td>
                        <td><input type="text" name="cName"></td>
                    </tr>
                    <tr>
                        <td>Input cookie value:</td>
                        <td><input type="text" name="cValue"></td>
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
