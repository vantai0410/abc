package task_management.model;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public TaskList() {
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    public void addTask(Task task) {
        tasks.add(task);
    }
    public boolean deleteTask(int id) {
        for(Task task : tasks) {
            if(task.getId() == id) {
                tasks.remove(task);
                return true;
            }
        }
        return false;
    }

}
