/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AppointmentDAO;
import DAO.DoctorDAO;
import Model.AppointmentModel;
import Model.Database;
import Model.DoctorModel;
import View.Appointment;
import View.Doctor;
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
public class AppointmentController {
       private final Appointment up;
    private final AppointmentDAO userdao;
    
     public AppointmentController(Appointment up) {
        this.up = up;
        Connection conn = null;
        try {
            conn = Database.getConnection();
            this.userdao= new AppointmentDAO(conn);
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
        DefaultTableModel model = (DefaultTableModel) up.getTable().getModel();
    
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
        try (PreparedStatement ps = userdao.getConnection().prepareStatement("SELECT * FROM appointment")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] row = new Object[] {
                        rs.getString("idappointment"),
                        rs.getString("patientName"),
                        rs.getString("doctorName"),
                        rs.getString("date"),
                        rs.getString("price")
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
    String name = up.getPatientNameField().getText().trim();
    String dname = up.getDoctorNameField().getText().trim();
    String date = up.getDateField().getText().trim();
    String price = up.getPriceField().getText().trim();
    String id = up.getIdField().getText().trim();

    
    if (name.isEmpty() || dname.isEmpty() || date.isEmpty() || price == null || id.isEmpty()) {
        JOptionPane.showMessageDialog(up, "All fields must be filled out.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    AppointmentModel u=new AppointmentModel( id,name,dname, date, price);
 try {
        if (userdao.userExists(id)) {
            JOptionPane.showMessageDialog(up, "User with ID " + id + " already exists.", "Duplicate ID", JOptionPane.WARNING_MESSAGE);
            return;
        }
        userdao.addUser(u);
        JOptionPane.showMessageDialog(up,"User added successfully");
         loadTableData();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(up, "Error checking existing user data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        
        up.getIdField().setText("");
     up.getPatientNameField().setText("");
     up.getDoctorNameField().setText("");
     up.getDateField().setText("");
     up.getPriceField().setText("");
    }                      
    
  private void UpbtnActionPerformed(java.awt.event.ActionEvent evt) {                                      
     String name = up.getPatientNameField().getText().trim();
    String dname = up.getDoctorNameField().getText().trim();
    String date = up.getDateField().getText().trim();
    String price = up.getPriceField().getText().trim();
    String id = up.getIdField().getText().trim();
    String originalId = up.getSelectedRowId();

        AppointmentModel u=new AppointmentModel( id,name,dname, date, price);
        String selectedId = up.getSelectedRowId();
         try {
             if (!userdao.userExists(originalId)) {
                JOptionPane.showMessageDialog(up, "User with ID " + id + " does not exist.", "User Not Found", JOptionPane.WARNING_MESSAGE);
                return;
            }
        userdao.updateUser(u);
        JOptionPane.showMessageDialog(up,"User updated successfully");
         loadTableData();
         }catch (SQLException e) {
        JOptionPane.showMessageDialog(up, "Error checking existing user data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        return;}
      
    up.getIdField().setText("");
     up.getPatientNameField().setText("");
     up.getDoctorNameField().setText("");
     up.getDateField().setText("");
     up.getPriceField().setText("");
    }     
       
       
       
     private void DltbtnMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
     String id = up.getIdField().getText().trim(); 

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
     
     
     up.getIdField().setText("");
     up.getPatientNameField().setText("");
     up.getDoctorNameField().setText("");
     up.getDateField().setText("");
     up.getPriceField().setText("");
       
}
}
