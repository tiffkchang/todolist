package com.example.todolist;

public class Task {
    private String taskName;
//    private int estimatedTaskLength; //in seconds
    private int estimatedHours = 0;
    private int estimatedMinutes = 0;
    private int actualTaskLength = 0; //in seconds
    private boolean completed = false;

    public Task(String taskName, int estimatedHours, int estimatedMinutes) {
        this.taskName = taskName;
        this.estimatedHours = estimatedHours;
        this.estimatedMinutes = estimatedMinutes;

    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getEstimatedTaskLength() {
        int estimatedTaskLength = ((estimatedHours * 60 * 60) + (estimatedMinutes * 60));
        return estimatedTaskLength; //this is in seconds
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
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

