/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.DoctorModel;
import Model.PatientModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class DoctorDAO {
     private final Connection conn;
     
    public DoctorDAO(Connection conn) {
        this.conn = conn;
    }
    public Connection getConnection(){
        return conn;
    }

   public void addUser(DoctorModel u) throws SQLException {
        if (contactExists(u.getContact(), null)) {
            throw new SQLException("Contact number is already taken");
        }
        String sql = "INSERT INTO doctor (idDoctor, Name, Contact, Faculty, Gender) VALUES (?,?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, u.getId());
            pstmt.setString(2, u.getName());
            pstmt.setString(3, u.getContact());
            pstmt.setString(4, u.getFaculty());
            pstmt.setString(5, u.getGender());
            pstmt.executeUpdate();
        }
    }


     public void updateUser(DoctorModel u) throws SQLException {
        if (contactExists(u.getContact(), u.getId())) {
            throw new SQLException("Contact number is already taken");
        }

        String sqlSelect = "SELECT Name, Contact, Faculty, Gender FROM doctor WHERE idDoctor=?";
        String sqlUpdate = "UPDATE doctor SET Name=?, Contact=?, Faculty=?, Gender=? WHERE idDoctor=?";
        String id = u.getId();
        String name = u.getName();
        String contact = u.getContact();
        String faculty = u.getFaculty();
        String gender = u.getGender();

        try (PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect)) {
            pstmtSelect.setString(1, u.getId());
            try (ResultSet rs = pstmtSelect.executeQuery()) {
                if (rs.next()) {
                    // Get existing values from the database
                    String existingName = rs.getString("Name");
                    String existingContact = rs.getString("Contact");
                    String existingFaculty = rs.getString("Faculty");
                    String existingGender = rs.getString("Gender");

                    if (name.isEmpty()) {
                        name = existingName;
                    }
                    if (faculty.isEmpty()) {
                        faculty = existingFaculty;
                    }
                    if (contact.isEmpty()) {
                        contact = existingContact;
                    }
                    if (gender.isEmpty()) {
                        gender = existingGender;
                    }
                }
            }
        }

        // Perform the update with the modified parameters
        try (PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {
            pstmtUpdate.setString(1, name);
            pstmtUpdate.setString(2, contact);
            pstmtUpdate.setString(3, faculty);
            pstmtUpdate.setString(4, gender);
            pstmtUpdate.setString(5, id); // Set ID for WHERE clause
            pstmtUpdate.executeUpdate();
        }
    }

    public void deleteUser(String id) throws SQLException {
        String sql = "DELETE FROM doctor WHERE idDoctor=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }
    }



  public boolean userExists(String id) throws SQLException {
    // Query the database to check if the user with the given ID exists
    try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM doctor WHERE idDoctor= ?")) {
        pstmt.setString(1, id);
        try (ResultSet rs = pstmt.executeQuery()) {
            return rs.next(); // Return true if a user with the given ID exists, false otherwise
        }
    }
}

 public boolean contactExists(String contact, String excludeDoctorID) throws SQLException {
        String sql = "SELECT * FROM doctor WHERE Contact = ?";
        if (excludeDoctorID != null) {
            sql += " AND idDoctor != ?";
        }
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contact);
            if (excludeDoctorID != null) {
                pstmt.setString(2, excludeDoctorID);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Return true if a user with the given contact number exists, false otherwise
            }
        }
    }
}
