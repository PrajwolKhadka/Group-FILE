/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author Acer
 */
public class Patient extends javax.swing.JFrame {

    /**
     * Creates new form Patient
     */
    public Patient() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PatientTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Name = new javax.swing.JTextField();
        Contact = new javax.swing.JTextField();
        Age = new javax.swing.JTextField();
        Id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        Delete = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        doctors = new javax.swing.JLabel();
        appointment = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Calisto MT", 1, 24)); // NOI18N
        jLabel5.setText("ID :");

        PatientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Contact", "Age", "Gender"
            }
        ));
        jScrollPane1.setViewportView(PatientTable);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, 220, 30));
        jPanel1.add(Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 220, 30));
        jPanel1.add(Age, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, 220, 30));
        jPanel1.add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 220, 30));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Gender");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 110, 30));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 50, 30));

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 90, 30));

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Contact");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 110, 30));

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Age");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 130, 60, 30));

        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female"}));
        jPanel1.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, -1));

        Delete.setText("Delete");
        jPanel1.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 460, 130, 40));

        Update.setText("Update");
        jPanel1.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 380, 130, 40));

        Add.setText("Add");
        jPanel1.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 300, 130, 40));

        doctors.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        doctors.setText("Doctors");
        doctors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doctorsMouseClicked(evt);
            }
        });
        jPanel1.add(doctors, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 110, 40));

        appointment.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        appointment.setText("Appointment");
        appointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentMouseClicked(evt);
            }
        });
        jPanel1.add(appointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 110, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Contact", "Age", "Gender"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 500, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Documents\\Clinic\\ClinicManagementApp\\src\\main\\java\\Resources\\patient.jpg")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void appointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentMouseClicked
        // TODO add your handling code here:
        Appointment appointment = new Appointment();
        appointment.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_appointmentMouseClicked

    private void doctorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorsMouseClicked
        // TODO add your handling code here:
        Doctor dr=new Doctor();
        dr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_doctorsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Contact;
    private javax.swing.JButton Delete;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField Name;
    private javax.swing.JTable PatientTable;
    private javax.swing.JButton Update;
    private javax.swing.JLabel appointment;
    private javax.swing.JLabel doctors;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
