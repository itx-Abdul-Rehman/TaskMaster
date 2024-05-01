package com.example.taskmaster;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TaskListFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<TaskModel> taskModels=new ArrayList<>();
    public TaskListFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_task_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recyclerView);

        MyTaskListAdpater myTaskListAdpater=new MyTaskListAdpater(taskModels);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myTaskListAdpater);

        addTask();

    }


    private  void addTask(){
        TaskModel taskModel=new TaskModel("Assignment MAD 2","1 May, ","11:59pm");
        TaskModel taskModel2=new TaskModel("Assignment MAD 2","1 May, ","11:59pm");
        TaskModel taskModel3=new TaskModel("Assignment MAD 2","1 May, ","11:59pm");
        TaskModel taskModel4=new TaskModel("Assignment MAD 2","1 May, ","11:59pm");
        TaskModel taskModel5=new TaskModel("Assignment MAD 2","1 May, ","11:59pm");
        TaskModel taskModel6=new TaskModel("Assignment MAD 2","1 May, ","11:59pm");
        TaskModel taskModel7=new TaskModel("Assignment MAD 2","1 May, ","11:59pm");
        TaskModel taskModel8=new TaskModel("Assignment MAD 2","1 May, ","11:59pm");
        TaskModel taskModel9=new TaskModel("Assignment MAD 2","1 May, ","11:59pm");
        TaskModel taskModel10=new TaskModel("Assignment MAD 2","1 May, ","11:59pm");
        TaskModel taskModel12=new TaskModel("Assignment MAD 2","1 May, ","11:59pm");
        TaskModel taskModel11=new TaskModel("Assignment MAD 2","1 May, ","11:59pm");
        taskModels.add(taskModel);
        taskModels.add(taskModel2);
        taskModels.add(taskModel3);
        taskModels.add(taskModel4);
        taskModels.add(taskModel5);
        taskModels.add(taskModel6);
        taskModels.add(taskModel7);
        taskModels.add(taskModel8);
        taskModels.add(taskModel9);
        taskModels.add(taskModel10);
        taskModels.add(taskModel11);
        taskModels.add(taskModel12);

    }
}