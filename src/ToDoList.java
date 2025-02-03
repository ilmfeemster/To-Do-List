import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ToDoList {
    //Empty array list to hold tasks
    private ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        //Add task to list
        tasks.add(task);
        //Print message to user for confirmation
        System.out.println("Task added: " + task);
    }

    public void viewTasks() {
        //Check if  list is empty
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
            //Print list if not empty
        } else {
            System.out.println("To-Do List:");
            //Loop through list using the list's size
            for (int i = 0; i < tasks.size(); i++) {
                //Print out each task with "i + 1" numbering for human readability
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void deleteTask(int index) {
        //Check that number given by user is logically valid
        if (index >= 1 && index <= tasks.size()) {
            //Remove task  at "index - 1" because human shown task numbers are index + 1
            String task = tasks.remove(index - 1);
            //Print to console to give confirmation
            System.out.println("Task removed: " + task);
            //Reject numbers outside of task range
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) {
        //Initialize scanner
        Scanner scanner = new Scanner(System.in);
        //Create empty To-Do list
        ToDoList toDoList = new ToDoList();
        //While loop to run until exited by user
        while (true) {
            //Give main menu options and prompt user for a response
            System.out.println("\n1. Add Task\n2. View Tasks\n3. Delete Task\n4. Exit");
            System.out.print("Choose an option: ");
            //Try catch block to catch inputs that aren't integers
            try {
                //Get user input for menu choices
                int choice = scanner.nextInt();
                //Consume newline
                scanner.nextLine();

                switch (choice) {
                    //Perform add task menu option
                    case 1:
                        //Prompt user for task name
                        System.out.print("Enter task: ");
                        String task = scanner.nextLine();
                        //Add task to To-Do list
                        toDoList.addTask(task);
                        break;
                    //View task list menu option
                    case 2:
                        toDoList.viewTasks();
                        break;
                    //Delete task menu option
                    case 3:
                        System.out.print("Enter task number to delete: ");
                        //Try catch block for non integer responses
                        try {
                            //Get task number from user and delete associated task
                            int index = scanner.nextInt();
                            toDoList.deleteTask(index);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid task number.");
                            //Clear invalid input
                            scanner.next();
                        }
                        break;
                    //Exit menu
                    case 4:
                        System.out.println("Goodbye!");
                        return;
                    //Default handling for number out of menu range
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
              //Catch for non integer responses on main menu
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                //Clear invalid input
                scanner.next();
            }
        }
    }
}