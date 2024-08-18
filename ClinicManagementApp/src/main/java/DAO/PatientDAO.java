/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.PatientModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class PatientDAO {
      private final Connection conn;

    public PatientDAO(Connection conn) {
        this.conn = conn;
    }
    public Connection getConnection(){
        return conn;
    }

   public void addUser(PatientModel u) throws SQLException {
        if (contactExists(u.getContact(), null)) {
            throw new SQLException("Contact number is already taken");
        }
        String sql = "INSERT INTO patient (idPatient, Patientname, Contact, Age, Gender) VALUES (?,?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, u.getId());
            pstmt.setString(2, u.getName());
            pstmt.setString(3, u.getContact());
            pstmt.setString(4, u.getAge());
            pstmt.setString(5, u.getGender());
            pstmt.executeUpdate();
        }
    }


     public void updateUser(PatientModel u) throws SQLException {
        if (contactExists(u.getContact(), u.getId())) {
            throw new SQLException("Contact number is already taken");
        }

        String sqlSelect = "SELECT Patientname, Contact, Age, Gender FROM patient WHERE idPatient=?";
        String sqlUpdate = "UPDATE patient SET Patientname=?, Contact=?, Age=?, Gender=? WHERE idPatient=?";
        String id = u.getId();
        String name = u.getName();
        String contact = u.getContact();
        String age = u.getAge();
        String gender = u.getGender();

        try (PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect)) {
            pstmtSelect.setString(1, u.getId());
            try (ResultSet rs = pstmtSelect.executeQuery()) {
                if (rs.next()) {
                    // Get existing values from the database
                    String existingName = rs.getString("Patientname");
                    String existingContact = rs.getString("Contact");
                    String existingAge = rs.getString("Age");
                    String existingGender = rs.getString("Gender");

                    if (name.isEmpty()) {
                        name = existingName;
                    }
                    if (age.isEmpty()) {
                        age = existingAge;
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
            pstmtUpdate.setString(3, age);
            pstmtUpdate.setString(4, gender);
            pstmtUpdate.setString(5, id); // Set ID for WHERE clause
            pstmtUpdate.executeUpdate();
        }
    }

    public void deleteUser(String id) throws SQLException {
        String sql = "DELETE FROM patient WHERE idPatient=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }
    }



  public boolean userExists(String id) throws SQLException {
    // Query the database to check if the user with the given ID exists
    try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM patient WHERE idPatient = ?")) {
        pstmt.setString(1, id);
        try (ResultSet rs = pstmt.executeQuery()) {
            return rs.next(); // Return true if a user with the given ID exists, false otherwise
        }
    }
}

 public boolean contactExists(String contact, String excludeCustomerID) throws SQLException {
        String sql = "SELECT * FROM patient WHERE Contact = ?";
        if (excludeCustomerID != null) {
            sql += " AND idPatient != ?";
        }
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contact);
            if (excludeCustomerID != null) {
                pstmt.setString(2, excludeCustomerID);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Return true if a user with the given contact number exists, false otherwise
            }
        }
    }
}
