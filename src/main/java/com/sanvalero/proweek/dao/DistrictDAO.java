package com.sanvalero.proweek.dao;

import com.sanvalero.proweek.domain.District;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * District DAO establishes connection with the table BARRIO in the database.
 */
public class DistrictDAO {
    
    //declare instance variables
    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL_CONNECTION = "jdbc:oracle:thin:@//localhost:1521/XE";
    private final String USER = "ProWeek";
    private final String PASSWORD = "1234";

    private Connection connection;
    
    public DistrictDAO() { connect();}
    
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
     * Add the details of a district to the database.
     * @param district
     * @throws SQLException 
     */
    public void addDistrict(District district) throws SQLException {
        String sql = "INSERT INTO BARRIO (id_barrio, nombre, distancia, zona) " +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement query = connection.prepareStatement(sql);

        query.setInt(1, district.getDistrictId());
        query.setString(2, district.getDistrictName());
        query.setDouble(3, district.getDistanceFromCentre());
        query.setString(4, district.getZone());
    }
}
