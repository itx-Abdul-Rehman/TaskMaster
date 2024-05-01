package com.example.taskmaster;

public class TasksortByDate implements Comparable<TaskModel>{

    private String taskName;
    private String date;
    private String time;
    private String desc;
    private String priorityLevel;

    private boolean completed;



    public void setCompleted(boolean completed){
        this.completed=completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public TasksortByDate(String taskName, String date, String time, String desc, String priorityLevel) {
        this.taskName = taskName;
        this.date = date;
        this.time = time;
        this.desc = desc;
        this.priorityLevel = priorityLevel;
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

    @Override
    public int compareTo(TaskModel o) {
        return this.date.compareTo(o.getDate());
    }
}
