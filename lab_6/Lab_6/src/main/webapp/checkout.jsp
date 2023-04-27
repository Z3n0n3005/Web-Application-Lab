<%-- 
    Document   : checkout
    Created on : Apr 26, 2023, 1:07:12 PM
    Author     : vy
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products Checkout</title>
    </head>
    <body>
        <jsp:useBean id="acc" scope="session" class="Lab_6.AccountBean"/>
        <p><b>Customer: <jsp:getProperty name="acc" property="name"/></b></p>
        <p><b>VISA Number: <jsp:getProperty name="acc" property="visaCardNum"/></b></p>
        <p><b>Address: <jsp:getProperty name="acc" property="address"/></b></p>
        <p><b>productList</b></p><br>

        <hr>
        <br>

        <%
            List<List<String>> productList = (List<List<String>>)request.getAttribute("productList");
            String total = (String)request.getAttribute("total");
        %>

        <table style="width:100%" >
            <tbody>
                <tr>
                    <th>PRODUCT</th>
                    <th>MANUFACTURER</th>
                    <th>MADE IN</th>
                    <th>PRICE</th>
                    <th>QUANTITY</th>
                    <th>SUBTOTAL</th>
                </tr>
                <%
                    if(productList != null){
                        for(List<String> product : productList){
                %>
                <tr>
                    <!-- No product.get(0) due to it being the id in cart -->
                    <td style="text-align: center">Product <%=product.get(1)%></td>
                    <td style="text-align: center">Manufacturer <%=product.get(2)%></td>
                    <td style="text-align: center">Country <%=product.get(3)%></td>
                    <td style="text-align: center"><%=product.get(4)%></td>
                    <td style="text-align: center"><%=product.get(5)%></td>
                    <td style="text-align: center"><%=product.get(6)%></td>
                </tr>
                <%
                        }
                    }   
                %>
                <tr>
                    <td></td>
                    <td></td>
                    <td style="text-align: center">TOTAL</td>
                    <td style="text-align: center">$<%=total%></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        
        <a href="ShoppingServlet">Shop some more!</a> | <a href="account.jsp">Logout</a>
    </body>
</html>
