package com.example.taskmaster;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import java.util.ArrayList;

public class TaskListFragment extends Fragment {
    View view;
    View popupView;
    Button addButton;
    RecyclerView recyclerView;
    ArrayList<TaskModel> taskModels=new ArrayList<>();
    public TaskListFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        popupView=inflater.inflate(R.layout.input_popup,container,false);
        view=inflater.inflate(R.layout.fragment_task_list, container, false);

        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recyclerView);
        addButton=view.findViewById(R.id.button);

        MyTaskListAdpater myTaskListAdpater=new MyTaskListAdpater(taskModels);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myTaskListAdpater);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });




        addTask();

    }


    private  void addTask(){



         LayoutInflater inflater=(LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
         View popup=inflater.inflate(R.layout.input_popup,null,false);

         int width= ViewGroup.LayoutParams.MATCH_PARENT;
         int height= ViewGroup.LayoutParams.WRAP_CONTENT;
         PopupWindow popupWindow=new PopupWindow(popup,width,height,true);
         CardView cardView=popupView.findViewById(R.id.inputCard);

         cardView.post(new Runnable() {
             @Override
             public void run() {
                 popupWindow.showAtLocation(cardView, Gravity.BOTTOM,0,0);
             }
         });



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