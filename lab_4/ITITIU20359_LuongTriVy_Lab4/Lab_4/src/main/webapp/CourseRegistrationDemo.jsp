<%-- 
    Document   : CourseRegistrationDemo
    Created on : Mar 12, 2023, 10:25:39 PM
    Author     : vy
--%>

<%@page import="student.StudentDao"%>
<%@page import="connection.ConnectionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    StudentDao sao = new StudentDao(ConnectionDB.getCon());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Course Registration Demo</h1>
        <form>
            Student ID: <input type="text" name="StudentID"/>
            <input type="submit" value="Submit" name="Submit"/>
        </form>
        
        <%
            if(request.getParameter("Submit")!=null){
                if(request.getParameter("Submit").equals("Submit")){
                    Integer StudentID = Integer.valueOf(request.getParameter("StudentID"));
                    String StudentName = sao.findStudentName(StudentID);
                    response.sendRedirect("student/StudentDetail.jsp?StudentName=" + StudentName + "&StudentID=" + StudentID);
                }
            }
        %>
        
        <h2>Manager</h2>
        <a href="student/StudentList.jsp"> Students Manager</a><br>
        <a href="course/CourseList.jsp"> Courses Manager</a><br>
    </body>
</html>
