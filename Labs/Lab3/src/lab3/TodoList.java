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
public class TodoList {
    //Field Declarations
    private final List<Task> todo;
    private boolean hideCompleted;
    private boolean edit;
    
    //Constructor
    public TodoList( )   {
        todo = new ArrayList<>();
        hideCompleted = false;
        edit = false;
    }
     
    //Getters and Setters
    public boolean getHideCompleted() { return hideCompleted; }
    public void setHideComplete(boolean hideCompleted)    {
        this.hideCompleted = hideCompleted;
    }
    
    //Add task
    public void addTask()   {
        //Add not edit
        edit = false;
        //Create new task to add to list
        Task newTask = new Task();
        
        //Get info from user to set Task fields
        System.out.println("Add new Task");               
        newTask.setName(enterName(edit));            
        newTask.setPriority(enterPriority(edit));  
        newTask.setDate(enterDate(edit));
        newTask.setCompleted(edit);       
        
        //Add task to list and give user confirmation
        todo.add(newTask);
        System.out.println("Task added");
        System.out.println((todo.indexOf(newTask) + 1) + ": " + newTask.toString());
    }
    
    
    public void editTask(int taskNum)   { 
        //if Task number from user is valid begin edit
        if(taskNum > 0)    {  
            //switch task number to 0 initialized for dealing with list
            taskNum -= 1;
            //is an edit
            edit = true;
                       
            System.out.println("Edit Task");  
            //get task user asked for
            Task task = todo.get(taskNum);
        
            //print out current name and get new name from user
            System.out.println("Current name: " + task.getName());
            String newName = enterName(edit);
            //only set name if user did not escape
            if(!newName.isEmpty())          
                task.setName(newName);             
        
            //print out current priority and get new priority from user
            System.out.println("Current priority: " + task.getPriorityWord());
            int newPriority = enterPriority(edit);
            //only set priority if user did not escape
            if(newPriority != 0)
                task.setPriority(newPriority);

            //print out current date and get new date from user
            System.out.print("Current due Date: ");  
            System.out.println(task.getDate().toString());
            Date newDate = enterDate(edit);
            //only set date if user did not escape
            if (newDate.getDay() != 0 && newDate.getMonth() != 0 && newDate.getYear() != 0)
                task.setDate(newDate); 
        
            //print out current completed status and get new completion status
            System.out.print("Current Completion Status: ");
            System.out.println(task.getCompletedWord());
            task.setCompleted(enterCompleted());
        }
    }       
    
    public void deleteTask(int taskNum)   {
        //valid task number
        if(taskNum > 0)   {
            //set taskNum to 0 initialize
            taskNum -= 1;
            //Delete task
            todo.remove(taskNum);
            System.out.println("Task Deleted");
        }
        
    }
    
    public void showListByPriority()   {
        //Sort tasks by comparing priority 
        Collections.sort(todo, new Comparator<Task>()  {
            public int compare(Task one, Task two)   {
                return one.getPriority().compareTo(two.getPriority());
            } 
        });
        //Reverse order so that highest priority is first
        Collections.reverse(todo);
        
        //print out list
        System.out.print(toString());
        System.out.println("Press any key to continue...");
        new Scanner(System.in).nextLine();
    }   

    public void showListByDueDate()   {
        //Sort tasks by comparing Date
        Collections.sort(todo, new Comparator<Task>()  {
            public int compare(Task one, Task two)   {
                return one.getDate().compareTo(two.getDate());
            } 
        });
        
        //print out list
        System.out.print(toString());
        System.out.println("Press any key to continue...");
        new Scanner(System.in).nextLine();
    }
    
    public void toggleCompletedTasks()   {
        Scanner sc = new Scanner(System.in);
        while(true)    {
            //Get input from user and validate
            System.out.print("Show completed tasks?(Y/N) ");
            String str = sc.nextLine();
            if(str.equalsIgnoreCase("y"))  {
                System.out.println("Completed tasks will be shown");
                hideCompleted = false;
                break;
            }
            else if (str.equalsIgnoreCase("n"))   {
                System.out.println("Completed tasks will not be shown");
                hideCompleted = true;
                break;
            }
            else
                System.out.println("Invalid Entry");
        }
    }
    
    public void loadList(String fileName)   {
        //Variable declaration
        Scanner file = null;
        String[] str;
        String name;
        int priority;
        Date date;
        boolean completed = false;
        
        try   {
            file = new Scanner(new FileReader(fileName));        
            while(file.hasNext())   {
                //Split based on commas
                str = file.nextLine().split(",");
                
                //parse out name prority date and completed status
                name = str[0];
                priority = tryParseInt(str[1]);
                String[] loc = str[2].split(" ");
                date = new Date(tryParseInt(loc[0]),tryParseInt(loc[1]),tryParseInt(loc[2]));              
                if(str[3].equalsIgnoreCase("y"))
                    completed = true;
                if(str[3].equalsIgnoreCase("n"))
                    completed = false;
                
                //validate incoming file
                if(name.isEmpty() || priority > 5 || priority < 1 || !date.validate())
                    throw new IOException();
                else {
                    //Create new task
                    Task newTask = new Task(name, priority, date, completed);
                    //Add newTask
                    todo.add(newTask);
                }
            }
            System.out.println("List Loaded");
        } catch(IOException e)   {   
            System.out.println("File not Found or incorrectly formatted");          
        }       
    }
    
