/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
//import jsjf.*;
import java.util.*;
import jsjf.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

/**
 *
 * @author David
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AVLBinarySearchTree<WordData> bst = new AVLBinarySearchTree();
        Scanner sc = null;
        try
        {
            sc = new Scanner(new File("GulliversTravelsExcerpt.txt"));
        }
        catch (Exception e)
        {
              e.printStackTrace();
        }       

        int lineNum = 1;
        while(sc.hasNext())
        {          
            String token = sc.nextLine();           
            token = trimString(token);                                
                        
            Scanner lineReader = new Scanner(token);
            String word = null;           
            
            while(lineReader.hasNext())   {
                word = lineReader.next();
                WordData wd = new WordData(word, lineNum);
                
                if(!bst.contains(wd))   {
                    bst.addElement(wd);
                }
                else   {                  
                    bst.findNode(wd).getElement().addToList(lineNum);
                }
            }    
            lineNum++;
        }              
        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter("index.txt");
            
            for(WordData word : bst)   {
                outFile.println(word.toString());
            }
            outFile.close();
        }
        catch (IOException e)   {
            e.printStackTrace();
        }
    }
        
    public static String trimString(String token)
    {      
        token= token.toLowerCase();
        Pattern p = Pattern.compile("[^a-z ]");
        Matcher m = p.matcher(token);
        if(m.find())   {
            token = m.replaceAll("");         
            return token;
        }      
        return token;
    }
}