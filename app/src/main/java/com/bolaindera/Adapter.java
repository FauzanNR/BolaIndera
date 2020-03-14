package com.bolaindera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ListViewHolder>{
    List<TeamsItem> listBola;

    Context context;
    public void setListBola(List<TeamsItem> listBola) {
        this.listBola = listBola;
        notifyDataSetChanged();
    }

    Activity activity;

    public Adapter(Activity activity) {
        this.activity = activity;
        listBola = new ArrayList<>();
    }

    @NonNull
    @Override
    public Adapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Adapter.ListViewHolder holder, int position) {

        final TeamsItem teamsItem = listBola.get(position);

        Glide.with(holder.itemView.getContext())
                .load(teamsItem.getStrTeamLogo())
                .apply(new RequestOptions())
                .into(holder.imgLogo);
        holder.tvName.setText(teamsItem.getStrTeam());
        holder.tvDescription.setText(teamsItem.getStrDescriptionEN());
        holder.tvLiga.setText(teamsItem.getStrLeague());
        holder.tvStadion.setText(teamsItem.getStrStadium());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("logo",teamsItem.getStrTeamLogo() );
                intent.putExtra("nama",teamsItem.getStrTeam() );
                intent.putExtra("deskripsi",teamsItem.getStrDescriptionEN() );
                intent.putExtra("liga",teamsItem.getStrLeague() );
                intent.putExtra("stadion",teamsItem.getStrStadium() );
                Toast.makeText(holder.itemView.getContext(), "Kamu Memilih " + listBola.get(holder.getAdapterPosition()).getStrTeam(),Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBola.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgLogo;
        TextView tvName,tvDescription, tvStadion,tvLiga;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            imgLogo = itemView.findViewById(R.id.img_logo);
            tvName = itemView.findViewById(R.id.tv_nama_tim);
            tvStadion = itemView.findViewById(R.id.tv_stadion1);
            tvLiga = itemView.findViewById(R.id.tv_liga1);
            tvDescription = itemView.findViewById(R.id.tv_deskripsi);
        }
    }
}
