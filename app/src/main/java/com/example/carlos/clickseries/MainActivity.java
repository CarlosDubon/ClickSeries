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
    private SeriesAdapter adapter_default;
    private SeriesAdapter adapter_fav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter_default = new SeriesAdapter(serieList) {
            @Override
            public void agregar(int index) {
                serieList.get(index).setFavorite(true);
                seriesFav.add(serieList.get(index));
                notifyDataSetChanged();
                notifyItemInserted(index);
                int pos = seriesFav.indexOf(serieList.get(index));
                adapter_fav.notifyItemInserted(pos);
            }

            @Override
            public void remove(int index) {
                int pos = seriesFav.indexOf(serieList.get(index));
                serieList.get(index).setFavorite(false);
                seriesFav.remove(serieList.get(index));
                notifyDataSetChanged();
                adapter_fav.notifyItemRemoved(index);
                adapter_fav.notifyItemRangeChanged(pos, seriesFav.size());

            }
        };

        adapter_fav = new SeriesAdapter(seriesFav) {
            @Override
            public void agregar(int index) {}

            @Override
            public void remove(int index) {
                int pos = serieList.indexOf(seriesFav.get(index));
                serieList.get(pos).setFavorite(false);
                seriesFav.remove(index);
                notifyItemRemoved(index);
                notifyItemRangeChanged(index, seriesFav.size());
                adapter_default.notifyDataSetChanged();
            }
        };

        addSeries();
        pagerAdapter.addFragments(FragmentSerie.newInstance(adapter_default), "");
        pagerAdapter.addFragments(FragmentSerieFav.newInstance(adapter_fav), "");

        viewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(viewPager);



        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_hd_black_24dp);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_favorite);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }

    public void addSeries(){
        serieList.add(new Serie("Friends", "En 1994, de manos de los creadores David Crane ('Episodes', 'The Class', 'Sigue soñando', 'Joey') y Marta Kauffman ('El secreto de Verónica', 'Sigue soñando', 'Joey') llegó la 'sitcom' por antonomasia. La longeva 'Friends' nos presenta las vidas, amoríos y disparatadas historias de un grupo de seis jóvenes que viven en Manhattan.", "120", R.drawable.friends, false));
        serieList.add(new Serie("Breaking Bad", "Walter White (Bryan Cranston) es un frustrado profesor de química en un instituto, padre de un joven discapacitado y con una mujer (Anna Gunn) embarazada. Walt, además, trabaja en un lavadero de coches por las tardes.", "120", R.drawable.breaking_bad, false));
        serieList.add(new Serie("American Horror Story", "es una serie de televisión de drama y horror creada y producida por Ryan Murphy (Glee) y Brad Falchuk (Nip/Tuck). Se ha descrito como una serie antológica, ya que cada temporada se realiza como una miniserie independiente, con un grupo de personajes diferentes, escenarios distintos y una trama que tiene su propio comienzo, desarrollo y final.", "13", R.drawable.horror_story, false));
        serieList.add(new Serie("Mazinkaiser", "Mazinkaiser no puede volar por sus propios medios. Cuando Koji es arrojado al Monte Fuji en reciente estado volcánico en el OVA, Jun y el equipo del Laboratorio Fotónico encuentra el Kaiser Scrander y lo envían a rescatar a Koji. El Kaiser Scrander puede adherirse al Mazinkaiser, dándole plenas capacidades de vuelo (además de funcionar como arma improvisada).", "8", R.drawable.mazinkaiser, false));
        serieList.add(new Serie("Simpsons", "Los Simpsons es una comedia americana de animación creada por Matt Groening para la compañía Fox. La serie es una parodia satírica del estilo de la clase media americana encarnada por una familia con ese mismo nombre, compuesta por Homer, Marge, Bart, Lisa, y Maggie Simpson. La serie se ubica en la ciudad ficticia de Springfield y parodia la cultura, ", "120", R.drawable.simpson, false));
        serieList.add(new Serie("KNIGHTFALL", "Los Templarios dedicaron su vida a cuidar del Santo Grial. Knightfall es un drama histórico que recrea las cruzadas y la vida de esta hermandad, una mirada a los últimos días de los Caballeros Templarios durante el siglo XIV.", "120", R.drawable.knightfall, false));
        serieList.add(new Serie("Long Road Home", "es una miniserie para Nat Geo que relata los sucesos bélicos que se inician el 4 de abril de 2004, cuando un grupo de soldados estadounidenses sufre una emboscada en Sadr City, Bagdad. 48 horas dura esta celada agonizante que más tarde recibe el nombre de ‘Domingo Negro' como un episodio más de la Guerra de Irak. Las armas, los deshechos, la falta de civilización y los restos olvidados se juntan en este drama basado en hechos reales. El drama militar es una producción de Phoenix Pictures dirigida por Phil Abraham y Mikael Salomon. ", "120", R.drawable.serie, false));
    }

}


