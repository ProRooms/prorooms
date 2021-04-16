package com.sanvalero.proweek.servlet;

import com.sanvalero.proweek.dao.PropertyDAO;
import com.sanvalero.proweek.domain.Property;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that obtains the properties listed in the database.
 */
@WebServlet(name = "gett", urlPatterns = {"/gett"})
public class GetDistricts extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        PrintWriter out = response.getWriter();
        out.println("<h1>Listado de Casas en Zaragoza</h1>");
        PropertyDAO propertyDAO = new PropertyDAO();
        try {
            ArrayList<Property> properties = propertyDAO.getProperties();
            out.println("<ul>");
            for (Property property : properties) {
                out.println("<li>" + property.getType() + "</li>");
                out.println("<li>" + property.getSize() + "</li>");
                out.println("<li>" + property.getRooms() + "</li>");
                out.println("<li>" + property.getBathrooms() + "</li>");
                out.println("<li>" + property.getPrice() + "</li>");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }        
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
}
