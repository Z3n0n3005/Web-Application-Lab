<%-- 
    Document   : CourseList
    Created on : Mar 12, 2023, 10:59:35 PM
    Author     : vy
--%>

<%@page import="connection.ConnectionDB"%>
<%@page import="course.CourseDao"%>
<%@page import="java.util.List"%>
<%@page import="course.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Course</title>
    </head>
    <body>
        <h1>Manage Course</h1>
        
        <table>
            <tbody>
                <tr>
                    <th><center>Course ID</center></th>
                    <th>Course Name</th>
                    <th><center>Course Action</center></th>
                </tr>
                <%
                CourseDao cao = new CourseDao(ConnectionDB.getCon());
                List<Course> listAllCourse = cao.listAllCourse();
                for(Course course: listAllCourse){
                    int CourseID = course.getCourseID();
                    String CourseName = course.getCourseName();
                    
                    out.print("<tr>");
                    out.print("<td>" + CourseID + "</td>");
                    out.print("<td><a href=\"CourseDetail.jsp?CourseID="+CourseID+"&CourseName=" + CourseName+"\">"+CourseName+"</a>" + "</td>");
                    out.print("<td><a href=\"CourseRemove.jsp?CourseID="+CourseID+"&CourseName="+CourseName+"\">Remove</a> | <a href=\"CourseEdit.jsp?CourseID="+CourseID+"&CourseName="+CourseName+"\">Edit</a></td>");
                    out.print("</tr>");
                }
                %>
            </tbody>
        </table><br>
        <a href="CourseAdd.jsp"> New Course</a><br>
        <a href="../CourseRegistrationDemo.jsp"> Homepage</a><br>
    </body>
    
</html>
