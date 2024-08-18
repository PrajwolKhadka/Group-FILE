/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Acer
 */
public class DoctorModel {
        private final String ID;
    private final String Name;
    private final String Contact;
    private final String Faculty;
    private final String Gender;
    public DoctorModel(String ID,String Name,String Contact, String Faculty, String Gender){
    this.ID=ID;
    this.Name=Name;
    this.Contact=Contact;
    this.Faculty=Faculty;
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
    public String getFaculty(){
    return Faculty;}
    public String getGender(){
    return Gender;
    }
}
