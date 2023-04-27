/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Lab_6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vy
 */
public class ShoppingServlet extends HttpServlet {
    private AccountBean acc;
    private List<List<String>> productList;
    private String total = "0";
    private int productId = 0;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // try (PrintWriter out = response.getWriter()) {

        // }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        System.out.println(request.getParameter("idDel") + " " + request.getParameter("submit"));

        if(request.getParameter("submit") != null && request.getParameter("submit").equals("Submit")){
            acc = null;
            productList = null;
            total = "0";
            productId = 0;
        }
        
        createAcc(request, response);
        
        deleteProductFromProductList(request, response);

        createProductList(request, response);

        request.setAttribute("acc", acc);
        request.setAttribute("productList", productList);
        request.setAttribute("total", total);
        
        if (request.getParameter("checkout") == null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/products.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/checkout.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    private void createAcc(HttpServletRequest request, HttpServletResponse response){
        if(this.acc == null){
            acc = new AccountBean();
            acc.setName(request.getParameter("name"));
            acc.setVisaCardNum(Integer.parseInt(request.getParameter("visaCardNum")));
            acc.setAddress(request.getParameter("address"));
        }
    }

    private void createProductList(HttpServletRequest request, HttpServletResponse response){
        if(productList!= null && request.getParameter("submit") != null){
            if(request.getParameter("submit").equals("Add to cart")){
                productList.add(parseProductValue(request, response));
                total = getCurrentTotal(productList);
            }
        }
        if(this.productList == null ) {
            productList = new ArrayList<>();
        }
        
        request.setAttribute("productList", productList);
        request.setAttribute("total", total);
    }

    private void deleteProductFromProductList(HttpServletRequest request, HttpServletResponse response) throws IOException{

        if(request.getParameter("submit") != null){
            if(request.getParameter("submit").equals("Delete")){
                int productId = Integer.parseInt(request.getParameter("idDel"));
                for(List<String> product: productList){
                    if(Integer.parseInt(product.get(0)) == productId){
                        productList.remove(product);
                        break;
                    }
                }
                total = getCurrentTotal(productList);
            }
        }
        
    }

    private List<String> parseProductValue(HttpServletRequest request, HttpServletResponse response){
        List<String> result = new ArrayList<>();
        Float subTotal;
        
        result.add(String.valueOf(productId++));
        String productValues = request.getParameter("product");
        String[] productValuesArr = productValues.split("-");
        for (String productValue : productValuesArr) {
            result.add(productValue);
        }
        result.add(request.getParameter("quantity"));
        subTotal = Float.parseFloat(result.get(4)) * Float.parseFloat(result.get(5)); 
        result.add(String.format("%.2f",subTotal));
        return result;
    }

    private String getCurrentTotal(List<List<String>> productList){
        float total = 0;
        for (List<String> product : productList) {
            total += Float.parseFloat(product.get(6));
        }
        // String resultStr = String.valueOf(total);
        return String.format("%.2f",total);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
