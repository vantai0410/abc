package manage_expense_w5.model;

public class Expense {
    private int id;
    private String date;
    private double amount;
    private String content;

    public Expense(int id, String date, double amount, String content) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-10.2f %-20s", id, date, amount, content);
    }
}

