package task_management.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static private List<String> choices = Arrays.asList("========= Task program =========",
            "1. Add Task", "2. Delete task", "3. Display Task", "4. exit");

    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        choices.forEach(s -> System.out.println(s));
        return sc.nextInt();
    }
}
