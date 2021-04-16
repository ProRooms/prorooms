/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanvalero.proweek.servlet;

import com.sanvalero.proweek.dao.UserDAO;
import com.sanvalero.proweek.domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class DeleteUser extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
        String password = request.getParameter("contrasena");
        
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.deleteUser(password);            
            PrintWriter out = response.getWriter();
            response.sendRedirect("login.jsp?status=ok");           
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            response.sendRedirect("login.jsp?status=error");
        }  
    }
    
}
