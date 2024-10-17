package manage_worker_information.Model;

public class SalaryHistory {
    private double adjustedSalary;
    private String status;
    private String date;

    public SalaryHistory(double adjustedSalary, String status, String date) {
        this.adjustedSalary = adjustedSalary;
        this.status = status;
        this.date = date;
    }

    public double getAdjustedSalary() {
        return adjustedSalary;
    }

    public void setAdjustedSalary(double adjustedSalary) {
        this.adjustedSalary = adjustedSalary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
