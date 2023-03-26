<%-- 
    Document   : StudentAdd
    Created on : Mar 13, 2023, 2:38:30 PM
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
    <body>
        <h1>Add Student</h1>
        <form action="StudentAddServlet" method="post">
            <table>
                <tbody>
                    <tr>
                        <td>Full Name:</td>
                        <td><input type="text" name="StudentName"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Add"></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <br>
        <a href="StudentList.jsp">Manage Student</a><br>
        <a href="../CourseRegistrationDemo.jsp">Homepage</a><br>
    </body>
</html>
