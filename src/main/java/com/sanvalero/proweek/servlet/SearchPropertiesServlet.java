package com.sanvalero.proweek.servlet;

import com.sanvalero.proweek.dao.PropertyDAO;
import com.sanvalero.proweek.domain.Property;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "proweek", urlPatterns = {"/search"})
public class SearchPropertiesServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
        
        String type = request.getParameter("tipo");
        double price = Double.parseDouble(request.getParameter("precio"));
        
        PropertyDAO propertyDAO = new PropertyDAO();
       
        try {
            ArrayList<Property> properties = new ArrayList<>();
            properties = propertyDAO.searchPropertiesPriceType(price, type);
            out.println("<ul>");
            for (Property property : properties) {
                out.println("<li>" + property.getType() + "</li>");
                out.println("<li>" + property.getSize() + "</li>");
                out.println("<li>" + property.getRooms() + "</li>");
                out.println("<li>" + property.getBathrooms() + "</li>");
                out.println("<li>" + property.getPrice() + "</li>");
                out.println("<br>");
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
