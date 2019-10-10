 package com.murez.android.proyectofinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.transform.sax.TemplatesHandler;



public class Splash_Activity extends AppCompatActivity {


    private static final long SPLASH_SCREEN_DELAY = 2000;

    long PRUEBA=32;


    long startTime  ;
    long timeInterval ;




    Date FirstDate = new Date();
    long timeInMilliseconds = FirstDate.getTime();

    //String fDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(FirstDate);




    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_);


        timeInterval = SystemClock.elapsedRealtime() - startTime;


        //Senddata();


        SharedPreferences pref = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean FirstStart = pref.getBoolean("firstStart", true);


        if (FirstStart == true) {

            new Handler().postDelayed(new Runnable() {
                public void run() {

                    Intent intent = new Intent(Splash_Activity.this, Inicio.class);
                    startActivity(intent);

                    SharedPreferences pref = getSharedPreferences("prefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("firstStart", false);
                    editor.apply();


                  Senddata();


                    finish();


                }
            }, SPLASH_SCREEN_DELAY);

        }

        if (FirstStart != true) {
            new Handler().postDelayed(new Runnable() {
                public void run() {

                    Intent intent = new Intent(Splash_Activity.this, TabbedActivity.class);
                    startActivity(intent);


                    finish();

                }
            }, SPLASH_SCREEN_DELAY);

        }




    }


//------------------ ACÁ ESTÁ LA PARTE DE PARA ENVIAR EL VALOR DESDE EL SPLASH, HASTA EL FRAGMENT, PASANDO POR EL TABBED ------------------------

    void Senddata() {
        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        boolean senddata = pref.getBoolean("onstart", true);
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong("TimeNoSmoke", timeInMilliseconds);
        editor.apply();
    }


}

    //---------------------------------ACÁ ESTÁ LO QUE PASA EL VALOR AL TABBED ACTIVITY-------------------------------------
/*
v
    private void Enviar() {

        Intent i = new Intent(this, TabbedActivity.class);
        i.putExtra("datito", Long.toString(PRUEBA));
        startActivity(i);
    }

}
*/


/*
CheckAuxState();

       // Enviar();

    }
}



//---------------------------------ACÁ ESTÁ LO QUE PASA EL TIEMPO-------------------------------------------------------
private void CheckAuxState(){

    int hola = 2;
}
*/

//---------------------------------ACÁ ESTÁ LO QUE PASA EL TIEMPO-------------------------------------------------------

/*
    private void Gettime()
    {
        long CurrentTime =  System.currentTimeMillis();

    };
*/

