package com.bolaindera;

import android.graphics.Movie;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Adapter extends RecyclerView.Adapter<Adapter.ListViewHolder>{

    @NonNull
    @Override
    public Adapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
