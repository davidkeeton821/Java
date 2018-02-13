/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradebook;

import java.util.Scanner;

/**
 *
 * @author douglas.atkinson
 */
public class GradeBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int numStudents = 0;
        double[] averages;
        
        System.out.print("How many students are there? ");
        numStudents = in.nextInt();
        averages = new double[numStudents];
        
        for(int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter grades for student #" + (i + 1));
            int count = 0;
            double totalPoints = 0.0;
            System.out.print("Enter grade #" + (count + 1) + " (a negative to quit): ");
            double grade = in.nextDouble();
            while(grade >= 0.0) {
                totalPoints += grade;
                count++;
                System.out.print("Enter grade #" + (count + 1) + " (a negative to quit): ");
                grade = in.nextDouble();
            }
            if(count > 0)
                averages[i] = totalPoints / count;
            else
                averages[i] = Double.NaN;
        }
        
        System.out.println("\nAverages are:");
        for(double grade : averages) {
            System.out.println(grade);
        }
    }
    
}
