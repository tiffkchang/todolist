package com.example.todolist;

public class Task {
    private String taskName;
    private int estimatedTaskLength; //in seconds
    private int actualTaskLength = 0; //in seconds
    private boolean completed = false;

    public Task(String taskName, int estimatedTaskLength) {
        this.taskName = taskName;
        this.estimatedTaskLength = estimatedTaskLength;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getEstimatedTaskLength() {
        return estimatedTaskLength;
    }

    public void setEstimatedTaskLength(int estimatedTaskLength) {
        this.estimatedTaskLength = estimatedTaskLength;
    }

    public int getActualTaskLength() {
        return actualTaskLength;
    }

    public void setActualTaskLength(int actualTaskLength) {
        this.actualTaskLength = actualTaskLength;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