    public void saveList(String fileName)
    {
        PrintWriter outFile = null;
        try {            
            //Print fields to fileName
            outFile = new PrintWriter(fileName); 
            for(Integer i = 1; i <= todo.size(); i++)   {
                outFile.print(todo.get(i - 1).getName() + ",");
                outFile.print(todo.get(i - 1).getPriority().toString() + ",");
                outFile.print(todo.get(i - 1).getDate().getMonth().toString() + " ");
                outFile.print(todo.get(i - 1).getDate().getDay().toString() + " ");
                outFile.print(todo.get(i - 1).getDate().getYear().toString() + ",");
                if(todo.get(i - 1).getCompleted())
                    outFile.println("y");
                else
                    outFile.println("n");              
            }
            outFile.close();                 
        } catch (IOException e)   {        
        }
    }
    
    public int getTaskNum()   {
        Scanner sc = new Scanner (System.in);
        int taskNum;
        
        if(todo.isEmpty())   {
            System.out.println("No tasks in list currently");
            return -1;
        }
        while(true)   {
        //print list and get task number from user
        System.out.print(toString());
        System.out.print("Enter task number or 0 to return to main menu: ");
        taskNum = tryParseInt(sc.nextLine());   
            if(taskNum >= 0 && taskNum <= todo.size())
                return taskNum;
            if(taskNum > todo.size() || taskNum < 0)
                System.out.println("Invalid Entry");   
        }        
    }
        
    @Override
    public String toString()   {
        
        String str = "";
        //output based on whether or not completed tasks or hidden
        for(Integer i = 1; i <= todo.size(); i++)   {
            if(hideCompleted && !todo.get(i - 1).getCompleted())
                str += i.toString() + ": " + todo.get(i-1).toString() + "\n";
            
            if(!hideCompleted)
                str += i.toString() + ": " + todo.get(i-1).toString() + "\n";
        }            
        return str;
    }
    
    private String enterName(boolean edit)   {
        String name;
        Scanner sc = new Scanner(System.in);
        //get name from user
        while (true)   {
            if(edit)   {            
                System.out.print("Enter new text (Enter only to keep current): ");
            }else   {
                System.out.print("Name of Task: ");  
            }
            name = sc.nextLine();
            //escape if a name was given or if editing, empty is valid to escape
            if(!name.isEmpty() || edit)               
                return name;
            else
                System.out.println("Name Required");
        }
    }
    
    private int enterPriority(boolean edit)   {
        int priority;
        Scanner sc = new Scanner(System.in);
        //get Priority from user
        while(true)   {
            if (edit)   {
                System.out.print("Enter a new priority of task (1-Low, 2-Moderate, 3-High, 4-Urgent, 0- No Change: ");
            } else
            {
                System.out.print("Enter priority of task (1-Low, 2- Moderate, 3- High, 4- Urgent): ");
            }
            priority = tryParseInt(sc.nextLine());
            //escape if a valid priority was given, 0 is valid for edit
            if(edit && priority == 0)
                return priority;
            if(priority > 0 && priority < 5)
                return priority;
            
            System.out.println("Invalid entry, please try again");
        }
    }
    
    private Date enterDate (boolean edit)   {
        Date date = new Date();
        Scanner sc = new Scanner(System.in);
        //get Date from user
        while(true)   {
            if (edit)   {
                System.out.print("Enter new month dat year of due date as integers i.e. (1 1 2017) or  0 0 0 "
                   + "for no change: " );
            } else   {
               System.out.print("Enter Month Day Year of due date as integers: "); 
            }           
            String[] loc = sc.nextLine().split(" ");
            //test for too many inputs
            if(loc.length > 3)
                //if invalid, set first value to invalid to fail try
                loc[0] = "-1";
            //try parsing date entry from user
            try   {
                date.setMonth(tryParseInt(loc[0])); 
                date.setDay(tryParseInt(loc[1]));   
                date.setYear(tryParseInt(loc[2]));           
            
                //0 0 0 is valid exit entry
                if(edit && date.getMonth() == 0 && date.getDay() == 0 && date.getYear() == 0)   {                  
                    return date;
                }   
                //validate date if Date class, return if valid
                if(date.validate())   {                
                    return date;
                }
            } catch(ArrayIndexOutOfBoundsException e)   {
                System.out.println("Invalid date entry, try again");
            }           
        }    
    }      
   
    private boolean enterCompleted()   {
        String answer;
        Scanner sc = new Scanner(System.in);
        //get and validate answer from user
        while(true)   {
            System.out.print("Is this task completed(Y/N)? ");
            answer = sc.nextLine();
            if(answer.equalsIgnoreCase("Y"))
                return true;
            if(answer.equalsIgnoreCase("N"))
                return false;
            System.out.println("Invalid entry, please try again");
        }
    }         
    // parse string and return negative value if parse failed
    private int tryParseInt(String str)   {
        try{       
            return Integer.parseInt(str);
        } catch (NumberFormatException e)   {
            return -1;                   
        }
    }    
}