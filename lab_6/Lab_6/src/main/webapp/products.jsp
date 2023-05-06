<%-- 
    Document   : products
    Created on : Apr 26, 2023, 1:07:35 PM
    Author     : vy
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company's products</title>
    </head>
    <body>
        <jsp:useBean id="acc" scope="session" class="Lab_6.AccountBean"/>
        <%!int i = 0;%>
        <h1>Hi <jsp:getProperty name="acc" property="name"/></h1>
        <h2>Please select our products and its quantity</h2>
        <hr>
        
        <form method="post" action="ShoppingServlet">
            <b>Product: </b>
            <select name="product">
                <%for(i = 1; i <= 10; i++){ %>
                <option value="<%=i%>-<%=i%>-<%=i%>-<%=i+.95%>">Product <%=i%>|Manufacturer <%=i%>|Country <%=i%>|<%=i+.95%></option>
                <%}%>
                
            </select>
            <b>Quantity: </b>
            <input type="number" name="quantity" min="1" max="100" width="3"/>
            <input type="submit" name="submit" value="Add to cart"/>
        </form>
                
        <%
            List<List<String>> productList = (List<List<String>>)request.getAttribute("productList");
            String total = (String)request.getAttribute("total");
        %>
        <br>
        <form method="post" action="ShoppingServlet">
            <table style="width:100%">
                <tbody>
                    <%
                        if(!productList.isEmpty()){
                    %>
                    <tr>
                        <th>PRODUCT</th>
                        <th>MANUFACTURER</th>
                        <th>MADE IN</th>
                        <th>PRICE</th>
                        <th>QUANTITY</th>
                        <th></th>
                    </tr>
                    <%
                        }
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
                        <td style="text-align: center">
                            <input type="hidden" name="idDel" value="<%=product.get(0)%>">
                            <input type="submit" name="submit"  value="Delete">
                        </td>
                    </tr>
                    <%
                            }
                        }
                        if(!productList.isEmpty()){
                    %>
                    <tr>
                        <td></td>
                        <td></td>
                        <td style="text-align: center">TOTAL</td>
                        <td style="text-align: center">$<%=total%></td>
                        <td></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </form>
        <form action="ShoppingServlet" method="post">
            <input type="submit" name="checkout" value="Checkout">     
        </form>
    </body>
</html>
