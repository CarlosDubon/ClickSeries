package com.example.carlos.clickseries;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {

    private ArrayList<Serie> series;


    public static class SeriesViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView textTitle;
        TextView textDesc;
        TextView textVer;
        TextView textFav;

        public SeriesViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            textTitle = itemView.findViewById(R.id.text_title);
            textDesc = itemView.findViewById(R.id.text_description);
            textVer = itemView.findViewById(R.id.text_ver);
            textFav = itemView.findViewById(R.id.text_fav);
        }
    }

    public SeriesAdapter(ArrayList<Serie> series){
        this.series = series;
    }

    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_series,parent,false);
        return (new SeriesViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return series.size();
    }


}
