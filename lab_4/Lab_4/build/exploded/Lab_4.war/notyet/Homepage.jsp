<%-- 
    Document   : homepage
    Created on : Mar 11, 2023, 9:15:16 PM
    Author     : vy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
    </head>
    <body>
        <center>
            <h1 style="border-bottom: 1px black solid">Homepage</h1>
        </center
        <h2>Visiting counter</h2>
        <%! private int accessCount = 0;%>
        <h2>Accesses to page since server reboot: <%= ++accessCount %></h2>
    </body>
</html>
