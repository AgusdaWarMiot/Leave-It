package com.murez.android.proyectofinal.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.murez.android.proyectofinal.R;
import com.murez.android.proyectofinal.TabbedActivity;

public class Frag5 extends Fragment {
    private TabbedActivity activity;
    private ImageView unDia,tresDias,unaSemana,unMes,seisMeses,unAño;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag5_layout, container, false);

        Drawable Tick = getResources().getDrawable(R.drawable.tick);

        unDia = v.findViewById(R.id.unDia);
        tresDias = v.findViewById(R.id.tresDias);
        unaSemana = v.findViewById(R.id.unaSemana);
        unMes = v.findViewById(R.id.unMes);
        seisMeses = v.findViewById(R.id.seisMeses);
        unAño = v.findViewById(R.id.unAño);

        int auxdias = 0;
        try{
            activity = (TabbedActivity) getActivity();
            String Dias = activity.datito;
            auxdias = Integer.parseInt(Dias);
        }
        catch(Exception e)
        {
        }


        if (auxdias >= 1)
        {
            unDia.setImageDrawable(Tick); //verde
        }

        if (auxdias >= 3)
        {
            tresDias.setImageDrawable(Tick); //verde
        }

        if (auxdias >= 7)
        {
            unaSemana.setImageDrawable(Tick); //verde
        }

        if (auxdias >= 31)
        {
            unMes.setImageDrawable(Tick); //verde
        }
        if (auxdias >= 182)
        {
            seisMeses.setImageDrawable(Tick); //verde
        }
        if (auxdias >= 365)
        {
            unAño.setImageDrawable(Tick); //verde
        }
        return v;

    }
}
