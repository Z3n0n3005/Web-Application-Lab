<%-- 
    Document   : CourseEdit
    Created on : Mar 14, 2023, 8:07:27 AM
    Author     : vy
--%>

<%@page import="connection.ConnectionDB"%>
<%@page import="course.CourseDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% 
    String CourseID = request.getParameter("CourseID"); 
    String CourseName = request.getParameter("CourseName");
    CourseDao cao = new CourseDao(ConnectionDB.getCon());
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please enter new name for <%= CourseName %>.</h1> 
        <form>
            <input type='hidden' name='CourseID' value=<%=CourseID%> />
            <input type='hidden' name='CourseName' value=<%=CourseName%> />
            New Course Name: <input type='text' name='newCourseName'/><br>
            <input type="submit" value="Edit" name="edit">
            <input type="submit" value="Cancel" name="cancel">

        </form>
        
        <%
                if(request.getParameter("edit")!=null){
                    if(request.getParameter("edit").equals("Edit")){
                    cao.editCourse(Integer.valueOf(CourseID), request.getParameter("newCourseName"));
                    response.sendRedirect("CourseList.jsp");
                    }
                }
                if(request.getParameter("cancel")!=null){
                    if(request.getParameter("cancel").equals("Cancel")){
                        response.sendRedirect("CourseList.jsp");
                    }
                }
        %>
    </body>
</html>
