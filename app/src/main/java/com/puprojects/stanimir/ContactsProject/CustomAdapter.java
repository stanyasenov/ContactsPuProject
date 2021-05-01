package com.puprojects.stanimir.ContactsProject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList phone_id, phone_name, phone_number, description;

    CustomAdapter(Activity activity, Context context, ArrayList phone_id, ArrayList phone_name, ArrayList phone_number,
                  ArrayList description){
        this.activity = activity;
        this.context = context;
        this.phone_id = phone_id;
        this.phone_name = phone_name;
        this.phone_number = phone_number;
        this.description = description;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.phone_id_txt.setText(String.valueOf(phone_id.get(position)));
        holder.phone_name_txt.setText(String.valueOf(phone_name.get(position)));
        holder.phone_number_txt.setText(String.valueOf(phone_number.get(position)));
        holder.description_txt.setText(String.valueOf(description.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(phone_id.get(position)));
                intent.putExtra("name", String.valueOf(phone_name.get(position)));
                intent.putExtra("number", String.valueOf(phone_number.get(position)));
                intent.putExtra("description", String.valueOf(description.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return phone_id.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView phone_id_txt, phone_name_txt, phone_number_txt, description_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            phone_id_txt = itemView.findViewById(R.id.phone_id_txt);
            phone_name_txt = itemView.findViewById(R.id.phone_name_txt);
            phone_number_txt = itemView.findViewById(R.id.phone_number_txt);
            description_txt = itemView.findViewById(R.id.phone_description_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }

    }

}
