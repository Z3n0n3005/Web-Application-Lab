<%-- 
    Document   : StudentRemove
    Created on : Mar 14, 2023, 10:00:23 AM
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
        <title>Remove Student</title>
    </head>
    <body>
        <h1>Would you like to remove <%= StudentName %> ?</h1> 
        <form>
            <input type='hidden' name='StudentID' value=<%=StudentID%> />
            <input type='hidden' name='StudentName' value=<%=StudentName%> />
            <input type="submit" value="Remove" name="remove">
            <input type="submit" value="Cancel" name="cancel">

        </form>
        
        <%
                if(request.getParameter("remove")!=null){
                    if(request.getParameter("remove").equals("Remove")){
                    sao.deleteStudent(Integer.valueOf(StudentID));
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
