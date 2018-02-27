/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightsteps;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
/**
 *
 * @author david.keeton821
 */
public class KnightSteps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in= null;
        try {
            in = new Scanner(new FileReader("knightsteps_input.txt"));
        }
        catch (IOException e)   {
            e.printStackTrace();
        }
        
        //get the number of cases
        int numCases = Integer.parseInt((in.nextLine()));
        
        //loop through and read the file
        // call search on each iteration through the loop
        for(int i = 0; i < numCases; i++)   {
            // Get the board size
            int n = Integer.parseInt(in.nextLine());
            
            //get the starting location
            String[] loc = in.nextLine().split(" ");
            int sRow = Integer.parseInt(loc[0]);
            int sCol = Integer.parseInt(loc[1]);
            
            //get ending location
            loc = in.nextLine().split(" ");
            int tRow = Integer.parseInt(loc[0]);
            int tCol = Integer.parseInt(loc[1]);
            
            //call and print out the results of search
            System.out.println(search(n,sRow, sCol, tRow, tCol));
        }
    }
    
    static int search(int n, int startX, int startY, int endX, int endY)   {
        return minStepToReachTarget(new int[] {startX, startY},
                                    new int[] {endX, endY}, n);
    }
    
    static boolean isInBoard (int x, int y, int n)   {
        return (x >= 0 && x <= n - 1 && y >= 0 && y <= n - 1);
    
    }
    
    static int minStepToReachTarget (int [] knightPos, int[] targetPos, int n)   {
        // two arrays of possible directions
        int [] dx = {-2, -1,  1,  2,-2,-1, 1, 2};
        int [] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
        
        // queue to store the kinght board states
        Queue<Cell> q = new LinkedList<>();
        
        q.offer(new Cell(knightPos[0], knightPos[1], 0));
        
        Cell t;    // temporary cell to look at
        int x,y;   // row and col values
        
        // create a 2D array of boolean to mark visited cells
        boolean [][] visited = new boolean [n][n];
        
        //set the initial cell to visited
        //visited[knightPos[0]] [knightPos[1]] = true;
        
        while(!q.isEmpty())   {
            //get element at front of q
            t = q.poll();
            
            //mark cell as visited
            visited[t.getX()][t.getY()] = true;
            
            //check if this is the goal
            if(t.getX() == targetPos[0] && t.getY() == targetPos[1])  {
                return t.getDist();
            }
            
            //Expand t's children and add to queue if not visted
            for (int i = 0; i < 8; i++)   {
                //get the new x and y
                x = t.getX() + dx[i];
                y = t.getY() + dy[i];
                
                // if (x,y) is in the board and not visited
                //add to the queue
                
                if(isInBoard(x,y,n) && !visited[x][y])   {
                    q.offer (new Cell (x,y,t.getDist() + 1));
                }
            }  
        }
        
        return -1;
    }
}
