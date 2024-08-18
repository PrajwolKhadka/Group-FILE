/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class Database {
        private static final String URL = "jdbc:mysql://localhost:3306/clinictables";
    private static final String USER = "root";
    private static final String PASSWORD = "2580";

    public static Connection getConnection() throws SQLException {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Unable to load database driver.", e);
        }

        // Get a connection to the database
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
