package task_management.view;

import task_management.model.Task;
import task_management.model.TaskList;
import task_management.model.TypeOfTask;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TaskList_View {
    private TaskList taskList;
    private TypeOfTask typeOfTask;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public TaskList_View(TaskList taskList) {
        this.taskList = taskList;
        this.typeOfTask = new TypeOfTask();
    }

    public void addTaskView() {
        System.out.println("========= Task program =========");
        System.out.println("1. Add Task");
        System.out.println("Requirement Name: ");
        String input = DataInput.inputString();
        System.out.print("Task Type (1-4): ");
        int typeID = (int) DataInput.inputLimit(1, 4);
        System.out.println("Date (dd-MM-yyyy): ");
        Date date = DataInput.inputDate();
        System.out.println("From (8.0 - 17.5, increments of 0.5): ");
        double from = DataInput.inputLimit(8, 17.5);
        System.out.println("To (8.0 - 17.5, increments of 0.5) ");
        double to = DataInput.inputLimit(8, 17.5);
        if (from >= to) {
            System.out.println("Plan From must be less than Plan To.");
            return;
        }
        System.out.println("Assignee: ");
        String assignee = DataInput.inputString();
        System.out.println("Reviewer: ");
        String reviewer = DataInput.inputString();
        Task task = new Task(taskList.getTasks().size() + 1, typeID, input, date, from, to, assignee, reviewer);
        taskList.addTask(task);
        System.out.println("--------- Add Task ---------");
        System.out.println("Requirement Name: " + input);
        System.out.println("Task Type: " + typeID);
        System.out.println("Date: " + new java.text.SimpleDateFormat("dd-MM-yyyy").format(date));
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Assignee: " + assignee);
        System.out.println("Reviewer: " + reviewer );

        System.out.println("Task added successfully.");
    }

    public void deleteTask() {
        System.out.println("Enter Task ID to delete: ");
        int id = (int) DataInput.inputLimit(1, Integer.MAX_VALUE);
        boolean result = taskList.deleteTask(id);
        if (result) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task ID not found.");
        }
    }

    public void displayTasks() {
        if (taskList.getTasks().isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("----- Task List -----");
            System.out.printf("%-5s %-15s %-10s %-12s %-5s %-10s %-10s\n",
                    "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");

            for (Task task : taskList.getTasks()) {

                String taskTypeName = typeOfTask.getTask(task.getTaskTypeID());
                double timeSpent = task.getPlanTo() - task.getPlanForm();
                String format = dateFormat.format(task.getDate());
                System.out.printf("%-5d %-15s %-10s %-12s %-5.1f %-10s %-10s\n",
                        task.getId(), task.getRequirementName(), taskTypeName,
                        format, timeSpent, task.getAssignee(), task.getReviewer());
            }
        }
    }
}

