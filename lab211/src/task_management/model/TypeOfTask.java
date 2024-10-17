package task_management.model;

import java.util.HashMap;

public class TypeOfTask {
    private HashMap<Integer,String> typeOfTasks = new HashMap<>();

    public TypeOfTask() {
        typeOfTasks.put(1,"Code");
        typeOfTasks.put(2,"Test");
        typeOfTasks.put(3,"Design");
        typeOfTasks.put(4,"Review");

    }

    public TypeOfTask(HashMap<Integer, String> typeOfTasks) {
        this.typeOfTasks = typeOfTasks;
    }
    public String getTask(int id) {
        return typeOfTasks.getOrDefault(id,"Unknown");
    }
    @Override
    public String toString() {
        return "TypeOfTask{" +
                "typeOfTasks=" + typeOfTasks +
                '}';
    }
}
