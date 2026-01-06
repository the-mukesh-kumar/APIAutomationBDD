package com.api.models.request;

public class UpdateActivityRequest {
    private int id;
    private String title;
    private String dueDate;
    private boolean completed;

    // No-argument constructor (required by Jackson)
    public UpdateActivityRequest() {
    }

    // Getter & Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter & Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter & Setter for dueDate
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    // Getter & Setter for completed
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // Optional: helpful for debugging/logging
    @Override
    public String toString() {
        return "UpdateActivityRequest [id=" + id +
                ", title=" + title +
                ", dueDate=" + dueDate +
                ", completed=" + completed + "]";
    }
}