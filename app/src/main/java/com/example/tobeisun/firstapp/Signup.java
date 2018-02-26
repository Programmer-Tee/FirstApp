package com.example.tobeisun.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    Button btn ;
    DatabaseHelper helper=new DatabaseHelper(this) ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btn =(Button) findViewById(R.id.button) ;


    }

    public void Signup(View t) {
        if (t.getId() == R.id.button) {
            EditText name = (EditText) findViewById(R.id.editTextName);
            EditText number = (EditText) findViewById(R.id.editTextNumber);
            EditText Email = (EditText) findViewById(R.id.editTextEmail);
            EditText username = (EditText) findViewById(R.id.editTextUname);
            EditText password = (EditText) findViewById(R.id.editTextPword1);
            EditText confirmpassword = (EditText) findViewById(R.id.editTextPword2);


            String numberstr = number.getText().toString();
            String Emailstr = Email.getText().toString();
            String namestr = name.getText().toString();
            String Usernamestr = username.getText().toString();
            String passwordstr = password.getText().toString();
            String confirmpasswordstr = confirmpassword.getText().toString();

            if (!passwordstr.equals(confirmpasswordstr)) {
                Toast.makeText(Signup.this, "passwords don't match", Toast.LENGTH_SHORT).show();
            } else {
                Database d = new Database();
                d.setName(namestr);
                d.setNumber(numberstr);
                d.setEmail(Emailstr);
                d.setUsername(Usernamestr);
                d.setPassword(passwordstr);

                helper.insertDatabase(d);


            }
        }
    }

        public void showLoginPage (View t)
        {
            Intent intent = new Intent(Signup.this, Login.class);

            startActivity(intent);


        }

        }

