package com.example.taskmaster;

import android.app.Application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyApplication extends Application {
    public static ArrayList<TaskModel> taskModels;

    public MyApplication() {
        taskModels=new ArrayList<>();
        readTasksFromFile();

    }

    public static void readTasksFromFile()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("taskDetails")))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String taskName = parts[0];
                    String description = parts[1];
                    String date = parts[2];
                    String time = parts[3];
                    String priority = parts[4];

                    TaskModel task=new TaskModel(taskName,date,time,description,priority);
                    taskModels.add(task);
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
