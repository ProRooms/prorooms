package com.sanvalero.proweek.servlet;

import com.sanvalero.proweek.dao.RentalDAO;
import com.sanvalero.proweek.domain.Rental;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet que añade una película a la base de datos
 */
@WebServlet(name = "add-alquilan", urlPatterns = {"/add-alquilan"})
public class AddAlquilanServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int id_alquiler = Integer.parseInt(request.getParameter("id_alquiler"));
        String fe_inicio = request.getParameter("fe_inicio");
        String fe_fin = request.getParameter("fe_fin");
        int id_casa = Integer.parseInt(request.getParameter("id_casa"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        
        Rental alquilan = new Rental(id_alquiler, fe_inicio, fe_fin, id_casa, id_usuario);
        RentalDAO alquilanDAO = new RentalDAO();
        try {
            alquilanDAO.addAlquilan(alquilan);
            
            PrintWriter out = response.getWriter();
            response.sendRedirect("myform.jsp?status=ok");
        } catch (SQLException sqle) {
            response.sendRedirect("myform.jsp?status=error");
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