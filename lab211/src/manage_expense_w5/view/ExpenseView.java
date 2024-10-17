package manage_expense_w5.view;

import manage_expense_w5.model.Expense;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ExpenseView {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    Scanner sc = new Scanner(System.in);

    public int showMenu() {
        List<String> menuOptions = Arrays.asList(
                "=======Handy Expense program======",
                "1. Add an expense",
                "2. Display all expenses",
                "3. Delete an expense",
                "4. Quit"
        );
        for (String option : menuOptions) {
            System.out.println(option);
        }

        System.out.print("Your choice: ");
        return Integer.parseInt(sc.nextLine());
    }

    public String getInputDate() {
        System.out.print("Enter Date (dd-MMM-yyyy): ");
        String input = sc.nextLine();
        sdf.setLenient(false);
        try {
            sdf.parse(input);
            return input;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
            return getInputDate();
        }
    }

    public double getInputAmount() {
        System.out.print("Enter Amount: ");
        return Double.parseDouble(sc.nextLine());
    }

    public String getInputContent() {
        System.out.print("Enter Content: ");
        return sc.nextLine();
    }

    public int getInputId() {
        System.out.print("Enter ID: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void displayExpenses(List<Expense> list) {
        if (list.isEmpty()) {
            System.out.println("No expenses found.");
        } else {
            System.out.println(String.format("%-5s %-15s %-10s %-20s", "ID", "Date", "Amount", "Content"));

            for (Expense e : list) {
                System.out.println(String.format("%-5d %-15s %-10.2f %-20s", e.getId(), e.getDate(), e.getAmount(), e.getContent()));
            }
        }
    }

    public void displayTotalAmount(double total) {
        System.out.println(String.format("%-15s: %-10.2f", "Total", total));
    }


    public void showMessage(String message) {
        System.out.println(message);
    }


}
