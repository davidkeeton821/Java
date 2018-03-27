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
    private final List<Task> todo;
    private boolean hideCompleted;
    
    public TodoList( )   {
        todo = new ArrayList<>();
        hideCompleted = false;
    }
     
    public boolean getHideCompleted() { return hideCompleted; }
    public void setHideComplete(boolean hideCompleted)    {
        this.hideCompleted = hideCompleted;
    }
    
    public void addTask()   {
        Task newTask = new Task();
        
        System.out.println("Add new Task");               
        newTask.setName(enterName(false));            
        newTask.setPriority(enterPriority(false));  
        newTask.setDate(enterDate(false));
        newTask.setCompleted(false);       
        
        todo.add(newTask);
        if(!todo.isEmpty())
            System.out.println("Task added");
        System.out.println((todo.indexOf(newTask) + 1) + ": " + newTask.toString());
    }
    
    public void editTask(int taskNum)   { 
        if(taskNum > 0)    {            
            System.out.println("Edit Task");  
            Task task = todo.get(taskNum);
        
            System.out.println("Current name: " + task.getName());
            String newName = enterName(true);
            if(!newName.isEmpty())
                task.setName(newName);             
        
            System.out.println("Current priority: " + task.getPriorityWord());
            int newPriority = enterPriority(true);
            if(newPriority != 0)
                task.setPriority(newPriority);

            System.out.print("Current due Date: ");  
            System.out.println(task.getDate().toString());
            Date newDate = enterDate(true);
            if (newDate.getDay() != 0 && newDate.getMonth() != 0 && newDate.getYear() != 0)
                task.setDate(newDate); 
        
            System.out.print("Current Completion Status: ");
            System.out.println(task.getCompletedWord());
            task.setCompleted(enterCompleted());
        }
    }       
    
    public void deleteTask(int taskNum)   {
        if(taskNum > 0)   {
            todo.remove(taskNum);
            System.out.println("Task Deleted");
        }
    }
    
    public void showListByPriority()   {
        Collections.sort(todo, new Comparator<Task>()  {
            public int compare(Task one, Task two)   {
                return one.getPriority().compareTo(two.getPriority());
            } 
        });
        Collections.reverse(todo);
        
        System.out.print(toString());
        System.out.println("Press any key to continue...");
        new Scanner(System.in).nextLine();
    }   

    public void showListByDueDate()   {
        Collections.sort(todo, new Comparator<Task>()  {
            public int compare(Task one, Task two)   {
                return one.getDate().compareTo(two.getDate());
            } 
        });
        
        System.out.print(toString());
        System.out.println("Press any key to continue...");
        new Scanner(System.in).nextLine();
    }
    
    public void toggleCompletedTasks()   {
        Scanner sc = new Scanner(System.in);
        while(true)    {
            
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
        Scanner file = null;
        String[] str;
        String name;
        int priority;
        Date date;
        boolean completed = false;
        
        try   {
            file = new Scanner(new FileReader(fileName));        
            while(file.hasNext())   {
                str = file.nextLine().split(",");
                
                name = str[0];
                priority = tryParseInt(str[1]);
                String[] loc = str[2].split(" ");
                date = new Date(tryParseInt(loc[0]),tryParseInt(loc[1]),tryParseInt(loc[2]));
                
                if(str[3].equalsIgnoreCase("y"))
                    completed = true;
                if(str[3].equalsIgnoreCase("n"))
                    completed = false;
                Task newTask = new Task(name, priority, date, completed);
            
                todo.add(newTask);
            }
        } catch(IOException e)   {               
        }       
        System.out.println("List Loaded");
    }
    
    public void saveList(String fileName)
    {
        PrintWriter outFile = null;
        try {            
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
        while(true)   {
        System.out.print(toString());
        System.out.print("Enter task number or 0 to return to main menu: ");
        taskNum = tryParseInt(sc.nextLine());   
            if(taskNum >= 0 && taskNum <= todo.size())
                return taskNum - 1;
            if(taskNum > todo.size() || taskNum < 0)
                System.out.println("Invalid Entry");   
        }        
    }
        
    @Override
    public String toString()   {
        
        String str = "";
        
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
        while (true)   {
            if(edit)   {            
                System.out.print("Enter new text (Enter only to keep current): ");
            }else   {
                System.out.print("Name of Task: ");  
            }
            name = sc.nextLine();
            if(!name.isEmpty() || edit)               
                return name;
            else
                System.out.println("Name Required");
        }
    }
    
    private int enterPriority(boolean edit)   {
        int priority;
        Scanner sc = new Scanner(System.in);
        while(true)   {
            if (edit)   {
                System.out.print("Enter a new priority of task (1-Low, 2-Moderate, 3-High, 4-Urgent, 0- No Change: ");
            } else
            {
                System.out.print("Enter priority of task (1-Low, 2- Moderate, 3- High, 4- Urgent): ");
            }
            priority = tryParseInt(sc.nextLine());
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
        while(true)   {
            if (edit)   {
                System.out.print("Enter new month dat year of due date as integers i.e. (1 1 2017) or  0 0 0 "
                   + "for no change: " );
            } else   {
               System.out.print("Enter Month Day Year of due date as integers: "); 
            }           
            String[] loc = sc.nextLine().split(" ");
            try   {
                date.setMonth(tryParseInt(loc[0])); 
                date.setDay(tryParseInt(loc[1]));   
                date.setYear(tryParseInt(loc[2]));           
            
                if(edit && date.getMonth() == 0 && date.getDay() == 0 && date.getYear() == 0)   {                  
                    return date;
                }
            
                if(date.getMonth() > 0 && date.getMonth() < 13 && date.getDay() > 0 && date.getDay() < 367 && date.getYear() > 0)   {                
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
    
    private int tryParseInt(String str)   {
        try{       
            return Integer.parseInt(str);
        } catch (NumberFormatException e)   {
            return -1;                   
        }
    }    
}