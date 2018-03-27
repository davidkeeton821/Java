package lab3;

/**
 * @author David
 */
public class Date implements Comparable<Date> {
    private Integer day;
    private Integer month;
    private Integer year;
    
    //Default constructor
    public Date(){}
    
    //Full Constructor
    public Date(Integer month, Integer day, Integer year)   {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    //implementation of compareTo for comparing dates to other dates for sorting
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
    
    //validate date entry based on calendar dates
    public boolean validate()   {
        boolean valid = true;
        
        switch(month)   {
            case 1: 
                if(day > 31 || day < 1)
                    valid = false;
                break;
            case 2: 
                if(day > 28 || day < 1)
                    valid = false;
                break;
            case 3:
                if(day > 31 || day < 1)
                    valid = false;
                break;
            case 4:
                if(day > 30 || day < 1)
                    valid = false;
                break;
            case 5:   
                if(day > 31 || day < 1)
                    valid = false;
                break;
            case 6:
                if(day > 30 || day < 1)
                    valid = false;
                break;
            case 7:
                if(day > 31 || day < 1)
                    valid = false;
                break;
            case 8:
                if(day > 31 || day < 1)
                    valid = false;
                break;
            case 9:
                if(day > 30 || day < 1)
                    valid = false;
                break;
            case 10:
                if(day > 31 || day < 1)
                    valid = false;
                break;
            case 11:
                if(day > 30 || day < 1)
                    valid = false;
                break;
            case 12: 
                if(day > 31 || day < 1)
                    valid = false;
                break;
            default: valid = false;    
        }        
        if(year < 1)
            valid = false;
        
        if(!valid)
            System.out.println("Invalid date entry");
        
        return valid;
    }
    
    //output Date
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