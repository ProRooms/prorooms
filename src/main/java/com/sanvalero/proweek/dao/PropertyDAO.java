package com.sanvalero.proweek.dao;

import com.sanvalero.proweek.domain.Property;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
     * Returns all properties on the database.
     * @return a collection of properties
     * @throws SQLException 
     */
    public ArrayList<Property> getProperties() throws SQLException {
        String sql = "SELECT * FROM CASA";
        
        PreparedStatement query = connection.prepareStatement(sql);
        ResultSet result = query.executeQuery();
        
        ArrayList<Property> propertiesArrList = new ArrayList<>();
        
        while (result.next()) {
            Property property = new Property();
            property.setPropertyId(result.getInt(1));
            property.setType(result.getString(2));
            property.setStreet(result.getString(3));
            property.setSize(result.getInt(4));
            property.setRooms(result.getInt(5));
            property.setBathrooms(result.getInt(6));
            property.setParkingSpaces(result.getInt(7));
            property.setStorageUnits(result.getInt(8));
            property.setDirectionFacing(result.getString(9));
            property.setPrice(result.getDouble(10));
            property.setDistrictId(result.getInt(11));
        }                
        return propertiesArrList;
    }
  
    /**
     * Obtains properties according to type (flat, house, chalet, or commercial).
     * @param type
     * @return a collection of properties
     * @throws java.sql.SQLException
     */
    public ArrayList<Property> searchPropertiesType(String type) throws SQLException {
        String sql = "SELECT * FROM CASA WHERE tipo = ? ORDER BY precio";

        PreparedStatement query = connection.prepareStatement(sql);
        query.setString(1, type);
        ResultSet result = query.executeQuery();
        
        ArrayList<Property> propertiesArrList = new ArrayList<>();
        
        while (result.next()) {
            Property property = new Property();
            property.setPropertyId(result.getInt(1));
            property.setType(result.getString(2));
            property.setStreet(result.getString(3));
            property.setSize(result.getInt(4));
            property.setRooms(result.getInt(5));
            property.setBathrooms(result.getInt(6));
            property.setParkingSpaces(result.getInt(7));
            property.setStorageUnits(result.getInt(8));
            property.setDirectionFacing(result.getString(9));
            property.setPrice(result.getDouble(10));
            property.setDistrictId(result.getInt(11));
        }                
        return propertiesArrList;        
    }
    
    /**
     * Obtains properties that are greater than or equal to the figure entered
     * by the user.
     * @param price
     * @return a collection of properties
     * @throws SQLException 
     */
    public ArrayList<Property> searchPropertiesPrice(double price) throws SQLException {
        String sql = "SELECT * FROM CASA WHERE precio >= ? ORDER BY precio";
        
        PreparedStatement query = connection.prepareStatement(sql);
        query.setDouble(1, price);
        ResultSet result = query.executeQuery();
        
        ArrayList<Property> propertiesArrList = new ArrayList<>();
        
        while (result.next()) {
            Property property = new Property();
            property.setPropertyId(result.getInt(1));
            property.setType(result.getString(2));
            property.setStreet(result.getString(3));
            property.setSize(result.getInt(4));
            property.setRooms(result.getInt(5));
            property.setBathrooms(result.getInt(6));
            property.setParkingSpaces(result.getInt(7));
            property.setStorageUnits(result.getInt(8));
            property.setDirectionFacing(result.getString(9));
            property.setPrice(result.getDouble(10));
            property.setDistrictId(result.getInt(11));
        }                
        return propertiesArrList;        
    }
    
    /**
     * Obtains properties within a district matching the search string entered
     * by the user.
     * @param input
     * @return a collection of properties
     * @throws SQLException 
     */
    public ArrayList<Property> searchDistrict(String input) throws SQLException{
        String sql = "SELECT * FROM CASA C"
                + "INNER JOIN BARRIO B "
                + "ON C.ID_BARRIO = B.ID_BARRIO "
                + "WHERE barrio %? ORDER BY precio";
        
        PreparedStatement query = connection.prepareStatement(sql);
        query.setString(1, input);
        ResultSet result = query.executeQuery();        
        
        ArrayList<Property> propertiesArrList = new ArrayList<>();

        while (result.next()) {
            Property property = new Property();
            property.setPropertyId(result.getInt(1));
            property.setType(result.getString(2));
            property.setStreet(result.getString(3));
            property.setSize(result.getInt(4));
            property.setRooms(result.getInt(5));
            property.setBathrooms(result.getInt(6));
            property.setParkingSpaces(result.getInt(7));
            property.setStorageUnits(result.getInt(8));
            property.setDirectionFacing(result.getString(9));
            property.setPrice(result.getDouble(10));
            property.setDistrictId(result.getInt(11));
        }                
        return propertiesArrList; 
    }
    
    /**
     * Search for properties equal to or above a given price and according to a 
     * specific type.
     * @param price
     * @param type
     * @return
     * @throws SQLException 
     */
    public ArrayList<Property> searchPropertiesPriceType(int price, String type) throws SQLException {
        String sql = "SELECT * FROM CASA WHERE precio >= ? AND tipo = ?";
        
        PreparedStatement query = connection.prepareStatement(sql);
        query.setInt(1, price);
        query.setString(2, type);
        ResultSet result = query.executeQuery();

        ArrayList<Property> propertiesArrList = new ArrayList<>();

        while (result.next()) {
            Property property = new Property();
            property.setPropertyId(result.getInt(1));
            property.setType(result.getString(2));
            property.setStreet(result.getString(3));
            property.setSize(result.getInt(4));
            property.setRooms(result.getInt(5));
            property.setBathrooms(result.getInt(6));
            property.setParkingSpaces(result.getInt(7));
            property.setStorageUnits(result.getInt(8));
            property.setDirectionFacing(result.getString(9));
            property.setPrice(result.getDouble(10));
            property.setDistrictId(result.getInt(11));
        }                
        return propertiesArrList; 
    }   
}