<%-- 
    Document   : StudentCourseRemove
    Created on : Mar 14, 2023, 10:27:38 AM
    Author     : vy
--%>

<%@page import="studentcourse.StudentCourseDao"%>
<%@page import="connection.ConnectionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% 
    String StudentID = request.getParameter("StudentID"); 
    String StudentName = request.getParameter("StudentName"); 

    String CourseID = request.getParameter("CourseID");
    String CourseName = request.getParameter("CourseName"); 
    
    String from = request.getParameter("from");

    StudentCourseDao scao = new StudentCourseDao(ConnectionDB.getCon());
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Would you like to remove <%= CourseName %> from <%= StudentName %>?</h1> 
        <form>
            <input type='hidden' name='StudentID' value=<%=StudentID%> />
            <input type='hidden' name='StudentName' value=<%=StudentName%> />
            <input type='hidden' name='CourseID' value=<%=CourseID%> />
            <input type='hidden' name='CourseName' value=<%=CourseName%> />
            <input type='hidden' name='from' value=<%=from%> />
            <input type="submit" value="Remove" name="remove">
            <input type="submit" value="Cancel" name="cancel">

        </form>
        
        <%
                        
                if(request.getParameter("remove")!=null){
                    if(request.getParameter("remove").equals("Remove")){
                        scao.removeStudentCourse(Integer.valueOf(StudentID),Integer.valueOf(CourseID));
                        if(from.equals("CourseDetail")){
                            response.sendRedirect("../course/CourseDetail.jsp?CourseID=" + CourseID + "&CourseName=" + CourseName);
                        }
                        if(from.equals("StudentDetail")){
                            response.sendRedirect("../student/StudentDetail.jsp?StudentID=" + StudentID + "&StudentName=" + StudentName);
                        }
                    }
                }
                if(request.getParameter("cancel")!=null){
                    if(request.getParameter("cancel").equals("Cancel") ){
                        if(from.equals("CourseDetail")){
                            response.sendRedirect("../course/CourseDetail.jsp?CourseID=" + CourseID + "&CourseName=" + CourseName);
                        }
                        if(from.equals("StudentDetail")){
                            response.sendRedirect("../student/StudentDetail.jsp?StudentID=" + StudentID + "&StudentName=" + StudentName);
                        }
                    }
                }
        %>
    </body>
</html>
