package com.example.carlos.clickseries;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.ViewHolderSeriesAdapter>{

    private ArrayList<Serie> serieList = new ArrayList<>();

    public SeriesAdapter(ArrayList series){
        serieList = series;
    }

    public static class ViewHolderSeriesAdapter extends RecyclerView.ViewHolder{
        ImageView imageSerie;
        CardView card;
        TextView title;
        TextView desc;
        TextView fav;

        public ViewHolderSeriesAdapter(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cardview);
            title = itemView.findViewById(R.id.text_title);
            desc = itemView.findViewById(R.id.text_description);
            fav = itemView.findViewById(R.id.text_fav);
            imageSerie = itemView.findViewById(R.id.img_serie);
        }
    }

    @NonNull
    @Override
    public ViewHolderSeriesAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_series,parent,false);
        return new ViewHolderSeriesAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSeriesAdapter holder, int position) {
        holder.title.setText(serieList.get(position).getName());
        holder.desc.setText(serieList.get(position).getDescription());
        holder.imageSerie.setImageResource(serieList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return serieList.size();
    }


}
