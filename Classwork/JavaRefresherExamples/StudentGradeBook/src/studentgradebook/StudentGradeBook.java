/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgradebook;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author douglas.atkinson
 */
public class StudentGradeBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Student 1");
        Student stud1 = new Student("Arthur Dent");
        correctlyMakeStudent(stud1);
        displayStudent(stud1);
        
        System.out.println("\nStudent 2");
        Student stud2 = new Student("Ford Prefect");
        incorrectlyMakeStudent(stud2);
        displayStudent(stud2);
                        
    }
    
    public static void correctlyMakeStudent(Student s) {
        Scanner in = new Scanner(System.in);
        
        if(s.getName().isEmpty()) {
            System.out.print("Enter the name of the student: ");
            s.setName(in.nextLine());
        }
                    
        System.out.println("Enter grades for " + s.getName());
        System.out.print("Grade " + (s.getNumberOfGrades() + 1) + ": ");
        double grade = in.nextDouble();
        while(grade >= 0.0) {
            s.addGrade(grade);
            System.out.print("Grade " + (s.getNumberOfGrades() + 1) + ": ");
            grade = in.nextDouble();
        }
                
        //in.close();
    }
    
    public static void incorrectlyMakeStudent(Student s) {
        s = new Student();
        Scanner in = new Scanner(System.in);
        if(s.getName().isEmpty()) {
            System.out.print("Enter the name of the student: ");
            s.setName(in.nextLine());
        }
                    
        System.out.println("Enter grades for " + s.getName());
        System.out.print("Grade " + (s.getNumberOfGrades() + 1) + ": ");
        double grade = in.nextDouble();
        while(grade >= 0.0) {
            s.addGrade(grade);
            System.out.print("Grade " + (s.getNumberOfGrades() + 1) + ": ");
            grade = in.nextDouble();
        }
                
        //in.close();
    }
    
    public static void displayStudent(Student s) {
        System.out.println("\n==============================");
        System.out.println("Name: " + s.getName());
        
        System.out.println("\nGrades:");
        for(double grade : s.getGrades()) {
            System.out.println(grade);
        }
        
        System.out.println("\nAverage: " + s.getAverage());
        System.out.println("==============================");
    }
    
}
