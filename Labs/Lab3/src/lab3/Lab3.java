/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;
import java.util.*;
import java.io.*;
/**
 *
 * @author David
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Declare TodoListClass
        TodoList td = new TodoList();
        
        //Main menu variable declarations
        boolean choice = true;
        Scanner sc = new Scanner(System.in);
        int menu;
        
        do  {
            displayMenu();
            menu = TryParseInt(sc.nextLine());
                           
            switch (menu)   {
                case 1:td.addTask();  
                    break;
                case 2:
                    td.editTask(td.getTaskNum());                  
                    break;
                case 3:
                    td.deleteTask(td.getTaskNum());
                    break;
                case 4:
                    td.showListByPriority();
                    break;
                case 5:
                    td.showListByDueDate();
                    break;
                case 6:
                    td.toggleCompletedTasks();
                    break;
                case 7:                   
                    td.saveList(getFileFromUser());
                    break;              
                case 8:                               
                    td.loadList(getFileFromUser());                                      
                    break;
                case 9:
                    choice = false;
                    break;
                default: 
                    System.out.println("Error: not a valid selection");
                    break;     
            }       
        } while (choice);
    }
    
    public static String getFileFromUser()  {
        String file = "";
        Scanner sc = new Scanner(System.in);    
        System.out.println("Input name of text file (no file extension): ");
        file = sc.nextLine() + ".txt";      
        return file;      
    }
    
    public static void displayMenu()    {
        System.out.println("--- TO DO LIST MENU ---");
        System.out.println("\t1. Add a new task");
        System.out.println("\t2. Modify a task");
        System.out.println("\t3. Remove a task");
        System.out.println("\t4. Display tasks by priority");
        System.out.println("\t5. Display tasks by due date");
        System.out.println("\t6. Filter/Unfilter complete tasks");
        System.out.println("\t7. Save To Do List");
        System.out.println("\t8. Load To Do List");
        System.out.println("\t9. Quit");
        System.out.print("Enter option (1-9): ");
    }    
    
    public static int TryParseInt(String str)   {
        try{
            int num = Integer.parseInt(str);
            return num;
        } catch (NumberFormatException e)   {
            return -1;                   
        }
    }  
}