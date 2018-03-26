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
        //readme file if needed
        //Figure out sorting issues
        //move validation for gettasknumber from lab3 to method in todolist

        TodoList td = new TodoList();
        int taskNum;
        boolean hideCompleted = false;
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
                    taskNum =  td.getTaskNum(hideCompleted);
                    if(taskNum > 0 && taskNum <= td.getSize())
                        td.editTask(taskNum - 1);
                    if(taskNum > td.getSize() || taskNum < 0)
                        System.out.println("Invalid Entry");
                    break;
                case 3:
                    taskNum = td.getTaskNum(hideCompleted);
                    if(taskNum > 0 && taskNum <= td.getSize())
                        td.deleteTask(taskNum - 1);
                    if(taskNum > td.getSize() || taskNum < 0)
                        System.out.println("Invalid Entry");
                    break;
                case 4:
                    td.showListByPriority(hideCompleted);
                    break;
                case 5:
                    td.showListByDueDate(hideCompleted);
                    break;
                case 6:
                    hideCompleted = td.toggleCompletedTasks();
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
        System.out.println("\t6. Filter/Unfilter comlpete tasks");
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