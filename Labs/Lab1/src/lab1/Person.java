/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import util.MyDate;
/**
 *
 * @author david.keeton821
 */
public class Person{
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
        
    // Overloaded contructor
    public Person(String name, String address,String email,  
            String phoneNumber){
        this.name = name;
        this.address = address;             
        this.email = email;
        this.phoneNumber = phoneNumber;
    }        
    // Default Constructor
    public Person(){           
        }      
        
    // Get Name
    public String getName(){ return name; }
        
    // Set Name
    public void setName(String name){ this.name = name; }
    
    // Get Address
    public String getAddress(){ return address; }
        
    // Set Address
    public void setAddress(String adress){ this.name = adress; }
        
    // Get Phone Number
    public String getPhone(){ return phoneNumber; }
        
    //Set Phone Number
    public void setPhone(String phone){ this.phoneNumber = phone; }
        
    // Get Email
    public String getEmail(){ return email; }
        
    // Set Email
    public void setEmail(String email){ this.email = email; }
        
    // @Override
    public String toString() {
        return getClass().getCanonicalName() + " " + name;
    }     
}
    // class Employee extends Person
    // Attributes: Office, Salary, Date Hired


class Student extends Person  {
    private String classification;
    
    public Student (String name, String address, String email, String phoneNumber,
            String status){
        super(name, address, email, phoneNumber);
        this.classification = classification;
    }
    
    // Get status
    public String getStatus() { return classification; }
    
    // Set status
    public void setStatus(String status){ this.classification = status; }
    
    // @Override
    public String toString() {
        return super.toString();
    }
}

class Faculty extends Employee  {
    private String officeHours;
    private String rank;
    
    public Faculty (String name, String address, String email, String phoneNumber,
        String office, String salary, MyDate date, String officeHours, String rank){
        
        super(name, address, email, phoneNumber, office, salary, date);
        this.officeHours = officeHours;
        this.rank = rank;
    }
    
    // Get office hours
    public String getOfficeHours() { return officeHours; }
    
    // Set office hours
    public void setOfficeHours(String officeHours){ this.officeHours = officeHours; }
    
    // Get rank
    public String getRank() { return rank; }
    
    // Set rank
    public void setRank(String rank){ this.rank = rank; }
    
    // @Override
    public String toString() {
        return super.toString() + " ";
    }
}


class Staff extends Employee  {
    private String titles;
    
    public Staff (String name, String address, String email, String phoneNumber,
        String office, String salary, MyDate date, String titles){
        
        super(name, address, email, phoneNumber, office, salary, date);
           this.titles = titles;
    }
    
    // Get titles
    public String getTitles() { return titles; }
    
    // Set titles
    public void setTitles(String titles){ this.titles = titles; }
    
    // @Override
    public String toString() {
        return super.toString() + " " + titles;
    }
}

