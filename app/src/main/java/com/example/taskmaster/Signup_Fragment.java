package com.example.taskmaster;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class Signup_Fragment extends Fragment {

    EditText signupEmail,signupPassword,signupcPassword,username;
    Button signupButton;
    TextView signin;

    int frame_layout;
    SharedPreferences sharedPreferences;

    public Signup_Fragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle=this.getArguments();
        frame_layout=bundle.getInt("framelayout");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_signup_,container,false);



        //attach hooks and get data from fragment
        username=view.findViewById(R.id.username);
        signupEmail=view.findViewById(R.id.emailAddress);
        signupPassword=view.findViewById(R.id.password);
        signupcPassword=view.findViewById(R.id.confirmpassword);
        signupButton=view.findViewById(R.id.signupButton);
        signin=view.findViewById(R.id.signin);

        //go to signin fragment
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transactionFragment(new Login_fragment());
            }
        });

        createAccount();
        return view;
    }


    public boolean createAccount(){


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=username.getText().toString();
                String email=signupEmail.getText().toString().trim();
                String password=signupPassword.getText().toString();
                String confrimPassword=signupcPassword.getText().toString();
                String numbers = "[0-9]+";
                String splChrs = "-/@#$%^&_+=()";
                String alphabet="[A-Za-z]+";
                if(email.isEmpty()){
                    signupEmail.setError("Enter Email Address");
                }else if(password.isEmpty()){
                    signupPassword.setError("Enter Password");
                } else if (confrimPassword.isEmpty()) {
                    signupcPassword.setError("Enter Confirm Password");
                } else {
                    if(password.length()<8){
                        signupPassword.setError("Password must be equal or greater than 8 characters");
                    }
                    else {
                            //account created data stored
                            if(password.equals(confrimPassword)){

                                sharedPreferences= getActivity().getSharedPreferences("users", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString("Name",name);
                                editor.putString("Email",email);
                                editor.putString("Password",password);
                                editor.apply();

                                Toast.makeText(getContext(),"Account Created",Toast.LENGTH_SHORT).show();
                                transactionFragment(new Login_fragment());
                            }else{
                                signupcPassword.setError("Password does not match");
                            }

                    }

                }

            }
        });

        return  true;
    }



    private void transactionFragment(Fragment fragment){
        FragmentManager fm= getActivity().getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(frame_layout,fragment);
        ft.commit();
    }

}