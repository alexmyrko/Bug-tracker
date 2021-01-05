package com.bugtracker.model;

import java.time.LocalDateTime;

// Class Ticket should have all necessary fields described in Excel file and in description added to the project
public class Ticket {
    private int id;
    private String description;
    private User assignee;
    private User reporter;
    private Status status;
    private Priority priority;
    private int timeSpent = 0;
    private int timeEstimated;
    private int totalTime;
    private LocalDateTime creationDate;

    public Ticket(String description, User assignee, User reporter, Status status, Priority priority, int timeEstimated) {
        this.description = description;
        this.assignee = assignee;
        this.reporter = reporter;
        this.status = status;
        this.priority = priority;
        this.timeEstimated = timeEstimated;
        creationDate = LocalDateTime.now();
        totalTime = timeEstimated;
    }

    public Ticket() {

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
        return totalTime - timeSpent;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", assignee=" + assignee.getUserName() +
                ", reporter=" + reporter.getUserName() +
                ", status=" + status +
                ", priority=" + priority +
                ", timeSpent=" + timeSpent +
                ", timeEstimated=" + timeEstimated +
                ", creation date=" + creationDate +
                '}';
    }
}
