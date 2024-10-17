package task_management.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DataInput {
    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Please enter a string again");
            }
        }
    }

    public static double inputPositiveDouble() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                double input = Double.parseDouble(inputString());
                if (input > 0) {
                    return input;
                } else {
                    System.out.println("Please enter a positive integer");
                }
            } catch (Exception e) {
                System.out.println("please enter a positive integer");
                System.out.println("please again");
            }
        }
    }

    public static double inputLimit(double min, double max) {
        while (true) {
            double input = inputPositiveDouble();
            if (input >= min && input <= max && (input * 10) % 5 == 0)  {
                return input;
            } else {
                System.out.println("enter again");
            }
        }
    }

    public static Date inputDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        while (true) {
            try {
                return sdf.parse(inputString());
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter a valid date (dd-MM-yyyy).");
            }

        }
    }
}
