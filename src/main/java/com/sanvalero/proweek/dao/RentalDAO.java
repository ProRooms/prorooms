package com.sanvalero.proweek.dao;


import com.sanvalero.proweek.domain.Rental;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentalDAO {

    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL_CONEXION = "jdbc:mysql://localhost:3306/proweek";
    private final String USUARIO = "ProWeek";
    private final String CONTRASENA = "1234";
    
    private Connection connection;
    
    public RentalDAO() {
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
    public void addAlquilan(Rental rental) throws SQLException {
        String sql = "INSERT INTO alquilan (ID_ALQUILER, FECHA_INICIO, FECHA_FIN, ID_CASA, ID_USUARIO) " +
                "VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement sentencia = connection.prepareStatement(sql);
        sentencia.setInt(1, rental.getId_alquiler());
        sentencia.setString(2, rental.getFecha_inicio());
        sentencia.setString(3, rental.getFecha_fin());
        sentencia.setInt(4, rental.getId_casa());
        sentencia.setInt(5, rental.getId_usuario());
        sentencia.executeUpdate();
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