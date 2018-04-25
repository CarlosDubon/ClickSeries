package com.example.carlos.clickseries;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.ViewHolderSeriesAdapter>{

    ArrayList<Serie> serieList = new ArrayList<>();


    public SeriesAdapter( ArrayList<Serie> series){
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
    public void onBindViewHolder(@NonNull final ViewHolderSeriesAdapter holder, final int position) {
        holder.title.setText(serieList.get(position).getName());
        holder.desc.setText(serieList.get(position).getDescription());
        holder.imageSerie.setImageResource(serieList.get(position).getImage());

        if(serieList.get(position).isFavorite()){
            setTextViewDrawableColor(holder.fav,R.color.colorPrimary);
        }else{
            setTextViewDrawableColor(holder.fav,R.color.disableIcon);
        }

        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Serie serie = serieList.get(position);

               if (serie.isFavorite()){
                   setTextViewDrawableColor(holder.fav, R.color.disableIcon);
                   remove(position);
               }else{
                   setTextViewDrawableColor(holder.fav, R.color.colorPrimary);
                   agregar(position);
               }


            }
        });

    }

    @Override
    public int getItemCount() {
        return serieList.size();
    }

    private void setTextViewDrawableColor(TextView textView, int color) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(textView.getContext(), color), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public abstract void agregar(int index);
    public abstract void remove(int index);



}
