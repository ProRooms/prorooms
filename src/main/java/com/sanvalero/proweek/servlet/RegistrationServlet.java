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
@WebServlet(name = "proweek", urlPatterns = {"/login"})
public class RegistrationServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException { 
    
        String name = request.getParameter("nombre");
        String surname = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telefono");
        
        User user = new User(name, surname, email, telephone);
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.addUser(user);            
            PrintWriter out = response.getWriter();
            response.sendRedirect("myform.jsp?status=ok");           
        } catch (SQLException sqle) {
            response.sendRedirect("myform.jsp?status=error");
        }    
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
