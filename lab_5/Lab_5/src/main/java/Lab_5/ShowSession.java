/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Lab_5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vy
 */
public class ShowSession extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
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
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        // out.println(new Date(session.getCreationTime()));
        Integer accessNum = 0;
        String title;
        if(session.isNew()){
            session = request.getSession();
            title = "Welcome, Newcomer";
            session.setAttribute("accessNum", accessNum.toString());
            // session.setMaxInactiveInterval(60);
            // out.println("session new");
        } else if(session.getAttribute("accessNum") == null){
            session = request.getSession();
            title = "Welcome, Newcomer";
            session.setAttribute("accessNum", accessNum.toString());
            // session.setMaxInactiveInterval(60);
            // out.println("session not new but no value");
        } else {
            title = "Welcome back";
            accessNum = Integer.parseInt((String) session.getAttribute("accessNum"));
            session.setAttribute("accessNum", (++accessNum).toString());
        }

        

		String docType =
			"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			"Transitional//EN\">\n";

		out.println(docType +
			"<html>\n" +                 
			"<head><title>" + title + "</title></head>\n" +                 
			"<body bgcolor=\"#FDF5E6\">\n" +                 
                "<h1 align=\"center\">" + title + "</h1>\n" +  
                "<br>" +
                "<h2 align=\"center\">Information on your Session:</h2>" +
                "<table align=\"center\" border=\"1\">" +    
                    "<tbody>" +
                        "<tr>" +
                            "<th>Info type</th>" +
                            "<th>Value</th>" +
                        "</tr>" +
                        "<tr>" +
                            "<td>ID</td>" +
                            "<td>" + session.getId() + "</td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td>Creation time</td>" +
                            "<td>" + new Date(session.getCreationTime()) + "</td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td>Time of last access:</td>" +
                            "<td>" + new Date(session.getLastAccessedTime()) + "</td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td>Number of previous access</td>" +
                            "<td>" + (String) session.getAttribute("accessNum") + "</td>" +
                        "</tr>" +
                    "</tbody>" +
                "</table>" +     
			"</body></html>");   
    
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
