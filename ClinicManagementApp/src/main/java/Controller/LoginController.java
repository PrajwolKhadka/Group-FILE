/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Acer
 */
package Controller;

import View.LoginPage;
import View.Patient; // Replace with the actual next page
import javax.swing.JOptionPane;

public class LoginController {

    private LoginPage loginPage;

    public LoginController(LoginPage loginPage) {
        this.loginPage = loginPage;
        loginPage.getLogin().addActionListener(e -> login());
    }

    private void login() {
        String username = loginPage.getUsername().getText();
        String password = new String(loginPage.getPass().getPassword());

        if (username.equals("AdminAdmin") && password.equals("AdminAdmin")) {
            loginPage.dispose();
            new Patient().setVisible(true); // Replace with the actual next page
        } else {
            // Handle incorrect credentials, e.g., show an error message
            JOptionPane.showMessageDialog(null, "Error: Incorrect username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
