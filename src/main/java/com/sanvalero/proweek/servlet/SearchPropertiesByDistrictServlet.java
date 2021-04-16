/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanvalero.proweek.servlet;

import com.sanvalero.proweek.dao.DistrictDAO;
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

@WebServlet(name = "login", urlPatterns = {"/userportal"})
public class SearchPropertiesByDistrictServlet extends HttpServlet  {
    
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
        
        String districtString = request.getParameter("barrio");
            
        PropertyDAO propertyDAO = new PropertyDAO();
       
        try {
            ArrayList<Property> properties = new ArrayList<>();
            properties = propertyDAO.searchDistrict(districtString);
            out.println("<ul>");
            for (Property property : properties) {
                out.println("<li>" + property.getPropertyId() + "</li>");
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
    
}
