/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Acer
 */
public class LoginModel {
    private final String email;
    private final String password;
    public LoginModel(String email, String password){
    this.email=email;
    this.password=password;
    }
    public String getEmail(){
    return email;
    }
    public String getPassword(){
    return password;
    }
}
