package com.example.taskmaster;

import static com.example.taskmaster.MyApplication.taskModels;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class TaskDetailsFragment extends Fragment {
    TextView taskName,date,time;
   String newDate,newTime;
    EditText remarks,priorityLevel;

    int pos;

   public TaskDetailsFragment(int pos){
       this.pos=pos;
   }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task_details,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        taskName=view.findViewById(R.id.taskName);
        date=view.findViewById(R.id.date);
        time=view.findViewById(R.id.time);
        remarks=view.findViewById(R.id.desc);
        priorityLevel=view.findViewById(R.id.priorityLevel);

        TaskModel taskModel=taskModels.get(pos);
        taskName.setText(taskModel.getTaskName());
        date.setText(taskModel.getDate());
        time.setText(taskModel.getTime());
        remarks.setText(taskModel.getDesc());
        priorityLevel.setText(taskModel.getPriorityLevel());


    }

    private void showDateTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);


        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Handle date selection
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        showTimePickerDialog(selectedDate);
                    }
                }, year, month, dayOfMonth);


        datePickerDialog.show();
        newDate=""+dayOfMonth+month+",";
    }

    private void showTimePickerDialog(final String selectedDate) {
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Handle time selection
                        String selectedTime = hourOfDay + ":" + minute;
                        String dateTime = selectedDate + " " + selectedTime;
                        Toast.makeText(getContext(), "Selected date and time: " + dateTime, Toast.LENGTH_SHORT).show();
                    }
                }, hourOfDay, minute, true);
        timePickerDialog.show();
        newTime=hourOfDay+":"+minute;
    }

}