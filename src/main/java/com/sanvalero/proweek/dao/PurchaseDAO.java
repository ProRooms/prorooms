package com.sanvalero.proweek.dao;

import com.sanvalero.proweek.domain.Purchase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Date;

/**
 * Purchase establishes connection with the table COMPRAN in the database.
 * @author bathe
 */
public class PurchaseDAO {

    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL_CONNECTION = "jdbc:oracle:thin:@//localhost:1521/XE";
    private final String USER = "ProWeek";
    private final String PASSWORD = "1234";
    
    private Connection connection;
    
    public PurchaseDAO() { connect(); }
    
    
    /**
     * Connect to the data base.
     */
    public void connect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException cnfe) {
            cnfe.printStackTrace();
        }
    }
    
    /**
     * Disconnect from the database.
     */
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    /**
     * Adds a purchase to the database.
     * @param purchase
     * @throws SQLException 
     */
    public void addPurchase(Purchase purchase) throws SQLException {
        String sql = "INSERT INTO COMPRAN (id_compra, fecha_inicio, id_casa, id_usuario) " +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement query = connection.prepareStatement(sql);

        query.setInt(1, purchase.getId());
        query.setDate(2, Date.valueOf(purchase.getStartDate()));
        query.setInt(3, purchase.getPropertyId());
        query.setInt(4, purchase.getUserId());
        query.executeUpdate();
    }   
}