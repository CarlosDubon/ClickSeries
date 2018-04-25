package com.example.carlos.clickseries;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentSerieFav extends Fragment{

        View view;
        private RecyclerView recyclerView;
        private ArrayList<Serie> serieList;
        private SeriesAdapter seriesAdapter;

        public FragmentSerieFav(ArrayList serieList, SeriesAdapter seriesAdapter) {
            this.serieList=serieList;
            this.seriesAdapter=seriesAdapter;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.recyclaview_series_fav,container,false);
            recyclerView = view.findViewById(R.id.recycleview_series_fav);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(seriesAdapter);
            return view;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
}


