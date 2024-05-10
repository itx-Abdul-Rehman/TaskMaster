package com.example.taskmaster;

import android.app.Application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyApplication extends Application {
    public static ArrayList<TaskModel> taskModels;

    public MyApplication() {
        taskModels=new ArrayList<>();


    }


}
