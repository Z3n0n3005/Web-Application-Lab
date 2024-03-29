<%-- 
    Document   : StudentDetail
    Created on : Mar 12, 2023, 10:58:59 PM
    Author     : vy
--%>

<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="course.CourseDao"%>
<%@page import="course.Course"%>
<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder.*"%>
<%@page import="studentcourse.StudentCourseDao"%>
<%@page import="student.StudentDao"%>
<%@page import="connection.ConnectionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% 
    String StudentID = request.getParameter("StudentID"); 
    String StudentName = request.getParameter("StudentName");
    StudentDao sao = new StudentDao(ConnectionDB.getCon());
    CourseDao cao = new CourseDao(ConnectionDB.getCon());
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
        <h1>Student's Details</h1>
        Student ID: <%= StudentID%> <br>
        Student name: <%= StudentName%> <br>
        <h2>Select Course</h2>
        Course: 
        <form>
            <input type="hidden" name="StudentID" value=<%=StudentID%>>
            
            <input type="hidden" name="StudentName" value=<%=StudentName.replaceAll("//s+", "_")%>>

            <select name="field_of_study">
                <%
                    List<Course> listAllAvailableCourse = cao.listAllCourse();
                    for(Course course : listAllAvailableCourse){
                        String CourseName = course.getCourseName();
                        String CourseNameRep = CourseName.replaceAll("//s+", "_");
//                        out.print("<option value=" + java.net.URLEncoder.encode(CourseName, StandardCharsets.UTF_8.toString()) +">" + CourseName + "</option>");
                        out.print("<option value=" + CourseNameRep +">" + CourseName + "</option>");

                    }
                %>
            </select>
            <input type="submit" value="Add" name="Add">
        </form>
        <% 
            if(request.getParameter("Add")!= null){
                if(request.getParameter("Add").equals("Add")){
//                    String CourseNameDecoded = java.net.URLDecoder.decode(request.getParameter("field_of_study"), StandardCharsets.UTF_8.toString());
//                    String StudentNameDecoded = java.net.URLDecoder.decode(request.getParameter("StudentName"), StandardCharsets.UTF_8.toString());
                    String CourseNameDecoded = request.getParameter("field_of_study").replaceAll("_", " ");
                    out.println(CourseNameDecoded);
                    String StudentNameDecoded = request.getParameter("StudentName").replaceAll("_", " ");
                    out.println(StudentNameDecoded);

                    Integer CourseID = cao.findCourseID(CourseNameDecoded);
                    scao.addStudentCourse(Integer.valueOf(StudentID), CourseID);
                    response.sendRedirect("StudentDetail.jsp?StudentName=" + StudentNameDecoded + "&StudentID=" + StudentID);
                    
                }
            }
            
        %>
        <h2>Registered Courses:</h2>
        <table>
            <tbody>
                <tr>
                    <th>Course ID</th>
                    <th>Course Name</th>
                    <th>Action</th>
                </tr>
                <% 
                    List<Course> listAllCourse = scao.listAllCourse(Integer.valueOf(StudentID));
                    for(Course course : listAllCourse){
                        int CourseID = course.getCourseID();
                        String CourseName = course.getCourseName();
                        out.print("<tr>");
                        out.print("<td>" + CourseID + "</td>");
                        out.print("<td>" + CourseName + "</td>");
                        out.print("<td><a href=\"../studentcourse/StudentCourseRemove.jsp?StudentID="+StudentID+"&StudentName="+StudentName+"&CourseID="+CourseID+"&CourseName="+CourseName+"&from=StudentDetail"+"\">Remove</a></td>");
                        out.print("</tr>");
                    }
                %>
            </tbody>
        </table>
        <br>
        <a href="../CourseRegistrationDemo.jsp"> Homepage</a><br>

    </body>
    
</html>
