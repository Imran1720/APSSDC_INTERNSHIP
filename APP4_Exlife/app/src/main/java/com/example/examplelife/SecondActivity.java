package com.example.examplelife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("key","Second Activity Created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("key","Second Activity Started");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("key","Second Activity Restarted");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("key","Second Activity Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("key","Second Activity Stoped");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("key","Second Activity Resumed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("key","Second Activity Destroyed");
    }
}