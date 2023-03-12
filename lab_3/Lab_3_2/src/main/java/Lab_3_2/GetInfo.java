/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Lab_3_2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vy
 */
public class GetInfo extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Reading Personal Information</title>");            
            out.println("</head>");
            out.println("<body style=\"background-color: beige\">");
            out.println("<center><h1 >Reading three request parameters </h1></center>");
            out.println("<center><table border=\"1px\">");
            out.println("<tbody>");
            out.println("<tr>"
                           + "<td>ID</td>"
                           + "<td>" + request.getParameter("id") + "</td>"
                        +"</tr>"
            );
            out.println("<tr>"
                           + "<td>Name</td>"
                           + "<td>" + request.getParameter("name") + "</td>"
                        +"</tr>"
            );
            out.println("<tr>"
                           + "<td>Email</td>"
                           + "<td>" + request.getParameter("email") + "</td>"
                        +"</tr>"
            );
            out.println("<tr>"
                           + "<td>Gender</td>"
                           + "<td>" + request.getParameter("gender") + "</td>"
                        +"</tr>"
            );
            out.println("<tr>"
                           + "<td>Major</td>"
                           + "<td>" + request.getParameter("major") + "</td>"
                        +"</tr>"
            );
            out.println("<tr>"
                           + "<td>Major</td>"
                           + "<td>" + request.getParameter("int_field") + "</td>"
                        +"</tr>"
            );
            out.println("</tbody>");
            out.println("</table></center>");
            out.println("</body>");
            out.println("</html>");
        }
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
