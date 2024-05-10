package com.example.taskmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyTaskListAdpater extends RecyclerView.Adapter<MyTaskListAdpater.MyViewHolder> {

    private ArrayList<TaskModel> taskModels=new ArrayList<>();
    private ItemClickListener clickListener;

    public void onItemClickListener(ItemClickListener clickListener){
        this.clickListener=clickListener;
    }

    public MyTaskListAdpater(ArrayList<TaskModel> taskModels) {
        this.taskModels = taskModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.my_task_list_layout,
                parent,false);

        return  new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TaskModel taskModel=taskModels.get(position);

        holder.taskName.setText(taskModel.getTaskName());
        holder.date.setText(taskModel.getDate());
        holder.time.setText(taskModel.getTime());

    }


    @Override
    public int getItemCount() {
        return taskModels.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
       RadioButton radioButton;
       TextView taskName,date,time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            radioButton=itemView.findViewById(R.id.radioButton);
            taskName=itemView.findViewById(R.id.taskName);
            date=itemView.findViewById(R.id.date);
            time=itemView.findViewById(R.id.time);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener!=null){
                clickListener.onCLick(v,getAdapterPosition());
            }
        }



    }
}
