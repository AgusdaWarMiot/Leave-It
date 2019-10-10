package com.murez.android.proyectofinal;

import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.murez.android.proyectofinal.Fragments.Frag1;
import com.murez.android.proyectofinal.Fragments.Frag2;
import com.murez.android.proyectofinal.Fragments.Frag3;
import com.murez.android.proyectofinal.Fragments.Frag4;
import com.murez.android.proyectofinal.Fragments.Frag5;

import java.text.DecimalFormat;
import java.util.Date;


public class TabbedActivity extends AppCompatActivity {


    public long TimeNoSmoke;
    public long TimeActual;
    public long TimeFinal;
    public long TimeDias;
    public long TimeHoras;


    public Double AñosFumador;
    public Double FumadorPorDia;
    public Double CigarrillosPorAtado;
    public Double ValorPaquete;



    public Double DineroAhorrado;
    public Double CigarrillosEvitados;
    public Double VidaRecuperada;


    public String datito;
    public String datito2;
    public String datito3;
    public String datito4;



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */


    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


//--------------------------------ACA ESTA EL VALOR DEL SPLASH ACTIVITY---------------------------------


        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        TimeNoSmoke = pref.getLong("TimeNoSmoke", 89);

//----------------------ACA ESTAN LOS VALORES DE INCIO-------------------------------------------

        AñosFumador = Double.valueOf(pref.getString("YearsSmoke", ""));
        FumadorPorDia = Double.valueOf(pref.getString("SmokedPerDay", ""));
        CigarrillosPorAtado = Double.valueOf(pref.getString("CigarsPerBox", ""));
        ValorPaquete = Double.valueOf(pref.getString("ValuePerBox", ""));




        Date ActualDate = new Date();
        TimeActual = ActualDate.getTime();



        TimeFinal = TimeActual - TimeNoSmoke;

        TimeHoras = (((TimeFinal /1000) /60)/60);

        TimeDias = (((TimeFinal /1000) /60)/60)/24; //Tu tiempo en millis pasado a segundos, minutos y horas, y dias



        // String fDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(TimeFinal);

//-------------------------MATEMATICAS PARA LAS ESTADISTICAS------------------------


        DineroAhorrado = ((FumadorPorDia / CigarrillosPorAtado) * ValorPaquete) * (Double.valueOf(TimeHoras)/24); //se multiplica por time horas para que se actualice a cada hora

        CigarrillosEvitados =  FumadorPorDia * (Double.valueOf(TimeHoras)/24);

        VidaRecuperada = TimeDias / 5.9;



//-----------------------------CORTA LOS DECIMALES HASTA 2-----------------------------------------


        DecimalFormat formato1 = new DecimalFormat("#0.00");
        String DineroAhorradoFormatted  = formato1.format(DineroAhorrado);
        String CigarrillosEvitadosFormatted = formato1.format(CigarrillosEvitados);
        String VidaRecuperadaFormatted = formato1.format(VidaRecuperada);

//-----------------------ACA MANDAMOS AL FRAG------------------------

        datito = String.valueOf(TimeDias);

        datito2 = DineroAhorradoFormatted;

        datito3 = CigarrillosEvitadosFormatted;

        datito4 = VidaRecuperadaFormatted;



    }




//-----------------------------------------------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */

//-----------------------------ACA AGREGAMOS LOS FRAGMENTS---------------------------------

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            switch (position)
            {
                case 0:
                    Frag1 tab1 = new Frag1();
                    //fragment = new Frag1();
                    return tab1;
                //break;

                case 1:
                    Frag2 tab2 = new Frag2();
                    //fragment = new Frag2();
                    return tab2;
                //break;

                case 2:
                    Frag3 tab3 = new Frag3();
                    //fragment = new Frag3();
                    return tab3;
                //break;

                case 3:
                    Frag4 tab4 = new Frag4();
                    //fragment = new Frag4();
                    return tab4;
                //break;

                case 4:
                    Frag5 tab5 = new Frag5();
                    //fragment = new Frag5();
                    return tab5;
                //break;
                default:return null;
            }
            //return  fragment;

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }


    }
}