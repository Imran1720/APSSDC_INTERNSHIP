package com.example.mysharedprefrences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mysharedprefrences.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        sp=getSharedPreferences("ap",MODE_PRIVATE);

    }

    public void showData(View view) {
        //Snackbar.make(view,binding.username.getText().toString()+binding.password.getText().toString(),Snackbar.LENGTH_SHORT).show();
        Toast.makeText(this, binding.username.getText().toString()+"\n"+binding.password.getText().toString(), Toast.LENGTH_SHORT).show();

        editor=sp.edit();
        editor.putString("username",binding.username.getText().toString());
        editor.putString("password",binding.password.getText().toString());
        editor.commit();
    }

    @Override
    protected void onPause() {

        super.onPause();
        editor=sp.edit();
        editor.putString("username",binding.username.getText().toString());
        editor.putString("password",binding.password.getText().toString());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String myname=sp.getString("username",null);
        String mypassword=sp.getString("password",null);
        binding.username.setText(myname);
        binding.password.setText(mypassword);
    }
}