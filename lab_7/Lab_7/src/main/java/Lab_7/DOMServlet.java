/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Lab_7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author vy
 */
@WebServlet(name = "DOMServlet", urlPatterns = {"/DOMServlet"})
public class DOMServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            // TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DOMServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center>List of Students in Web Class </center></h1>");

            out.println("<center><table border=1 cellpadding=0 bgcolor=#FFFFFF></center>");
            out.println("<tr><td><b>Name</b></td> <td><b>ID</b></td> <td><b>DATE</b></td> <td><b>CITY</b></td> </tr>");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Turn on namespace support
            factory.setNamespaceAware(true);

            // Create a JAXP document builder
            DocumentBuilder parser = factory.newDocumentBuilder();

            // Read the entire document into memory
            Document document = parser.parse("/media/vy/OneDrive/3/Sem 2/Web Application Development/lab/lab_7/Lab_7/src/main/webapp/exercise 3/WebClass.xml");

            // Obtain the root node of the tree
            Node booklist = document.getDocumentElement();

            NodeList books = booklist.getChildNodes();

            int nBooks = books.getLength();
            for (int i = 0; i < nBooks; i++) {

                Node book = books.item(i);
                if (book.getNodeType() != Node.TEXT_NODE) {
                    out.println("<tr>");
                    printBook(book, out);
                    out.println("</tr>");
                }

            }

            out.println("</body>");
            out.println("</html>");

        } catch (SAXException ex) {
            Logger.getLogger(DOMServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DOMServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    private void printBook(Node book, PrintWriter out) {
        NamedNodeMap attributes = book.getAttributes();

        if (attributes != null) {
            NodeList childNodes = book.getChildNodes();
            String name = "";
            String id = "";
            String date = "";
            String city = "";
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node child = childNodes.item(i);
                String nodeName = child.getLocalName();
                if (nodeName != null) {
                    if (nodeName.equals("name")) {
                        NodeList children = child.getChildNodes();
                        Node dateNode = children.item(0);
                        if (dateNode.getNodeType() == Node.TEXT_NODE) {
                            name = dateNode.getNodeValue();
                        }
                    } else if (nodeName.equals("idNum")) {
                        NodeList children = child.getChildNodes();
                        Node dateNode = children.item(0);
                        if (dateNode.getNodeType() == Node.TEXT_NODE) {
                            id = dateNode.getNodeValue();
                        }
                    } else if (nodeName.equals("date-of-birth")) {
                        NodeList children = child.getChildNodes();
                        Node priceNode = children.item(0);
                        if (priceNode.getNodeType() == Node.TEXT_NODE) {
                            date = priceNode.getNodeValue();
                        }
                    } else if (nodeName.equals("city")) {
                        NodeList children = child.getChildNodes();
                        Node priceNode = children.item(0);
                        if (priceNode.getNodeType() == Node.TEXT_NODE) {
                            city = priceNode.getNodeValue();
                        }
                    }
                }
            }
            out.print("<td>" + name + "</td>" + "<td>" + id + "</td>" + "<td>" + date + "</td>" + "<td>" + city + "</td>");
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
    }
}
