package com.sanvalero.proweek.dao;

import com.sanvalero.proweek.domain.Viewing;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.time.LocalDate;

/**
 * Viewing DAO establishes connection to the table VISITAN in the database.
 */
public class ViewingDAO {
    
    //declare instance variables
    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL_CONNECTION = "jdbc:oracle:thin:@//localhost:1521/XE";
    private final String USER = "ProWeek";
    private final String PASSWORD = "1234";
    
    private Connection connection;
    
    public ViewingDAO() { connect();}    
    
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
     * Add the details of a viewing to the database.
     * @param viewing
     * @throws SQLException
     */
    public void addViewing(Viewing viewing) throws SQLException {
        String sql = "INSERT INTO VISITAN (id_visita, fecha, id_casa, id_usuario) " +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement query = connection.prepareStatement(sql);

        query.setInt(1, viewing.getId());
        query.setDate(2, Date.valueOf(viewing.getStartDate()));
        query.setInt(3, viewing.getPropertyId());
        query.setInt(4, viewing.getUserId());
        query.executeUpdate();
    }
    
    /**
     * Modify viewing according to the date entered by the user.
     * @param date
     * @param viewingId
     * @param userId 
     * @throws java.sql.SQLException 
     */
    public void modifyViewingDate(LocalDate date, int viewingId, int userId) throws SQLException {
        String sql = "UPDATE VISITAN SET fe_hora = ? WHERE id_visita = ? "
                + "AND id_usuario = ?";
        
        PreparedStatement query = connection.prepareStatement(sql);
        
        query.setDate(1, Date.valueOf(date));
        query.setInt(2, viewingId);
        query.setInt(3, userId);
    }   
    
    /**
     * Deletes a viewing in which the viewing ID and user ID matches those
     * entered by the user.
     * @param viewingId
     * @param userId
     * @throws SQLException 
     */
    public void deleteViewing(int viewingId, int userId) throws SQLException {
        String sql = "DELETE FROM VISITAN WHERE id_visita = ? AND id_usuario = ?";
        
        PreparedStatement query = connection.prepareStatement(sql);
        
        query.setInt(1, viewingId);
        query.setInt(2, userId);
        query.executeUpdate();        
    }
}
