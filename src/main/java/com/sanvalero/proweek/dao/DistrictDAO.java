package com.sanvalero.proweek.dao;

import com.sanvalero.proweek.domain.District;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
     * Lists all districts on the database.
     * @return a collection of districts
     * @throws SQLException 
     */
    public ArrayList<District> getDistricts() throws SQLException {
        String sql = "SELECT * FROM BARRIO";

        PreparedStatement query = connection.prepareStatement(sql);
        ResultSet result = query.executeQuery();
        
        ArrayList<District> districtsArrList = new ArrayList<>();
        
        while (result.next()) {
            District district = new District();
            district.setDistrictId(result.getInt(1));
            district.setDistrictName(result.getString(2));
            district.setDistanceFromCentre(result.getDouble(3));
            district.setZone(result.getString(4));            
        }        
        return districtsArrList;      
    }
}
