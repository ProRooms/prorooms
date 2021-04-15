package com.sanvalero.proweek.servlet;

import com.sanvalero.proweek.dao.PropertyDAO;
import com.sanvalero.proweek.domain.Property;
import java.io.IOException;
import java.io.PrintWriter;
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
        
        
    }

}
