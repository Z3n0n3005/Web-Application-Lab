<%-- 
    Document   : StudentDetail
    Created on : Mar 12, 2023, 10:58:59 PM
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
        <h1>Student's Details</h1>
        Student ID: <%= %>
        Student name: <%= %>
        <h2>Select Course</h2>
        Course: <select name="field_of_study">
                    <option value="Computer Science">CS</option>
                    <option value="Electrical Engineering">EE</option>
                    <option value="Business Admininstrator">BA</option>
                    <option value="Biological Engineering">BE</option>
                </select>
        <h2>Registered Courses:</h2>
        <table>
            <tbody>
                <tr>
                    <th>Course ID</th>
                    <th>Course Name</th>
                    <th>Action</th>
                </tr>
            </tbody>
        </table>
        <a href=""> Homepage</a><br>

    </body>
    
</html>
