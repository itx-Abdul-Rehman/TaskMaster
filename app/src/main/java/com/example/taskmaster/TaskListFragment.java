package com.example.taskmaster;

import static com.example.taskmaster.MyApplication.taskModels;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class TaskListFragment extends Fragment implements  ItemClickListener {
    View view,cardsView;
    View popupView;
    TextView noTask;
    Button addButton;
    RecyclerView recyclerView;
    RadioButton radioButton;

    TextView taskName,date,time;
    public TaskListFragment() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       cardsView=inflater.inflate(R.layout.my_task_list_layout,container,false);
        popupView=inflater.inflate(R.layout.activity_dashboard,container,false);
        view=inflater.inflate(R.layout.fragment_task_list, container, false);


        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recyclerView);
        addButton=view.findViewById(R.id.button);
        noTask=view.findViewById(R.id.noTask);
        radioButton=cardsView.findViewById(R.id.radioButton);

        if(taskModels.size()!=0){
            noTask.setVisibility(View.GONE);
        }

        MyTaskListAdpater myTaskListAdpater=new MyTaskListAdpater(taskModels);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myTaskListAdpater);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),inputActivity.class);
                startActivity(intent);
            }
        });

       myTaskListAdpater.onItemClickListener(this);

    }


    @Override
    public void onCLick(View v, int pos) {
        RadioButton radioButton1;
        radioButton1=v.findViewById(R.id.radioButton);
        FragmentManager manager;
        TaskDetailsFragment taskDetailsFragment=new TaskDetailsFragment(pos);
        manager=getActivity().getSupportFragmentManager();
        FragmentTransaction ft=manager.beginTransaction();
        ft.replace(R.id.frameLayout,taskDetailsFragment);
        ft.commit();
        ft.addToBackStack(null);
    }


}