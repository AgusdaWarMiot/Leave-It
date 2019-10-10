package com.murez.android.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;



import java.sql.Time;
import java.util.TimerTask;

public class Estadistics extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistics);

        LeTiempe(); // Void donde seteamos el text view del tiempo

    }

//-----------------------------------------TXV TIEMPO---------------------------------------------

    private void LeTiempe(){

        Chronometer Chr_SinFumar = (Chronometer) findViewById(R.id.chr_NoSmoke);
        Chr_SinFumar.start(); // start a chronometer


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        String time1 = format.format(calendar.getTime());



        TextView holaaa = (TextView)findViewById(R.id.HOLAAA);
        holaaa.setText(time1);








    }



}




