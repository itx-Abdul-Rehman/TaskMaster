package com.example.taskmaster;

import static com.example.taskmaster.MyApplication.taskModels;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class inputActivity extends AppCompatActivity {

    Button saveBtn,calenderBtn;
    EditText taskName,desc,priorityLevel;
    String date;
    String time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        saveBtn=findViewById(R.id.saveBtn);
        calenderBtn=findViewById(R.id.addDate);
        taskName=findViewById(R.id.name);
        desc=findViewById(R.id.remarks);
        priorityLevel=findViewById(R.id.priorityLevel);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=taskName.getText().toString();
                String remarks=desc.getText().toString();
                String prtLevel=priorityLevel.getText().toString();
                if(name.isEmpty()){
                    taskName.setError("Enter name of task");
                }else{
                    TaskModel taskModel=new TaskModel(name,date,time,remarks,prtLevel);
                    writeTaskToFile(name,remarks,date,time,prtLevel);
                    taskModels.add(taskModel);
                    Intent intent=new Intent(inputActivity.this,Dashboard.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

        calenderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimePickerDialog();
            }
        });


    }

    private void showDateTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);


        DatePickerDialog datePickerDialog = new DatePickerDialog(inputActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Handle date selection
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        showTimePickerDialog(selectedDate);
                    }
                }, year, month, dayOfMonth);


        datePickerDialog.show();
        date=""+dayOfMonth+" "+month+",";
    }

    private void showTimePickerDialog(final String selectedDate) {
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(inputActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Handle time selection
                        String selectedTime = hourOfDay + ":" + minute;
                        String dateTime = selectedDate + " " + selectedTime;
                        Toast.makeText(inputActivity.this, "Selected date and time: " + dateTime, Toast.LENGTH_SHORT).show();
                    }
                }, hourOfDay, minute, true);
        timePickerDialog.show();
        time=hourOfDay+":"+minute;
    }

    public void writeTaskToFile(String taskName, String description, String date, String time, String priority)
    {

        try
        {
            FileWriter fileWriter=new FileWriter("taskDetails",true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write( taskName);
            writer.write(",");
            writer.write(description);
            writer.write(",");
            writer.write(date);
            writer.write(time);
            writer.write(",");
            writer.write(priority);
            Toast.makeText(inputActivity.this,"Write",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
