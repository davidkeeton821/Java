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
public class Task {
    private String name;
    private Integer priority;
    private Date date;
    private boolean completed;
    
    //Default Constructor
    public Task(){}      
    
    //Full Constructor
    public Task(String name, Integer priority, Date date, boolean completed)   {
        this.name = name;
        this.priority = priority;
        this.date = date;
        this.completed = completed;
    }
    
    //Get name
    public String getName(){return name;}
    //Set name
    public void setName(String name){this.name = name;}
    
    //Get priority
    public Integer getPriority(){return priority;}
    public String getPriorityWord() {return wordPriority(getPriority());}
    //Set Priority
    public void setPriority(Integer priority){this.priority = priority;}
    
    //Get date
    public Date getDate() { return date; }
    //Set date
    public void setDate(Date date) { this.date = date; }
    
    //Get completed
    public boolean getCompleted() { return completed; }
    public String getCompletedWord() {return wordCompleted(getCompleted());}
    //set Completed
    public void setCompleted(boolean completed) {this.completed = completed;}
    
    //convert number priority to string representation
    private String wordPriority(Integer priority)   {
        switch(priority)   {
            case 1: return "Low";
            case 2: return "Moderate";
            case 3: return "High";
            case 4: return "Urgent";
            default: return "";
        }
    } 
    
    //covert completed to string representation
    private String wordCompleted(boolean completed)   {
        if(completed)
            return "Completed";
        else
            return "Not Completed";
    }
    
    //output Task
    @Override
    public String toString()   {
        
        return this.getName() + " | " + this.getPriorityWord() + " | " + this.getDate().toString()
                + " | " + this.wordCompleted(getCompleted());
    }
}