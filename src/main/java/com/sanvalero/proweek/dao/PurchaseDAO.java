package com.sanvalero.proweek.dao;


import com.sanvalero.proweek.domain.Purchase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseDAO {

    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL_CONEXION = "jdbc:mysql://localhost:3306/proweek";
    private final String USUARIO = "ProWeek";
    private final String CONTRASENA = "1234";
    
    private Connection connection;
    
    public PurchaseDAO() {
        connect();
    }
    
    /**
     * Conecta con la base de datos
     */
    public void connect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL_CONEXION, USUARIO, CONTRASENA);
            System.out.println("conectado");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    /**
     * Desconecta de la base de datos
     */
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    /**
     * Añade una pelicula a la base de datos
     * @param movie La pelicula con la información que se quiere registrar
     * @throws SQLException 
     */
    public void addPurchase(Purchase purchase) throws SQLException {
        String sql = "INSERT INTO COMPRAN (ID_COMPRA, FECHA_INICIO, ID_CASA, ID_USUARIO) " +
                "VALUES (?, ?, ?, ?)";
        
        PreparedStatement sentencia = connection.prepareStatement(sql);
        sentencia.setInt(1, purchase.getId_purchase());
        sentencia.setString(2, purchase.getFecha_inicio());
        sentencia.setInt(3, purchase.getId_casa());
        sentencia.setInt(4, purchase.getId_usuario());
        sentencia.executeUpdate();
    }
}