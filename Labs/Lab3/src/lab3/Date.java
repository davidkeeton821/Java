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
public class Date implements Comparable<Date> {
    private Integer day;
    private Integer month;
    private Integer year;
    
    public Date(){}
    
    public Date(Integer month, Integer day, Integer year)   {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    @Override
    public int compareTo(Date other)   {
        int compare = -1;
        if (getYear() > other.getYear())
            compare = 1;
        if (getYear().equals(other.getYear()) && getMonth() > other.getMonth())
            compare = 1;
        if (getYear().equals(other.getYear()) && getMonth().equals(other.getMonth())
                && getDay() > other.getDay())
            compare = 1;
        if (getYear().equals(other.getYear()) && getMonth().equals(other.getMonth())
                && getDay().equals(other.getDay()))
            compare = 0;       
        return compare;
    }
    
    //Get day
    public Integer getDay() {return day;}
    //Set dat
    public void setDay(Integer day) {this.day = day;}
    
    //Get month
    public Integer getMonth() {return month;}
    //Set month
    public void setMonth(Integer month) {this.month = month;}
    
    //Get year
    public Integer getYear() {return year;}
    //Set year
    public void setYear(Integer year) {this.year = year;}
    
    @Override
    public String toString()   {
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