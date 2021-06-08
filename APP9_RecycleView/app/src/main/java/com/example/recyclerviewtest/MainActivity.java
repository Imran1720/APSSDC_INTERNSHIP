package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements itemAdapter.MyInterface {
    RecyclerView rv;
    int totalamount=0;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] images={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
        String[] itemNames={"Chicken Biryani","Chicken Lolipop","Egg fried Rice","Chicken 65","Mutton Curry","Mutton Biryani","Fish curry","Prawns curry","Veg Noodels","Chicken Noodels"};
        String[] price={"200","250","100","350","400","350","250","250","100","150"};
        rv=findViewById(R.id.recyclerview);
        button=findViewById(R.id.button);

        rv.setLayoutManager(new LinearLayoutManager(this));

        itemAdapter adapter=new itemAdapter(this,images,itemNames,price,this);
        rv.setAdapter(adapter);

    }

    public void submit(View view) {
    }

    @Override
    public void selectedItems(String itemname, String itemprice, int position, int totalprice) {
        totalamount+=Integer.parseInt(itemprice);
        Toast.makeText(this, ""+totalprice, Toast.LENGTH_SHORT).show();
        button.setText(String.valueOf(totalamount));
    }
}