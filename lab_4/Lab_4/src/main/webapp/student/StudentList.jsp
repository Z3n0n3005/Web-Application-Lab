<%-- 
    Document   : StudentList
    Created on : Mar 12, 2023, 10:59:23 PM
    Author     : vy
--%>

<%@page import="student.Student"%>
<%@page import="java.util.List"%>
<%@page import="student.StudentDao"%>
<%@page import="connection.ConnectionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Student</title>
    </head>
    <body>
        <h1>Manage Student</h1>
        
        <table>
            <tbody>
                <tr>
                    <th><center>Student ID</center></th>
                    <th>Student Name</th>
                    <th><center>Student Action</center></th>
                </tr>
                <%
                    StudentDao sao = new StudentDao(ConnectionDB.getCon());
                    List<Student> listAllStudent = sao.listAllStudent();
                    for(Student student : listAllStudent){
                        int StudentID = student.getStudentID();
                        String StudentName = student.getStudentName();
                        
                        out.print("<tr>");
                        out.print("<td>" + StudentID + "</td>");
                        out.print("<td><a href=\"StudentDetail.jsp?StudentID=" + StudentID + "&StudentName=" + StudentName+"\">"+StudentName+"</a>" + "</td>");
                        out.print("<td><a href=\"StudentRemove.jsp?StudentID="+StudentID+"&StudentName="+StudentName+"\">Remove</a> | <a href=\"StudentEdit.jsp?StudentID="+StudentID+"&StudentName="+StudentName+"\">Edit</a></td>");
                        out.print("</tr>");
                    }
                %>
            </tbody>
        </table><br>
        
        
        <a href="StudentAdd.jsp"> New Student</a><br>
        <a href="../CourseRegistrationDemo.jsp"> Homepage</a><br>
    </body>
    
</html>
