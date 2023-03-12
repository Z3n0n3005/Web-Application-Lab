<%-- 
    Document   : login
    Created on : Mar 11, 2023, 4:04:25 PM
    Author     : vy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <center>
            <h1 style="border-bottom: 1px black solid">Please enter username and password to login!</h1>
            <form>
                <table>
                    <tbody>
                        <tr>
                            <td>User Name:</td>
                            <td><input type="text" name="username"></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="text" name="password"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" name="Login" value="Login"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <%
                if(request.getParameter("Login") != null){
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    if(username.equals("") || password.equals("")){
                        out.print("<center><h2>Username or password cannot be empty.</h2></center>");
                    } else {
                        response.sendRedirect("Homepage.jsp");
                    } 
                }
            %>
        </center>
    </body>
</html>
