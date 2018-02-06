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
public class Employee extends Person  {
    private String office;
    private int salary;
    private MyDate hireDate;
    
    public Employee (String name, String address, String email, String phoneNumber,
            String office, int salary, MyDate date)   {
        super(name, address, email ,phoneNumber);
        this.office = office;
        this.salary = salary;
        this.hireDate = date;
    }
    
    // Get office
    public String getOffice(){ return office; }
   
    // Set Office
    public void setOffice(String office){ this.office = office; }
    
    // Get salary
    public int getSalary(){ return salary; }
    
    // Set Salary
    public void setSalary(int salary){ this.salary = salary; }
    
    // Get hireDate
    public MyDate hireDate(){ return hireDate; }
    
    // Set hireDate
    public void setHireDate(MyDate hireDate) { this.hireDate = hireDate;  }
    
    // @Override
    public String toString() {
        return super.toString();
    }
}
