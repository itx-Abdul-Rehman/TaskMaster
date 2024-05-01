package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.FrameLayout;

public class Dashboard extends AppCompatActivity {

    ConstraintLayout portrait, landscape;
    FrameLayout frameLayout;
    FragmentManager manager;
    Fragment listTask,detailTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       TaskListFragment taskListFragment=new TaskListFragment();
       manager=getSupportFragmentManager();
        FragmentTransaction ft=manager.beginTransaction();
        ft.replace(R.id.frameLayout,taskListFragment);
        ft.commit();








    }
}