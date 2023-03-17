<%-- 
    Document   : CourseAdd
    Created on : Mar 13, 2023, 2:38:23 PM
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
        <h1>Add Course</h1>
        <form action="CourseAddServlet" method="post">
            <table>
                <tbody>
                    <tr>
                        <td>Course Name:</td>
                        <td><input type="text" name="CourseName"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Add"></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <br>
        <a href="CourseList.jsp">Manage Course</a><br>
        <a href="../CourseRegistrationDemo.jsp">Homepage</a>
    </body>
</html>
