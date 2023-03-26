<%-- 
    Document   : CourseDetail
    Created on : Mar 12, 2023, 10:59:50 PM
    Author     : vy
--%>

<%@page import="student.Student"%>
<%@page import="java.util.List"%>
<%@page import="studentcourse.StudentCourseDao"%>
<%@page import="connection.ConnectionDB"%>
<%@page import="course.CourseDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% 
    String CourseID = request.getParameter("CourseID"); 
    String CourseName = request.getParameter("CourseName");
    CourseDao cao = new CourseDao(ConnectionDB.getCon());
    StudentCourseDao scao = new StudentCourseDao(ConnectionDB.getCon());
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course's Details</title>
    </head>
    <body>
        <h1>Course's Details</h1>
        Course ID: <%= CourseID%> <br>
        Course name: <%= CourseName%> <br>
        <h2>Student list:</h2>
        <table>
            <tbody>
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th>Action</th>
                </tr>
                <% 
                    List<Student> listAllStudent = scao.listAllStudent(Integer.valueOf(CourseID));
                    for(Student student : listAllStudent){
                        int StudentID = student.getStudentID();
                        String StudentName = student.getStudentName();
                        out.print("<tr>");
                        out.print("<td>" + StudentID + "</td>");
                        out.print("<td>" + StudentName + "</td>");
                        out.print("<td><a href=\"../studentcourse/StudentCourseRemove.jsp?StudentID="+StudentID+"&StudentName="+StudentName+"&CourseID="+CourseID+"&CourseName="+CourseName+"&from=CourseDetail"+"\">Remove</a></td>");
                        out.print("</tr>");
                    }
                %>
            </tbody>
        </table>
    </body>
    <br>
    <a href="../CourseRegistrationDemo.jsp"> Homepage</a><br>
</html>
