package com.example.recyclerviewtest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.MyViewHolder> {

    Context ct;
    int[] myImages;
    String[] myNames,myPrices;
    MyInterface myinterface;

    public itemAdapter(MainActivity mainActivity, int[] images, String[] itemNames, String[] price,MyInterface myinterface) {
        ct = mainActivity;
        myImages = images;
        myNames = itemNames;
        myPrices = price;
        this.myinterface = myinterface;
    }

    public interface MyInterface{
        void selectedItems(String itemname,String itemprice,int position,int totalprice);

    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public itemAdapter.MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ct).inflate(R.layout.item_row,parent,false);
        MyViewHolder holder=new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull itemAdapter.MyViewHolder holder, int position) {
        holder.iv.setImageResource(myImages[position]);
        holder.tv1.setText(myNames[position]);
        holder.tv2.setText(myPrices[position]);
//        holder.button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String num = holder.button.getNumber();
//                Toast.makeText(ct, ""+num, Toast.LENGTH_SHORT).show();
//            }
//        });
        holder.button.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                Log.i("sss",String.valueOf(oldValue));
                Log.i("sss",String.valueOf(newValue));
               // Toast.makeText(ct, ""+newValue+" "+oldValue, Toast.LENGTH_SHORT).show();
                String itemName = holder.tv1.getText().toString();
                int itemprice = Integer.parseInt(holder.tv2.getText().toString());
                int totalprice = itemprice*newValue;
                myinterface.selectedItems(itemName,String.valueOf(itemprice),position,totalprice);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myImages.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1,tv2;
        ElegantNumberButton  button;
        public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {

            super(itemView);

            iv = itemView.findViewById(R.id.itemimage);
            tv1=itemView.findViewById(R.id.itemname);
            tv2=itemView.findViewById(R.id.itemprice);
            button=itemView.findViewById(R.id.number_button);
        }
    }
}
