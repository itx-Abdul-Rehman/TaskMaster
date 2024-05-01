package com.example.taskmaster;

public class TaskModel {
    private String taskName;
    private String date;
    private String time;

    public TaskModel(String taskName, String date, String time) {
        this.taskName = taskName;
        this.date = date;
        this.time = time;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
