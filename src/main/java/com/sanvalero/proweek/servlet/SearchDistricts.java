/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanvalero.proweek.servlet;

import com.sanvalero.proweek.dao.DistrictDAO;
import com.sanvalero.proweek.domain.District;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that obtains the properties listed in the database.
 */
@WebServlet(name = "proweek", urlPatterns = {"/search"})
public class SearchDistricts extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String input = request.getParameter("barrio");
        
        
        DistrictDAO districtDAO = new DistrictDAO();
        
        try {
            ArrayList<District> districts = new ArrayList<>();
            districts = districtDAO.searchDistricts(input);
            out.println("<ul>");
            for (District district : districts) {
                out.println("<li>" + district.getDistrictName() + "</li>");
                out.println("<li>" + district.getDistanceFromCentre() + "</li>");
                out.println("<li>" + district.getZone() + "</li>");  
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
