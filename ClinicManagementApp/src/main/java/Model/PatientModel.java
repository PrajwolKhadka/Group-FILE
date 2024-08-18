/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Acer
 */
public class PatientModel {
    private final String ID;
    private final String Name;
    private final String Contact;
    private final String Age;
    private final String Gender;
    public PatientModel(String ID,String Name,String Contact, String Age, String Gender){
    this.ID=ID;
    this.Name=Name;
    this.Contact=Contact;
    this.Age=Age;
    this.Gender=Gender;
    }
    public String getId(){
    return ID;
    }
    public String getName(){
    return Name;
    }
    public String getContact(){
    return Contact;
    }
    public String getAge(){
    return Age;}
    public String getGender(){
    return Gender;
    }
}
