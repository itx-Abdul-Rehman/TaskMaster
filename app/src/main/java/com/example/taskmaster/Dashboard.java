package com.example.taskmaster;

import static com.example.taskmaster.MyApplication.taskModels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Dashboard extends AppCompatActivity {

    ConstraintLayout portrait, landscape;
    FrameLayout frameLayout;
    FragmentManager manager;
    Fragment listTask,detailTask;
    TextView noTask;
    MaterialToolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //readTasksFromFile();
        materialToolbar=findViewById(R.id.toolbar);


       TaskListFragment taskListFragment=new TaskListFragment();
       manager=getSupportFragmentManager();
        FragmentTransaction ft=manager.beginTransaction();
        ft.replace(R.id.frameLayout,taskListFragment);

        ft.commit();




     materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
         @Override
         public boolean onMenuItemClick(MenuItem item) {

             int itemID=item.getItemId();

             if(R.id.signout==itemID){
                 SharedPreferences sharedPreferences=getSharedPreferences("users",MODE_PRIVATE);
                 SharedPreferences.Editor editor=sharedPreferences.edit();
                 editor.putBoolean("isSignin",false);
                 editor.apply();
                 Intent intent=new Intent(Dashboard.this,MainActivity.class);
                 startActivity(intent);
                 finish();
                 return true;

             }else if(R.id.setting==itemID){

             }else if(R.id.dueDate==itemID){
                 Collections.sort(taskModels, new Comparator<TaskModel>() {
                     @Override
                     public int compare(TaskModel task1, TaskModel task2) {

                         return task1.getDate().compareTo(task2.getDate());
                     }
                 });

                 finish();
                 startActivity(getIntent());

             }else if(R.id.completetion==itemID){

             }else if(R.id.priorityLevel==itemID){

                 Collections.sort(taskModels, new Comparator<TaskModel>() {
                     @Override
                     public int compare(TaskModel task1, TaskModel task2) {

                         return task1.getPriorityLevel().compareTo(task2.getPriorityLevel());
                     }
                 });

                 finish();
                 startActivity(getIntent());
             }

           return  false;
         }
     });





    }

    public void readTasksFromFile() {
        File file = new File(getFilesDir(), "taskDetails.txt");
        if (file.exists() && file.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 5) {
                        String taskName = parts[0];
                        String description = parts[1];
                        String date = parts[2];
                        String time = parts[3];
                        String priority = parts[4];


                        TaskModel task = new TaskModel(taskName, date, time, description, priority);
                        taskModels.add(task);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}