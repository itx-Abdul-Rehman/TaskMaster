package com.example.taskmaster;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {
    public static ArrayList<TaskModel> taskModels;

    public MyApplication() {
        taskModels=new ArrayList<>();
    }
}
