package com.murez.android.proyectofinal.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.murez.android.proyectofinal.R;
import com.murez.android.proyectofinal.TabbedActivity;

import static java.lang.Long.getLong;
import static java.lang.Long.valueOf;


public class Frag3 extends Fragment {


    private TabbedActivity activity;



    private TextView TxtTiempoActual, TxtDineroAhorrado, TxtCigarrillosEvitados, TxtVidaRecuperada;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag3_layout, container, false);


        TxtTiempoActual = v.findViewById(R.id.TxtCurrentTime);
        TxtDineroAhorrado = v.findViewById(R.id.DineroAhorrado);
        TxtCigarrillosEvitados = v.findViewById(R.id.txtCigarrillosEvitados);
        TxtVidaRecuperada = v.findViewById(R.id.txtVidaRecuperada);


//-----------CON ESTO TOMAMOS LOS VALORES DEL TABBED, PROVENIENTES DEL SPLASH ------------

        activity = (TabbedActivity) getActivity();
        TxtTiempoActual.setText(activity.datito + " Dias");

        TxtDineroAhorrado.setText("$"+activity.datito2);

        TxtCigarrillosEvitados.setText(activity.datito3);

        TxtVidaRecuperada.setText(activity.datito4 + "Dias");

        return v;

        //String TimeNoSmoke = v.getIntent().getStringExtra("TimeNoSmoke");
    }

}


//private void loadPreferencesTimeNoSmoke() {
//}
