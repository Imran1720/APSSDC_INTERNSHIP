package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=findViewById(R.id.uname);
        pass=findViewById(R.id.pass);
    }

    public void login(View view) {
        if(uname.getText().toString().equals("admin") && pass.getText().toString().equals("admin"))
        {
            String n = uname.getText().toString();
            Intent i =new Intent(this,displayPage.class);
            i.putExtra("name",n);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }
    }
}