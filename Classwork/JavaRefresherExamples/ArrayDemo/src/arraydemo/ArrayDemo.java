/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraydemo;

import java.util.Scanner;

/**
 *
 * @author douglas.atkinson
 */
public class ArrayDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("What size array? ");
        int size = in.nextInt();
        
        String[] names = new String[size];
        
        for(int i = 0; i < size; i++) {
            System.out.print("Enter name # " + (i + 1) + ": ");
            names[i] = in.next();
        }
        
        String allNames = "";
        for(int i = 0; i < size; i++) {
            allNames += names[i] + " ";
        }
        
        System.out.println("\nOne long string:\n" + allNames);
        
        System.out.println();
        double[][] totals = new double[size][];
        for(int i = 0; i < size; i++) {
            System.out.print("Number of totals for total #" + i + ": ");
            int num = in.nextInt();
            totals[i] = new double[num];
            for(int j = 0; j < num; j++) {
                totals[i][j] = j;
            }
        }
        
        System.out.println("\nSize of array totals is " + totals.length);
        for(int i = 0; i < size; i++) {
            System.out.println("Size of array #" + i + " in totals array is " + totals[i].length);         
        }
        
        System.out.println();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < totals[i].length; j++) {
                System.out.print(totals[i][j] + " ");
            }
            System.out.println();
        }                
    }    
}
