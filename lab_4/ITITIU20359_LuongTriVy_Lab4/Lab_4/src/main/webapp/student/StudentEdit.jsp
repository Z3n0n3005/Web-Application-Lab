<%-- 
    Document   : StudentEdit
    Created on : Mar 14, 2023, 10:00:31 AM
    Author     : vy
--%>

<%@page import="student.StudentDao"%>
<%@page import="connection.ConnectionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String StudentID = request.getParameter("StudentID"); 
    String StudentName = request.getParameter("StudentName");
    StudentDao sao = new StudentDao(ConnectionDB.getCon());
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please enter new name for <%= StudentName %>.</h1> 
        <form>
            <input type='hidden' name='StudentID' value=<%=StudentID%> />
            <input type='hidden' name='StudentName' value=<%=StudentName%> />
            New Student Name: <input type='text' name='newStudentName'/><br>
            <input type="submit" value="Edit" name="edit">
            <input type="submit" value="Cancel" name="cancel">

        </form>
        
        <%
                if(request.getParameter("edit")!=null){
                    if(request.getParameter("edit").equals("Edit")){
                    sao.editStudent(Integer.valueOf(StudentID), request.getParameter("newStudentName"));
                    response.sendRedirect("StudentList.jsp");
                    }
                }
                if(request.getParameter("cancel")!=null){
                    if(request.getParameter("cancel").equals("Cancel")){
                        response.sendRedirect("StudentList.jsp");
                    }
                }
        %>
    </body>
</html>
