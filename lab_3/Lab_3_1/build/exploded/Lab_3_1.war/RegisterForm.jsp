<%-- 
    Document   : index
    Created on : Mar 7, 2023, 3:43:41 PM
    Author     : vy
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: pink">
        <h1 style="border-bottom: 1px black solid">School of Computer Science & Engineering</h1>
        
        <h2>Register Form</h2>
        <form method="post" action="RegisterCourse">
            <table>
                <tbody>
                    <tr>
                        <th>Full Name</th>
                        <td><input type="text" name ="full_name" size="20"></td>
                    </tr>
                    <tr>
                        <th>ID</th>
                        <td><input type="text" name ="ID" size="15"></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><input type="text" name ="email" size="20"></td>
                    </tr>
                    <tr>
                        <th>Gender</th>
                        <td>
                            <input type="radio" value="Male" checked name="gender">Male
                            <input type="radio" value="Female" checked name="gender">Female
                        </td>
                    </tr>
                    <tr>
                        <th>List of subjects</th>
                        <td>
                            <select name="field_of_study">
                                <option value="Computer Science">CS</option>
                                <option value="Electrical Engineering">EE</option>
                                <option value="Business Admininstrator">BA</option>
                                <option value="Biological Engineering">BE</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td><input type="checkbox" name="checkbox" value="Principle of EE 1">Principle of EE 1</td>
                    </tr>
                    <tr>
                        <th></th>
                        <td><input type="checkbox" name="checkbox" value="Computer Network">Computer Network</td>
                    </tr>
                    <tr>
                        <th>List of subjects</th>
                        <td><input type="checkbox" name="checkbox" value="Web Application Development">Web Application Development</td>
                    </tr>
                    <tr>
                        <th></th>
                        <td><input type="checkbox" name="checkbox" value="Object Oriented Programming">Object Oriented Programming</td>
                    </tr>
                    <tr>
                        <th></th>
                        <td><input type="checkbox" name="c5" value="Computer Graphics">Computer Graphics</td>
                    </tr>
                    <tr>
                        <th>Comments</th>
                        <td><textarea rows="5" name="comment" cols="30"></textarea><br></td>
                    </tr>
                    <tr>
                        <th><input type="submit" value="Submit"></th>
                        <td><input type="reset" value="Cancel"></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            
        </form>
    </body>
</html>
