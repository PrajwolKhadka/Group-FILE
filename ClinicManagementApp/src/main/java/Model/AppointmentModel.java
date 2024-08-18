/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Acer
 */
public class AppointmentModel {
        private final String ID;
    private final String PName;
    private final String DName;
    private final String Date;
    private final String Price;
    public AppointmentModel(String ID,String PName,String DName, String Date, String Price){
    this.ID=ID;
    this.PName=PName;
    this.DName=DName;
    this.Date=Date;
    this.Price=Price;
    }
    public String getId(){
    return ID;
    }
    public String getPName(){
    return PName;
    }
    public String getDName(){
    return DName;
    }
    public String getDate(){
    return Date;}
    public String getPrice(){
    return Price;
    }
}
