package manage_expense_w5.controller;

import manage_expense_w5.model.Expense;
import manage_expense_w5.model.ExpenseList;
import manage_expense_w5.view.ExpenseView;

import java.util.ArrayList;
import java.util.List;

public class ExpenseController {
    private ExpenseView view;
    private ExpenseList expenseList;

    public ExpenseController(ExpenseView view, ExpenseList expenseList) {
        this.view = view;
        this.expenseList = expenseList;
    }

    public void start() {
        while (true) {
            int choice = view.showMenu();
            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    displayAllExpenses();
                    break;
                case 3:
                    deleteExpense();
                    break;
                case 4:
                    return;
                default:
                    view.showMessage("Invalid choice");
            }
        }
    }

    public void addExpense() {
        String date = view.getInputDate();
        double amount = view.getInputAmount();
        String content = view.getInputContent();
        expenseList.addExpense(date, amount, content);
        view.showMessage("add successfully");
    }

    public void displayAllExpenses() {
        List<Expense> expense = expenseList.getExpenses();
        view.displayExpenses(expense);
        view.displayTotalAmount(expenseList.getTotalExpenses());
    }

    public void deleteExpense() {
        int id = view.getInputId();
        boolean result = expenseList.deleteExpense(id);
        if (result) {
            view.showMessage("delete successfully");
        } else {
            view.showMessage("delete failed");
        }
    }

    public static void main(String[] args) {
        ExpenseView view = new ExpenseView();
        List<Expense> expenseList = new ArrayList<>();
        ExpenseList list = new ExpenseList(expenseList);
        ExpenseController controller = new ExpenseController(view,list);

        controller.start();
    }
}
