package com.example.taskmaster;

import static com.example.taskmaster.MyApplication.taskModels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    Button signupButton;
    Login_fragment signin_Fragment;
    Signup_Fragment signup_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int frame_layout=R.id.frameLayout;

        //--------------- create object signin and signup fragment---------------------------------
        signin_Fragment=new Login_fragment();
        signup_fragment=new Signup_Fragment();

        //-----------------set  default fragment to main activity------------------------------------------
        SharedPreferences sharedPreferences=getSharedPreferences("users",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        boolean check=sharedPreferences.getBoolean("isSignin",false);
        editor.putInt("frame_layout",frame_layout);
        editor.apply();

        if(check==true){
            Intent intent=new Intent(MainActivity.this,Dashboard.class);
            startActivity(intent);
            finish();
        }else{
            transactionFragment(signup_fragment);
        }


       //------------data send to signup Fragment-------------------------------
       Bundle bundle=new Bundle();
       bundle.putInt("framelayout",R.id.frameLayout);
       signup_fragment.setArguments(bundle);






    }

    public void transactionFragment(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frameLayout,fragment);
        ft.commit();
    }



    //----------------

}