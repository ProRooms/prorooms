package com.sanvalero.proweek.dao;

import com.sanvalero.proweek.domain.Property;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Property DAO establishes connection with the table CASA in the database.
 */
public class PropertyDAO {
    
    //declare instance variables
    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL_CONNECTION = "jdbc:oracle:thin:@//localhost:1521/XE";
    private final String USER = "ProWeekHr";
    private final String PASSWORD = "1234";
    
    private Connection connection;
    
    public PropertyDAO() { connect(); }
    
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
     * Add the details of a property to the database.
     * @param property
     * @throws SQLException 
     */
    public void addProperty(Property property) throws SQLException {
        String sql = "INSERT INTO CASA (id_casa, habitaciones, m2, garaje, precio, trastero, orientacion, baños," +
                "id_barrio, tipo, calle) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement query = connection.prepareStatement(sql);

        query.setInt(1, property.getPropertyId());
        query.setInt(2, property.getRooms());
        query.setInt(3, property.getSize());
        query.setInt(4, property.getParkingSpaces());
        query.setDouble(5, property.getPrice());
        query.setInt(6, property.getStorageUnits());
        query.setString(7, property.getDirectionFacing());
        query.setInt(8, property.getBathrooms());
        query.setInt(9, property.getDistrictId());
        query.setString(10, property.getType());
        query.setString(11, property.getStreet());

        query.executeUpdate();
    }
    
}
