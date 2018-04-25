package com.example.carlos.clickseries;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentSerie extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private SeriesAdapter seriesAdapter;

    public FragmentSerie() {
    }

    public static FragmentSerie newInstance(SeriesAdapter seriesAdapter){
        FragmentSerie fragmentSerie = new FragmentSerie();
        fragmentSerie.setSeriesAdapter(seriesAdapter);
        return fragmentSerie;
    }

    public void setSeriesAdapter(SeriesAdapter seriesAdapter) {
        this.seriesAdapter = seriesAdapter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recycleview_series,container,false);
        recyclerView = view.findViewById(R.id.recycleview_series);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(seriesAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
