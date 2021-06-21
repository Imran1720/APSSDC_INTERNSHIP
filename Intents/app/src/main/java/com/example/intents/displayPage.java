package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class displayPage extends AppCompatActivity {

    EditText phno,link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);

        phno=findViewById(R.id.phno);
        link=findViewById(R.id.link);

        String n=getIntent().getStringExtra("name");
        Toast.makeText(this, "Welcome to new intent Activity "+n, Toast.LENGTH_SHORT).show();
    }

    public void dail(View view) {
        String n = phno.getText().toString();
        Uri uri = Uri.parse("tel:"+n);
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);
    }

    public void search(View view) {
        String n = link.getText().toString();
        //uri:unified resorce identifier
        //phone-tel: ; link https:// ; location: geo:lat,lan

        Uri uri=Uri.parse("https://"+n);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }
}