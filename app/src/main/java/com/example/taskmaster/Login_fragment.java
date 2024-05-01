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
import android.widget.TextView;


public class Login_fragment extends Fragment {

    EditText email,password;
    Button signinButton;
    TextView signup;
    int frame_layout;
    Context parent;

    SharedPreferences sharedPreferences;

    public Login_fragment() {

    }

    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);
        parent=context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login_fragment,container,false);

       sharedPreferences=getActivity().getSharedPreferences("users",Context.MODE_PRIVATE);
       String frame_layoutID=sharedPreferences.getString("frame_layout","");
       frame_layout=Integer.parseInt(frame_layoutID);

        email=view.findViewById(R.id.emailAddress);
        password=view.findViewById(R.id.password);
        signinButton=view.findViewById(R.id.login);
        signup=view.findViewById(R.id.signup);

        //go to signup fragment
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transactionFragment(new Signup_Fragment());
            }
        });

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountSignin();
            }
        });

        return  view;
    }

    private void  accountSignin(){

        String emailAddress=email.getText().toString();
        String pass=password.getText().toString();

        if(emailAddress.isEmpty()){
            email.setError("Enter Email Address");
        }else if(pass.isEmpty()){
            password.setError("Enter Password");
        }else{
            sharedPreferences= getActivity().getSharedPreferences("users",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            String userEmail=sharedPreferences.getString("Email","");
            String userPassword=sharedPreferences.getString("Password","");
            if(!emailAddress.equals(userEmail)){
                email.setError("Email Address incorrect");
            }else if(!pass.equals(userPassword)){
                password.setError("Password incorrect");
            }else  {
                editor.putBoolean("isSignin",true);
                editor.apply();
                Intent intent=new Intent(getContext(),Dashboard.class);
                startActivity(intent);
                getActivity().finish();

            }


        }


    }


   private void transactionFragment(Fragment fragment){
       FragmentManager fm=getActivity().getSupportFragmentManager();
       FragmentTransaction ft=fm.beginTransaction();
       ft.replace(frame_layout,fragment);
       ft.commit();
   }

}