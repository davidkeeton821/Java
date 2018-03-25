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
        // TODO input from keyboard
        // todo input from save file
        // todo input from keyboard
        // todo input from saved file
        
        //readme file if needed
        //classes: date task todolist

        //List<Task> todo = new ArrayList<>();
        TodoList td = new TodoList();
        int taskNum;
        boolean choice = true;
        Scanner sc = new Scanner(System.in);
        Scanner file = null;
        int menu;
        do  {
            System.out.print(td.toString());
            displayMenu();
            menu = TryParseInt(sc.nextLine());
                           
            switch (menu)   {
                case 1:td.addTask();  
                    break;
                case 2:
                    taskNum =  td.getTaskNum();
                    if(taskNum > 0 && taskNum <= td.getSize())
                        td.editTask(taskNum - 1);
                    if(taskNum > td.getSize() || taskNum < 0)
                        System.out.println("Invalid Entry");
                    break;
                case 3:
                    taskNum = td.getTaskNum();
                    if(taskNum > 0 && taskNum <= td.getSize())
                        td.deleteTask(taskNum - 1);
                    if(taskNum > td.getSize() || taskNum < 0)
                        System.out.println("Invalid Entry");
                    break;
                case 4:
                    //showListByPriority();
                    break;
                case 5:
                    //showListByDueDate();
                    break;
                case 6:
                    //toggleCompletedTasks();
                    break;
                case 7:
                    try {
                        PrintWriter outFile = new PrintWriter(getFileFromUser());
                        td.saveList(outFile);
                    } catch (IOException e)   {
                        System.out.println("Invalid entry");
                    }
                    break;              
                case 8:
                    try   {
                        file = new Scanner(new FileReader(getFileFromUser()));             
                        td.loadList(file);    
                    } catch (IOException e)   {             
                        System.out.println("Invalid entry");
                    }                 
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
        System.out.println("\t6. Filer/Unfilter comlete tasks");
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