package com.sanvalero.proweek.dao;

import com.sanvalero.proweek.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Date;

/**
 * User DAO establishes connection with the table USUARIO in the database.
 */
public class UserDAO {
    
    //declare instance variables
    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL_CONNECTION = "jdbc:oracle:thin:@//localhost:1521/XE";
    private final String USER = "ProWeekHr";
    private final String PASSWORD = "1234";
    

    private Connection connection;
    
    public UserDAO() { connect();}
    
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
    
public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO USUARIO (id_usuario, nombre, apellidos, fe_nacimiento, email, telefono) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement query = connection.prepareStatement(sql);

        query.setInt(1, user.getUserId());
        query.setString(2, user.getName());
        query.setString(3, user.getSurname());
        query.setDate(4, Date.valueOf(user.getDob()));
        query.setString(5, user.getEmail());
        query.setString(5, user.getTelephone());
    }    
}
