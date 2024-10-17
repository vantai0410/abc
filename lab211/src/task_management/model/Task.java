package task_management.model;

import java.util.Date;

public class Task {
    private int id;
    private int taskTypeID;
    private String requirementName;
    private Date date;
    private double planForm;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int id, int taskTypeID, String requirementName, Date date, double planForm, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planForm = planForm;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPlanForm() {
        return planForm;
    }

    public void setPlanForm(double planForm) {
        this.planForm = planForm;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-10d %-12tF %-5.1f %-5.1f %-10s %-10s",
                id, requirementName, taskTypeID, date, planForm, planTo, assignee, reviewer);
    }
    }

