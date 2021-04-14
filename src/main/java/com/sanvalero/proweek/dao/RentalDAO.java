package com.sanvalero.proweek.dao;

import com.sanvalero.proweek.domain.Rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Date;

public class RentalDAO {

    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL_CONNECTION = "jdbc:mysql://localhost:3306/proweek";
    private final String USER = "ProWeek";
    private final String PASSWORD = "1234";
    
    private Connection connection;
    
    public RentalDAO() {
        connect();
    }
    
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
     * Add a rented property to the database.
     * @param rental
     * @throws SQLException
     */
    public void addRental(Rental rental) throws SQLException {
        String sql = "INSERT INTO ALQUILAN (id_alquiler, fecha_inicio, fecha_fin,"
                + " id_casa, id_usuario) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement query = connection.prepareStatement(sql);

        query.setInt(1, rental.getId());
        query.setDate(2, Date.valueOf(rental.getStartDate()));
        query.setDate(3, Date.valueOf(rental.getEndDate()));
        query.setInt(4, rental.getPropertyId());
        query.setInt(5, rental.getUserId());
        query.executeUpdate();
    }
    
    /***TODO************************************************************************************************************/
    /**
     * Obtiene la lista de peliculas de la base de datos
     * @return Una colección con las peliculas
     */
    public ArrayList<Rental> getAllMovies() throws SQLException {        
        return new ArrayList<>();
    }
    
    /**
     * Elimina una película
     * @param id El id de la pelicula a eliminar
     */
    public void removeMovie(int id) {
        
    }
    
    /**
     * Modifica la información de una pelicula
     * @param movie La película con la información a modificar
     */
    public void modifyMovie(Rental alquilan) {
        
    }
}