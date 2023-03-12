<%-- 
    Document   : PersonalInfo
    Created on : Mar 11, 2023, 1:15:28 PM
    Author     : vy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: pink;">
        <center><h1 style="border-bottom: 1px black solid;">Personal Information</h1></center>
        
        <form method="post" action="GetInfo">
            <table>
                <tbody>
                    <tr>
                        <td>ID</td>
                        <td><input type="text" name ="id" size="15"></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name ="name" size="30"></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name ="email" size="15"></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td>
                            <input type="radio" value="Male" checked name="gender">Male
                            <input type="radio" value="Female" checked name="gender">Female
                        </td>
                    </tr>
                    <tr>
                        <td>Major</td>
                        <td>
                            <select name="major">
                                <option value="Computer Science">Computer Science</option>
                                <option value="Electrical Engineering">Electrical Engineering</option>
                                <option value="Business Administrator">Business Administrator</option>
                                <option value="Biological Engineering">Biological Engineering</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Interesting Field</td>
                        <td><textarea rows="5" name="int_field" cols="35"></textarea><br></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Insert"></td>
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
