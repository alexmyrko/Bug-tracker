package com.bugtracker.model;

import java.time.LocalDateTime;

// Class Ticket should have all necessary fields described in Excel file and in description added to the project
public class Ticket {
    private int id;
    private String description;
    private User reporter;
    private User assignee;
    private Status status;
    private Priority priority;
    private int timeSpent = 0;
    private int timeEstimated;
    private LocalDateTime creationDate;

    public Ticket() {
    }

    public Ticket(String description, User assignee, User reporter, Status status, Priority priority, int timeEstimated) {
        this.description = description;
        this.assignee = assignee;
        this.reporter = reporter;
        this.status = status;
        this.priority = priority;
        this.timeEstimated = timeEstimated;
        creationDate = LocalDateTime.now();
    }

    public Ticket(int id, String description, User reporter, User assignee, Status status, Priority priority, int timeSpent,
                  int timeEstimated, LocalDateTime creationDate) {
        this.id = id;
        this.description = description;
        this.reporter = reporter;
        this.assignee = assignee;
        this.status = status;
        this.priority = priority;
        this.timeSpent = timeSpent;
        this.timeEstimated = timeEstimated;
        this.creationDate = creationDate;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", reporter=" + reporter.getUserName() +
                ", assignee=" + assignee.getUserName() +
                ", status=" + status +
                ", priority=" + priority +
                ", timeSpent=" + timeSpent +
                ", timeEstimated=" + timeEstimated +
                ", creation date=" + creationDate +
                '}';
    }
}
