package com.sanvalero.proweek.servlet;

import com.sanvalero.proweek.dao.PurchaseDAO;
import com.sanvalero.proweek.domain.Purchase;
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
@WebServlet(name = "add-purchase", urlPatterns = {"/add-purchase"})
public class AddPurchaseServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int id_compran = Integer.parseInt(request.getParameter("id_compran"));
        String fe_inicio = request.getParameter("fe_inicio");
        int id_casa = Integer.parseInt(request.getParameter("id_casa"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        
        Purchase purchase = new Purchase(id_compran, fe_inicio, id_casa, id_usuario);
        PurchaseDAO purchaseDAO = new PurchaseDAO();
        try {
            purchaseDAO.addPurchase(purchase);
            
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