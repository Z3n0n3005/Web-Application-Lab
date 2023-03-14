<%-- 
    Document   : adminpanel
    Created on : Mar 12, 2023, 9:18:38 AM
    Author     : vy
--%>

<%@page import="cn.techtutorial.cib.admin.model.Admin"%>
<%@page import="cn.techtutorial.cib.connection.ConnectionDB"%>
<%
    Admin admin = (Admin) session.getAttribute("loggedAdmin");
    if(admin == null){
        response.sendRedirect("adminlogin.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%= admin.toString() %>
    </body>
</html>
