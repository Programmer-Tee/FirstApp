package com.example.tobeisun.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText Username, Password ;
    Button btn ;
    Button btn2 ;

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username= (EditText) findViewById(R.id.editTextUsername);
        Password=(EditText) findViewById(R.id.editTextPassword) ;


    }

    public void Login(View t)
    {

        try{
            String Usernamestr =Username.getText().toString() ;
            String Passwordstr= Password.getText().toString() ;

            //TODO  CHECK EMPTY PASSWORD AND USERNAME



            String Password=helper.searchpass(Passwordstr) ;

            if(Passwordstr.equals(Password))
            {
                Intent intent =new Intent(Login.this,Welcome.class);
                intent.putExtra("Username",Usernamestr);
                startActivity(intent);

            }
            else
            {
                Toast.makeText(Login.this,"Username and Passwords don't match",Toast.LENGTH_SHORT).show(); ;


            }

        }catch(Exception ex){

            Toast.makeText(Login.this,"Enter username and password",Toast.LENGTH_SHORT).show();

            System.out.println("error: "+ex);
        }


        }


    public void showSignUpPage(View t)
    {
        Intent intent =new Intent(Login.this,Signup.class);

        startActivity(intent);


    }

    }



