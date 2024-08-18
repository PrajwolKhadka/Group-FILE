/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.DoctorModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.AppointmentModel;

/**
 *
 * @author Acer
 */
public class AppointmentDAO {
    private final Connection conn;
     
    public AppointmentDAO(Connection conn) {
        this.conn = conn;
    }
    public Connection getConnection(){
        return conn;
    }

   public void addUser(AppointmentModel u) throws SQLException {
       
        String sql = "INSERT INTO appointment (idAppointment, patientName, doctorName, date, price) VALUES (?,?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, u.getId());
            pstmt.setString(2, u.getPName());
            pstmt.setString(3, u.getDName());
            pstmt.setString(4, u.getDate());
            pstmt.setString(5, u.getPrice());
            pstmt.executeUpdate();
        }
    }


     public void updateUser(AppointmentModel u) throws SQLException {
 
        String sqlSelect = "SELECT patientName, doctorName, date, price FROM appointment WHERE idAppointment=?";
        String sqlUpdate = "UPDATE appointment SET patientName=?, doctorName=?, date=?,  price=? WHERE idAppointment=?";
        String id = u.getId();
        String name = u.getPName();
        String dname = u.getDName();
        String date = u.getDate();
        String price = u.getPrice();

        try (PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect)) {
            pstmtSelect.setString(1, u.getId());
            try (ResultSet rs = pstmtSelect.executeQuery()) {
                if (rs.next()) {
                    // Get existing values from the database
                    String existingName = rs.getString("patientName");
                    String existingDocName = rs.getString("doctorName");
                    String existingdate = rs.getString("date");
                    String existingprice = rs.getString("price");

                    if (name.isEmpty()) {
                        name = existingName;
                    }
                    if (date.isEmpty()) {
                        date = existingdate;
                    }
                    if (dname.isEmpty()) {
                        dname = existingDocName;
                    }
                    if (price.isEmpty()) {
                        price = existingprice;
                    }
                }
            }
        }

        // Perform the update with the modified parameters
        try (PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {
            pstmtUpdate.setString(1, name);
            pstmtUpdate.setString(2, dname);
            pstmtUpdate.setString(3, date);
            pstmtUpdate.setString(4, price);
            pstmtUpdate.setString(5, id); // Set ID for WHERE clause
            pstmtUpdate.executeUpdate();
        }
    }

    public void deleteUser(String id) throws SQLException {
        String sql = "DELETE FROM appointment WHERE idAppointment=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }
    }



  public boolean userExists(String id) throws SQLException {
    // Query the database to check if the user with the given ID exists
    try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM appointment WHERE idAppointment= ?")) {
        pstmt.setString(1, id);
        try (ResultSet rs = pstmt.executeQuery()) {
            return rs.next(); // Return true if a user with the given ID exists, false otherwise
        }
    }
}

}
