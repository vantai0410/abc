package manage_expense_w5.model;

import java.util.List;

public class ExpenseList {
    private List<Expense> expenses;
    private int currentId =1;

    public ExpenseList(List<Expense> expenses) {
        this.expenses = expenses;;
    }
    public boolean addExpense(String date, double amount, String content) {
        Expense expense = new Expense(currentId, date, amount, content);
        currentId++;
        expenses.add(expense);
        return true;
    }
    public List<Expense> getExpenses() {
        return expenses;
    }
    public Expense findExpenseId(int id) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                return expense;
            }
        }
        return null;
    }
    public boolean deleteExpense(int id) {
        Expense expense = findExpenseId(id);
        if (expense != null) {
            expenses.remove(expense);
        }
        return true;
    }
    public double getTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }
}
