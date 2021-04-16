package com.sanvalero.proweek.servlet;

import com.sanvalero.proweek.dao.UserDAO;
import com.sanvalero.proweek.domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that registers the a new user's details to a database.
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class RegistrationServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    
        String name = request.getParameter("nombre");
        String surname = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telefono");
        String password = request.getParameter("psw");
        
        User user = new User(name, surname, email, telephone, password);
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.addUser(user);            
            PrintWriter out = response.getWriter();
            response.sendRedirect("login.jsp?status=ok");           
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            response.sendRedirect("login.jsp?status=error");
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
