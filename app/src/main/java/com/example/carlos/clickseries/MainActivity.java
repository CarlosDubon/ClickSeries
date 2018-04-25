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
    private ArrayList<Serie> serieList = new ArrayList<>();
    private ArrayList<Serie> seriesFav =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


        addSeries();
        pagerAdapter.addFragments(new FragmentSerie(serieList), "");
        pagerAdapter.addFragments(new FragmentSerieFav(seriesFav), "");

        viewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(viewPager);



        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_hd_black_24dp);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_favorite);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }

    public void addSeries(){
        serieList.add(new Serie("Friends", "En 1994, de manos de los creadores David Crane ('Episodes', 'The Class', 'Sigue soñando', 'Joey') y Marta Kauffman ('El secreto de Verónica', 'Sigue soñando', 'Joey') llegó la 'sitcom' por antonomasia. La longeva 'Friends' nos presenta las vidas, amoríos y disparatadas historias de un grupo de seis jóvenes que viven en Manhattan.", "120", R.drawable.friends, true));
        serieList.add(new Serie("Breaking Bad", "Walter White (Bryan Cranston) es un frustrado profesor de química en un instituto, padre de un joven discapacitado y con una mujer (Anna Gunn) embarazada. Walt, además, trabaja en un lavadero de coches por las tardes.", "120", R.drawable.breaking_bad, false));
        serieList.add(new Serie("American Horror Story", "es una serie de televisión de drama y horror creada y producida por Ryan Murphy (Glee) y Brad Falchuk (Nip/Tuck). Se ha descrito como una serie antológica, ya que cada temporada se realiza como una miniserie independiente, con un grupo de personajes diferentes, escenarios distintos y una trama que tiene su propio comienzo, desarrollo y final.", "13", R.drawable.horror_story, false));
        serieList.add(new Serie("Mazinkaiser", "Mazinkaiser no puede volar por sus propios medios. Cuando Koji es arrojado al Monte Fuji en reciente estado volcánico en el OVA, Jun y el equipo del Laboratorio Fotónico encuentra el Kaiser Scrander y lo envían a rescatar a Koji. El Kaiser Scrander puede adherirse al Mazinkaiser, dándole plenas capacidades de vuelo (además de funcionar como arma improvisada).", "8", R.drawable.mazinkaiser, false));
        serieList.add(new Serie("Friends", "En 1994, de manos de los creadores David Crane ('Episodes', 'The Class', 'Sigue soñando', 'Joey') y Marta Kauffman ('El secreto de Verónica', 'Sigue soñando', 'Joey') llegó la 'sitcom' por antonomasia. La longeva 'Friends' nos presenta las vidas, amoríos y disparatadas historias de un grupo de seis jóvenes que viven en Manhattan.", "120", R.drawable.friends, false));
        serieList.add(new Serie("Friends", "En 1994, de manos de los creadores David Crane ('Episodes', 'The Class', 'Sigue soñando', 'Joey') y Marta Kauffman ('El secreto de Verónica', 'Sigue soñando', 'Joey') llegó la 'sitcom' por antonomasia. La longeva 'Friends' nos presenta las vidas, amoríos y disparatadas historias de un grupo de seis jóvenes que viven en Manhattan.", "120", R.drawable.friends, false));
        serieList.add(new Serie("Friends", "En 1994, de manos de los creadores David Crane ('Episodes', 'The Class', 'Sigue soñando', 'Joey') y Marta Kauffman ('El secreto de Verónica', 'Sigue soñando', 'Joey') llegó la 'sitcom' por antonomasia. La longeva 'Friends' nos presenta las vidas, amoríos y disparatadas historias de un grupo de seis jóvenes que viven en Manhattan.", "120", R.drawable.friends, false));
        serieList.add(new Serie("Friends", "En 1994, de manos de los creadores David Crane ('Episodes', 'The Class', 'Sigue soñando', 'Joey') y Marta Kauffman ('El secreto de Verónica', 'Sigue soñando', 'Joey') llegó la 'sitcom' por antonomasia. La longeva 'Friends' nos presenta las vidas, amoríos y disparatadas historias de un grupo de seis jóvenes que viven en Manhattan.", "120", R.drawable.friends, false));
        serieList.add(new Serie("Friends", "En 1994, de manos de los creadores David Crane ('Episodes', 'The Class', 'Sigue soñando', 'Joey') y Marta Kauffman ('El secreto de Verónica', 'Sigue soñando', 'Joey') llegó la 'sitcom' por antonomasia. La longeva 'Friends' nos presenta las vidas, amoríos y disparatadas historias de un grupo de seis jóvenes que viven en Manhattan.", "120", R.drawable.friends, false));
        serieList.add(new Serie("Friends", "En 1994, de manos de los creadores David Crane ('Episodes', 'The Class', 'Sigue soñando', 'Joey') y Marta Kauffman ('El secreto de Verónica', 'Sigue soñando', 'Joey') llegó la 'sitcom' por antonomasia. La longeva 'Friends' nos presenta las vidas, amoríos y disparatadas historias de un grupo de seis jóvenes que viven en Manhattan.", "120", R.drawable.friends, false));
        serieList.add(new Serie("Friends", "En 1994, de manos de los creadores David Crane ('Episodes', 'The Class', 'Sigue soñando', 'Joey') y Marta Kauffman ('El secreto de Verónica', 'Sigue soñando', 'Joey') llegó la 'sitcom' por antonomasia. La longeva 'Friends' nos presenta las vidas, amoríos y disparatadas historias de un grupo de seis jóvenes que viven en Manhattan.", "120", R.drawable.friends, false));

    }

}


