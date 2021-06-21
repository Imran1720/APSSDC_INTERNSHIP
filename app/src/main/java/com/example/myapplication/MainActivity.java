package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    TextView res;
    Button a,b;

    int sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1=(EditText) findViewById(R.id.editTextNumber);
        num2=(EditText) findViewById(R.id.editTextNumber2);
        a=(Button) findViewById(R.id.button);
        b=(Button) findViewById(R.id.button2);
        res=(TextView) findViewById(R.id.result);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Double nu1=Double.parseDouble(num1.getText().toString());
              Double nu2=Double.parseDouble(num2.getText().toString());

                Double sum= nu1+nu2;

                res.setText(Double.toString(sum));
            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double nu1=Double.parseDouble(num1.getText().toString());
                Double nu2=Double.parseDouble(num2.getText().toString());
                Double sum=nu1*nu2;

                res.setText(Double.toString(sum));
            }
        });

    }
}