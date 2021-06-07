package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] images={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
        String[] itemNames={"Chicken Biryani","Chicken Lolipop","Egg fried Rice","Chicken 65","Mutton Curry","Mutton Biryani","Fish curry","Prawns curry","Veg Noodels","Chicken Noodels"};
        String[] itemprices={"200","250","100","350","400","350","250","250","100","150"};
        rv=findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(this));


    }
}