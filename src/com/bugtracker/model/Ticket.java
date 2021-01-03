package com.bugtracker.model;

// Class Ticket should have all necessary fields described in Excel file and in description added to the project
public class Ticket {
    private int id;
    private String description;
    private User assignee;
    private User reporter;
    private Status status;
    private Priority priority;
    private int timeSpent;
    private int timeEstimated;

    public Ticket(int id, String description, User assignee, User reporter, Status status, Priority priority, int timeSpent, int timeEstimated) {
        this.id = id;
        this.description = description;
        this.assignee = assignee;
        this.reporter = reporter;
        this.status = status;
        this.priority = priority;
        this.timeSpent = timeSpent;
        this.timeEstimated = timeEstimated;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getAssignee() {
        return assignee;
    }

    public User getReporter() {
        return reporter;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public int getTimeEstimated() {
        return timeEstimated;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public void setTimeEstimated(int timeEstimated) {
        this.timeEstimated = timeEstimated;
    }
}
