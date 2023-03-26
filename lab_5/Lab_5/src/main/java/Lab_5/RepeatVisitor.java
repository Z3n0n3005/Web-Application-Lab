/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Lab_5;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vy
 */
public class RepeatVisitor extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
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

        boolean newbie = true;  
		Cookie[] cookies = request.getCookies();   
        Integer cVisit = 0;
        // Cookie currentCookie = null;
		if (cookies != null) {   
			for(int i=0; i<cookies.length; i++) {   
				Cookie c = cookies[i];   
                // Could omit test and treat cookie name as a flag  
				if ((c.getName().equals("repeatVisitor"))) {   
                    Integer temp = Integer.parseInt(c.getValue());
                    temp++;
                    cVisit = temp;
					newbie = false;   
					break;   
                }
			}   
		}  
		

		String title;  
        // Integer cValue = 0;
		if (newbie) {  
			Cookie returnVisitorCookie = new Cookie("repeatVisitor", "0");
			returnVisitorCookie.setMaxAge(-1); // 3 minutes
			response.addCookie(returnVisitorCookie);
			title = "Welcome Aboard";
		} else {
            Cookie returnVisitorCookie = new Cookie("repeatVisitor", cVisit.toString());
            returnVisitorCookie.setMaxAge(-1);
            response.addCookie(returnVisitorCookie);
			title = "Welcome Back";
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
            "<center>Counter: " + cVisit +  "</center>" +         
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
