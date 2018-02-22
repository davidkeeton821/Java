/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingassignment2;
import java.util.*;
import java.io.*;
/**
 *
 * @author david.keeton821
 */
public class ProgrammingAssignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //create scanner for reading in file info
        File file = new File ("tower_input.txt");
        try {
            Scanner sc = new Scanner(file);
            int testCases = sc.nextInt();
            int numOfTowers = sc.nextInt();                
            int count = 1;
            
            //create array of tower heights
            
            while (sc.hasNextLine())   {

                System.out.println("Case" + count++);
                //create compare container
                while ()   {
                    //find range for each tower using its height
                    Integer temp;  //only needed to get tower heights from container to container
                    int range = 1; //starts at one for default, increments if tower is taller
                    if (true)//tower is first tower to compare
                        System.out.print(range + " ");
                    else   {
                        //temp = heightStack.pop(); //tower moves to a point where it can be compared
                        //output ranges of each tower in reasonable way
                        System.out.println(range);
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
  
        
        
    }
}
