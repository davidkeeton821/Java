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
        Stack<Integer> stackTallest = new Stack();
        
        for (int i = 0; i < numOfCases; i++)   {                   
            ArrayList<Integer> towerHeights = new ArrayList<>(Integer.parseInt(sc.nextLine()));
            System.out.print("Case:" + i);
            for (i = 0; i < towerHeights.size(); i++)  {
                int range = 1;
                towerHeights.add(Integer.parseInt(sc.next()));
                
                if(i == 0)   {
                    System.out.print(range + " ");
                    stackTallest.push(towerHeights.indexOf(i));
                }
                else{
                    while(towerHeights.indexOf(i) > stackTallest.peek())   {
                        range++;
                        stackTallest.pop();
                    }
                    System.out.print(range + " ");
                    stackTallest.push(towerHeights.indexOf(i));
               }            
            }    
        }
    }
}

