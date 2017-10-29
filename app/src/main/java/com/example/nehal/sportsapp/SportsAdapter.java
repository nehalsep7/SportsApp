package com.example.nehal.sportsapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nehal.sportsapp.Models.Hit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nehal on 29/10/17.
 */

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.MyViewHolder> {

    private List<Hit> list = new ArrayList<>();

    public SportsAdapter(List<Hit> list) {
        this.list = list;
    }

    @Override
    public SportsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SportsAdapter.MyViewHolder holder, int position) {
        Hit hit = list.get(position);
        holder.title.setText(hit.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);

        }
    }
}
