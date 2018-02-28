/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;
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
        
        //create scanner for reading in file info
        Scanner sc = null;
        try{
            sc = new Scanner (new FileReader("tower_input.txt"));
        }
        catch (IOException e){
            e.printStackTrace();
        }            
        
        int numOfCases = Integer.parseInt(sc.nextLine());                
        for (int i = 0; i < numOfCases; i++)   {    
            //create variables for this case
            int numOfTowers = Integer.parseInt(sc.nextLine());
            ArrayList<Integer> towerHeights = new ArrayList<>(numOfTowers);

            //read in tower heights to array
            String[] loc = sc.nextLine().split(" "); 
            for (int j = 0; j < numOfTowers; j++)  {
                towerHeights.add(Integer.parseInt(loc[j]));  
            } 
            
            System.out.println("Case:" + (i + 1));
            
            //create stack for tower comparison
            Stack<Integer> stack = new Stack();
            //1 initialized due range min value as 1
            for (int j = 1; j <= towerHeights.size(); j++)   {                
                //not first element, pop off all elements smaller than current element
                while(!stack.isEmpty() && towerHeights.get(j -1) > towerHeights.get(stack.peek() -1))   {
                        stack.pop();
                }                    
                //[j] is taller than all current towers
                if (stack.isEmpty())   {
                    //range is full value of array up to this point
                    System.out.print ((j) + " ");
                }      
                //taller tower has been found
                else   {
                    //range = [current place] - [taller tower]
                    System.out.print ((j - stack.peek()) + " ");
                }
                //add to stack for comparison
                stack.push(j);                 
            } 
            System.out.println();
        }
    }
}

