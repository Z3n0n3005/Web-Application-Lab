/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Lab_3_3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vy
 */
public class RegisterCourse extends HttpServlet {

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
        String listOfSubjects[] = request.getParameterValues("checkbox");
        String result = "";
        if(listOfSubjects != null){
            for(String subject: listOfSubjects){
                result += subject + "<br>";
            }
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterCourse</title>");            
            out.println("</head>");
            out.println("<body style=\"background-color: beige\">");
            out.println("<center><h1 >Register Course Information </h1></center>");
            out.println("<center><table border=\"1px\">");
            out.println("<tbody>");
            out.println("<tr>"
                           + "<td>Full Name</td>"
                           + "<td>" + request.getParameter("full_name") + "</td>"
                        +"</tr>"
            );
            out.println("<tr>"
                           + "<td>ID</td>"
                           + "<td>" + request.getParameter("id") + "</td>"
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
                           + "<td>List of subjects</td>"
                           + "<td>" + result + "</td>"
                        +"</tr>"
            );
            out.println("<tr>"
                           + "<td>Comments</td>"
                           + "<td>" + request.getParameter("comment") + "</td>"
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
