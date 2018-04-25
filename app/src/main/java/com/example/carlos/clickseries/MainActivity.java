package com.example.carlos.clickseries;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Serie> series = new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        recyclerView = findViewById(R.id.recycleview_series);

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(viewPager);

        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_hd_black_24dp);
        //mTabLayout.getTabAt(1).setIcon(R.drawable.ic_favorite);

        SeriesAdapter seriesAdapter = new SeriesAdapter(series);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(seriesAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }
}
