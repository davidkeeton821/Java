/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversestring;
import jsjf.ArrayStack;
import jsjf.exceptions.EmptyCollectionException;
import java.util.Scanner;
       
        
/**
 *
 * @author david.keeton821
 */
public class ReverseString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = in.nextLine();
        Scanner parser = new Scanner(sentence);
        String token;
        
        while(parser.hasNext())
        {
            token = parser.next();
            stack.push(token);
        }
        
        System.out.println("In reverse order: ");
        try   {
            while(!stack.isEmpty())   {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
        catch(EmptyCollectionException e)   {
            System.out.println("I don't know how you got here");
        }
        catch (Exception e)    {
            e.printStackTrace();
        }
    }
    
}
