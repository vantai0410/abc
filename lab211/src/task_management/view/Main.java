package task_management.view;

import task_management.model.TaskList;

public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        TaskList_View taskListView = new TaskList_View(taskList);

        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    taskListView.addTaskView();
                    break;
                case 2:
                    taskListView.deleteTask();
                    break;
                case 3:
                    taskListView.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
