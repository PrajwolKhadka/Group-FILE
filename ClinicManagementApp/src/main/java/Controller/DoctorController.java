/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DoctorDAO;
import DAO.PatientDAO;
import Model.Database;
import Model.DoctorModel;
import Model.PatientModel;
import View.Doctor;
import View.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class DoctorController {
        private final Doctor up;
    private final DoctorDAO userdao;
    
     public DoctorController(Doctor up) {
        this.up = up;
        Connection conn = null;
        try {
            conn = Database.getConnection();
            this.userdao= new DoctorDAO(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(up, "Error establishing database connection: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Unable to establish database connection.", e);
        }
        
        up.getAddButton().addActionListener(new AddButtonListener());
        up.getUpdateButton().addActionListener(new UpbtnListener());
        up.getDeleteButton().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DltbtnMouseClicked(evt);
            }
        });
    }

    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) up.getDoctorTable().getModel();
    
    // Clear the existing data from the table
    model.setRowCount(0);
    
    // Retrieve new data from your database or wherever it's stored
    List<Object[]> newData = fetchDataFromDatabase();
    
    // Populate the table with the new data
    for (Object[] rowData : newData) {
        model.addRow(rowData);
    }
}

// Method to fetch data from the database, replace it with your actual implementation
    private List<Object[]> fetchDataFromDatabase() {
        List<Object[]> data = new ArrayList<>();
        try (PreparedStatement ps = userdao.getConnection().prepareStatement("SELECT * FROM doctor")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] row = new Object[] {
                        rs.getString("idDoctor"),
                        rs.getString("Name"),
                        rs.getString("Contact"),
                        rs.getString("Faculty"),
                        rs.getString("Gender")
                    };
                    data.add(row);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(up, "Error fetching data from database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
     private class AddButtonListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AddbtnActionPerformed(evt);
        }
    }

  private class UpbtnListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            UpbtnActionPerformed(evt);
        }
    }
  

  
      private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
    String name = up.getDocName().getText().trim();
    String contact = up.getContact().getText().trim();
    String faculty = up.getFaculty().getText().trim();
    String gender = (String) up.getGender().getSelectedItem(); // Assuming GenderC is a JComboBox with gender options
    String id = up.getId().getText().trim();

    
    if (name.isEmpty() || faculty.isEmpty() || contact.isEmpty() || gender == null || id.isEmpty()) {
        JOptionPane.showMessageDialog(up, "All fields must be filled out.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }


    if (contact.length() < 10 || !contact.matches("\\d+")) {
        JOptionPane.showMessageDialog(up, "Contact number must contain at least 10 digits and be numeric.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    DoctorModel u=new DoctorModel( id,name,contact, faculty, gender);
 try {
        if (userdao.userExists(id)) {
            JOptionPane.showMessageDialog(up, "User with ID " + id + " already exists.", "Duplicate ID", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (userdao.contactExists(contact,null)) {
            JOptionPane.showMessageDialog(up, "User with contact number " + contact + " already exists.", "Duplicate Contact", JOptionPane.WARNING_MESSAGE);
            return;
        }
        userdao.addUser(u);
        JOptionPane.showMessageDialog(up,"User added successfully");
         loadTableData();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(up, "Error checking existing user data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        
        up.getDocName().setText("");
     up.getContact().setText("");
     up.getFaculty().setText("");
     up.getId().setText("");
    }                      
    
  private void UpbtnActionPerformed(java.awt.event.ActionEvent evt) {                                      
String name = up.getDocName().getText().trim();
    String contact = up.getContact().getText().trim();
    String faculty = up.getFaculty().getText().trim();
    String gender = (String) up.getGender().getSelectedItem(); // Assuming GenderC is a JComboBox with gender options
    String id = up.getId().getText().trim();
    String originalId = up.getSelectedRowId();

        if (!contact.isEmpty() && (contact.length() < 10 || !contact.matches("\\d+"))) {
            JOptionPane.showMessageDialog(up, "Contact number must contain at least 10 digits and be numeric.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DoctorModel u=new DoctorModel( id,name,contact, faculty, gender);
        String selectedId = up.getSelectedRowId();
         try {
             if (!userdao.userExists(originalId)) {
                JOptionPane.showMessageDialog(up, "User with ID " + id + " does not exist.", "User Not Found", JOptionPane.WARNING_MESSAGE);
                return;
            }
        if (userdao.contactExists(contact,originalId)) {
            JOptionPane.showMessageDialog(up, "User with contact number " + contact + " already exists.", "Duplicate Contact", JOptionPane.WARNING_MESSAGE);
            return;
        }
        userdao.updateUser(u);
        JOptionPane.showMessageDialog(up,"User updated successfully");
         loadTableData();
         }catch (SQLException e) {
        JOptionPane.showMessageDialog(up, "Error checking existing user data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        return;}
      
    up.getDocName().setText("");
     up.getContact().setText("");
     up.getFaculty().setText("");
     up.getId().setText("");
    }     
       
       
       
     private void DltbtnMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
     String id = up.getId().getText().trim(); 

    if (id.isEmpty()) {
        JOptionPane.showMessageDialog(up, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(up, "Are you sure you want to delete this record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            if (userdao.userExists(id)) {
                userdao.deleteUser(id);
                JOptionPane.showMessageDialog(up, "Record deleted successfully!");
                 loadTableData();
               
            } else {
                JOptionPane.showMessageDialog(up, "No record found with the provided ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(up, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     
       up.getDocName().setText("");
     up.getContact().setText("");
     up.getFaculty().setText("");
     up.getId().setText("");
       
}
}

