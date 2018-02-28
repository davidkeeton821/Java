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
            
            // try: j = 1, allow whole stack to pop, do not save [0]
            for (int j = 0; j < towerHeights.size(); j++)   {             
                if(!stack.isEmpty())   {   
                    //not first element, pop off all element values smaller than current element except [0]
                    while(towerHeights.get(j) > towerHeights.get(stack.peek()) && stack.peek() != 0)   {
                            stack.pop();
                    } 
                    //if all other elements except [0] were popped, and [0] is smaller, [j] is now the tallest tower
                    //keep [0] element in case another taller tower appears later
                    if (stack.peek() == 0 && towerHeights.get(j) > towerHeights.get(stack.peek()))   {
                        // range in this case is the full length of the array of to this point
                        System.out.print ((j + 1) + " ");
                    }      
                    else   {
                        //otherwise a taller tower has been found, range = [current place] - [taller tower]
                        System.out.print ((j - stack.peek()) + " ");
                    }
                    //add to stack for comparison
                    stack.push(j);
                } else
                {
                    //stack is empty, first elements range is always one, store it on stack
                    System.out.print(1 + " ");
                    stack.push(j);
                }                   
            } 
            System.out.println();
        }
    }
}

