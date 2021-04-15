package com.sanvalero.proweek.dao;

import com.sanvalero.proweek.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

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
    
    /**
     * Registers a new user adding them to the database.
     * @param user
     * @throws SQLException 
     */
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
        query.executeUpdate();
    }
    
    /**
     * Lists the details of a user according to their user ID.
     * @param userId
     * @return a user object
     * @throws SQLException 
     */
    public User showUserDetailsID(int userId) throws SQLException {
        String sql = "SELECT * FROM USUARIO WHERE id_usuario = ?";
        
        PreparedStatement query = connection.prepareStatement(sql);
        query.setInt(1, userId);
        ResultSet result = query.executeQuery();
            
        ArrayList<User> usersArrList = new ArrayList<>();
            
        while (result.next()) {
            User user = new User();
            user.setUserId(result.getInt(1));
            user.setName(result.getString(2));
            user.setSurname(result.getString(3));
            user.setDob(result.getDate(4).toLocalDate());
            user.setEmail(result.getString(5));
            user.setTelephone(result.getString(6));
            usersArrList.add(user);
        }
        
        return usersArrList.get(0);
    }
    
    /**
     * List the details of a user according to their name and surname.
     * @param name
     * @param surname
     * @return a user object
     * @throws SQLException 
     */
    public User showUserDetailsName(String name, String surname) throws SQLException {
        String sql = "SELECT * FROM USUARIO WHERE nombre = ? AND  apellidos = ?)";
        
        PreparedStatement query = connection.prepareStatement(sql);
        query.setString(1, name);
        query.setString(2, surname);
        ResultSet result = query.executeQuery();
        
        ArrayList<User> usersArrList = new ArrayList<>();
    
        while (result.next()) {
            User user = new User();
            user.setUserId(result.getInt(1));
            user.setName(result.getString(2));
            user.setSurname(result.getString(3));
            user.setDob(result.getDate(4).toLocalDate());
            user.setEmail(result.getString(5));
            user.setTelephone(result.getString(6));
            usersArrList.add(user);
        }
        
        return usersArrList.get(0);  
    }
    
    /**
     * Modfiies the name of a registered user.
     * @param name
     * @param userId
     * @throws java.sql.SQLException
     */ 
    public void modifyUserName(String name, int userId) throws SQLException {
        String sql = "UPDATE USUARIO SET nombre = ? WHERE id_usuario = ?";
        PreparedStatement query = connection.prepareStatement(sql);
        query.setString(1, name);
        query.setInt(2, userId);
        query.executeUpdate();
    }
    
    /**
     * Modifies the surname of a registered user.
     * @param surname
     * @param userId
     * @throws java.sql.SQLException
     */
    public void modifyUserSurname(String surname, int userId) throws SQLException {
        String sql = "UPDATE USUARIO SET appelidos = ? WHERE id_usuario = ?";
        
        PreparedStatement query = connection.prepareStatement(sql);
        query.setString(1, surname);
        query.setInt(2, userId);
        query.executeUpdate();
    }
        
    /**
     * Modifies the email of a registered user.
     * @param email
     * @param userId
     * @throws java.sql.SQLException
     */
    public void modifyUserEmail(String email, int userId) throws SQLException {
        String sql = "UPDATE USUARIO SET email = ? WHERE id_usuario = ? ";
        
        PreparedStatement query = connection.prepareStatement(sql);
        query.setString(1, email);
        query.setInt(2, userId);
        query.executeUpdate();
    }
    
    /**
     * Modifies the telephone of a registered user.
     * @param telephone
     * @param userId
     * @throws java.sql.SQLException
     */
    public void modifyUserTelephone(String telephone, int userId) throws SQLException {
        String sql = "UPDATE USUARIO SET telefono = ? WHERE id_usuario = ?";
        
        PreparedStatement query = connection.prepareStatement(sql);
        query.setString(1, telephone);
        query.setInt(2, userId);
        query.executeUpdate();
    }
    

    /**
     * Modifies the date of birth(DOB) of a registered user
     * @param dob
     * @param userId
     * @throws SQLException
     */
    public void modifyUserDOB(LocalDate dob, int userId) throws SQLException {
        String sql = "UPDATE USUARIO SET fe_nacimiento = ? WHERE id_usuario = ?";
        
        PreparedStatement query = connection.prepareStatement(sql);
        query.setDate(1, Date.valueOf(dob));
        query.setInt(2, userId);
        query.executeUpdate();                
    }
           
    /**
     * Deletes a user from the database according to their user ID.
     * @param user
     * @throws SQLException 
     */
    public void deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM USUARIOS WHERE usuario_id = ?";
        
        deleteUsersViewings(user.getUserId());
        
        PreparedStatement query = connection.prepareStatement(sql);
        query.setInt(1, user.getUserId());
        query.executeUpdate();       
    }
    
    /**
     * Invoked when deleting a user; deletes a user's viewings.
     * @param userId
     * @throws java.sql.SQLException
     */
    public void deleteUsersViewings(int userId) throws SQLException {
        String sql = "DELETE FROM VISITAN WHERE usuario_id = ?";
        
        PreparedStatement query = connection.prepareStatement(sql);
        query.setInt(1, userId);
        query.executeUpdate();
    }
}