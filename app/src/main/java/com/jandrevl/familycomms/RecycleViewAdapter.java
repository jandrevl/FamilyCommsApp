package com.jandrevl.familycomms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<FamCommUser> famCommUserList;
    Context context;

    public RecycleViewAdapter(List<FamCommUser> famCommUserList, Context context) {
        this.famCommUserList = famCommUserList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemTextView.setText(famCommUserList.get(position).getUsername());

    }

    @Override
    public int getItemCount() {
        return famCommUserList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView itemTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.usernameTextView);
        }
    }
}
