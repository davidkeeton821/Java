/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgradebook;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglas.atkinson
 */
public class Student {
    
    private String name;
    private List<Double> grades;
    
    public Student() {
        this("");
    }
    
    public Student(String name) {
        this.name = name;
        grades = new ArrayList<Double>();
    }
    
    public void addGrade(double grade) {
        grades.add(grade);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public int getNumberOfGrades() {
        return grades.size();
    }
    
    public List<Double> getGrades() {
        return new ArrayList<Double>(grades);
    }
    
    public double getAverage() {
        if( grades.isEmpty() )
            return Double.NaN;
        double total = 0.0;
        for(double grade : grades)
            total += grade;
        return total / grades.size();
    }
}
