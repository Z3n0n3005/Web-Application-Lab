<%-- 
    Document   : CourseDelete
    Created on : Mar 13, 2023, 8:37:22 PM
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
        <h1>Would you like to remove <%= CourseName %> ?</h1> 
        <form>
            <input type='hidden' name='CourseID' value=<%=CourseID%> />
            <input type='hidden' name='CourseName' value=<%=CourseName%> />
            <input type="submit" value="Remove" name="remove">
            <input type="submit" value="Cancel" name="cancel">

        </form>
        
        <%
                if(request.getParameter("remove")!=null){
                    if(request.getParameter("remove").equals("Remove")){
                    cao.deleteCourse(Integer.valueOf(CourseID));
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
