package com.murez.android.proyectofinal.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.murez.android.proyectofinal.R;
import com.murez.android.proyectofinal.TabbedActivity;

import java.util.Timer;

import static android.content.Context.MODE_PRIVATE;

public class Frag1 extends Fragment {


    private TabbedActivity activity;
    private TextView tapcount, eggcount;
    private ImageButton tapbut;
    private int counter;
    private int realeggcount = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag1_layout, container, false);


        eggcount = v.findViewById(R.id.eggcount);
        tapcount = v.findViewById(R.id.tapcount);

        tapbut = v.findViewById(R.id.tapbut);

        activity = (TabbedActivity) getActivity();


        SharedPreferences egg = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);



        String tuvi = egg.getString("Taps", "0");
        String tuma = egg.getString("Eggsbroken", "0");


        counter = Integer.parseInt(tuvi);
        realeggcount = Integer.parseInt(tuma);


        tapbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter + 1;

                tapcount.setText(String.valueOf(counter));

                eggcount.setText(String.valueOf(realeggcount));




                if (counter == 100)
                {
                    tapbut.setImageResource(R.drawable.tapimage2);
                }

                if (counter == 200)
                {
                    tapbut.setImageResource(R.drawable.tapimage3);
                }

                if (counter == 300)
                {
                    tapbut.setImageResource(R.drawable.tapimage4);
                }

                if (counter == 400)
                {
                    tapbut.setImageResource(R.drawable.tapimage5);
                }

                if (counter == 500)
                {
                    tapbut.setImageResource(R.drawable.tapimage6);
                }

                if (counter == 600)
                {
                    tapbut.setImageResource(R.drawable.tapimage7);
                }

                if (counter == 700)
                {
                    tapbut.setImageResource(R.drawable.tapimage8);
                }

                if (counter == 800)
                {
                    tapbut.setImageResource(R.drawable.tapimage9);
                }

                if (counter == 900)
                {
                    tapbut.setImageResource(R.drawable.tapimage10);
                }

                if (counter == 1000)
                {

                    tapbut.setImageResource(R.drawable.tapimage);
                    realeggcount = realeggcount + 1;
                    counter = 0;
                }


            }

        });


        SharedPreferences.Editor editor = egg.edit();
        editor.putString("Taps",String.valueOf(counter));
        editor.putString("Eggsbroken", String.valueOf(realeggcount));
        editor.apply();


        return(v);
    }

}
