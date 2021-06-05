package com.example.dialoguepicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.time);
    }


    public void alert(View view) {
        //icon,title,message,clickables
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setIcon(R.drawable.ic_baseline_warning_24);
        b.setTitle("Alert Dialogue");
        b.setMessage("Do you want to Exit!!");
        b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Alert Dialogue closed", Toast.LENGTH_SHORT).show();
            }
        });

        b.show();
    }

    public void time(View view) {
        Calendar c = Calendar.getInstance();
        int hours=c.get(Calendar.HOUR);
        int min=c.get(Calendar.MINUTE);
        TimePickerDialog tpd=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv.setText(hourOfDay+":"+minute);
            }
        },hours,min,false);
        tpd.show();


    }
}