/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author David
 */
public class Date {
    private int day;
    private int month;
    private int year;
    
    public Date() {}
    
    public Date(int month, int day, int year)   {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    //Get day
    public int getDay() {return day;}
    //Set dat
    public void setDay(int day) {this.day = day;}
    
    //Get month
    public int getMonth() {return month;}
    //Set month
    public void setMonth(int month) {this.month = month;}
    
    //Get year
    public int getYear() {return year;}
    //Set year
    public void setYear(int year) {this.year = year;}
    
    public String toString()   {
        Integer day = this.day;
        Integer month = this.month;
        Integer year = this.year;
        
        String monthString = "";
        
          switch(month)   {
            case 1: monthString = "January";
                break;
            case 2: monthString = "February";
                break;
            case 3: monthString = "March";
                break;
            case 4: monthString = "April";
                break;
            case 5: monthString = "May";
                break;            
            case 6: monthString = "June";
                break;
            case 7: monthString = "July";
                break;
            case 8: monthString = "August";
                break;
            case 9: monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default: break;
        }      
        
        return monthString + " " + day.toString() + " " + year.toString();
    }
}
