package com.example.firedb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.HoldView> {
    Context ct;
    ArrayList<MyModel> list;

    public MyAdapter(Context ct, ArrayList<MyModel> list) {
        this.ct = ct;
        this.list = list;
    }

    @Override
    public HoldView onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new HoldView(LayoutInflater.from(ct).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.HoldView holder, int position) {
        Glide.with(ct).load(list.get(position).getUrl()).placeholder(R.drawable.ic_launcher_background).into(holder.iv);
        holder.name.setText(list.get(position).getName());
        holder.mail.setText(list.get(position).getMail());
        holder.number.setText(list.get(position).getPhone());
        holder.actype.setText(list.get(position).getActype());
        holder.state.setText(list.get(position).getState());
        holder.district.setText(list.get(position).getDistrict());
        holder.village.setText(list.get(position).getVillage());
        holder.house.setText(list.get(position).getHno());
        holder.colony.setText(list.get(position).getColony());
        holder.lmark.setText(list.get(position).getLmarl());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HoldView extends RecyclerView.ViewHolder {

        TextView name,mail,number,actype,state,district,village,house,colony,lmark;
        ImageView iv;
        public HoldView(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            mail = itemView.findViewById(R.id.mail);
            number = itemView.findViewById(R.id.number);
            actype = itemView.findViewById(R.id.actype);
            state = itemView.findViewById(R.id.state);
            district = itemView.findViewById(R.id.district);
            village = itemView.findViewById(R.id.village);
            house = itemView.findViewById(R.id.hno);
            colony = itemView.findViewById(R.id.colony);
            lmark = itemView.findViewById(R.id.lmark);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
