import java.text.SimpleDateFormat;
import java.util.*;
public class Addingtask {
    public static void addTask(ArrayList<String> taskNames, ArrayList<Date> taskDeadlines, String taskName, String deadline) {
        Date deadlineDate = validateDate(deadline);
        if (deadlineDate != null) {
            taskNames.add(taskName);
            taskDeadlines.add(deadlineDate);
            System.out.println("Task added successfully!\n");
        }
    }
    public static Date validateDate(String deadline) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        try {
            Date date = dateFormat.parse(deadline);
            return date;
        } catch (Exception e) {
            System.out.println("Invalid date format! Please enter the deadline in DD-MM-YYYY format.\n");
            return null;
        }
    }

    public static String userChoice(int choice, ArrayList<String> taskNames, ArrayList<Date> taskDeadlines, Scanner scanner) {
        if (choice == 1) {
            System.out.print("Enter task name: ");
            String taskName = scanner.nextLine();

            System.out.print("Enter deadline (DD-MM-YYYY): ");
            String deadline = scanner.nextLine();

            addTask(taskNames, taskDeadlines, taskName, deadline);
        } else if (choice == 2) {

            System.out.print("Enter task number to delete: ");

            int taskNumber = Integer.parseInt(scanner.nextLine());

            deleteTask(taskNames, taskDeadlines, taskNumber);
        } else if (choice == 3) {
            displayTasks(taskNames, taskDeadlines);
        } else if (choice == 4) {
            return "Exiting application. Goodbye!";
        } else {
            System.out.println("Invalid choice!\n");
        }

        return null;
    }

    public static void deleteTask(ArrayList<String> taskNames, ArrayList<Date> taskDeadlines, int taskNumber) {
        System.out.println("Task with " + taskNumber + " number deleted successfully");
    }

    public static void displayTasks(ArrayList<String> taskNames, ArrayList<Date> taskDeadlines) {
        System.out.println("Let's display the tasks");
    }

    public static void main(String[] args) {
        ArrayList<String> taskNames = new ArrayList<>();
        ArrayList<Date> taskDeadlines = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the To-Do List Application!");

        while (true) {
            System.out.println("Choose one operation:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            String value = userChoice(choice, taskNames, taskDeadlines, scanner);

            if ("Exiting application. Goodbye!".equals(value)) {
                System.out.println(value);
                break;
            }
        }

        scanner.close();
    }

}
