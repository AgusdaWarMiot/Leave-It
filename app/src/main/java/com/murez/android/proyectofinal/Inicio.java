package com.murez.android.proyectofinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;




public class Inicio extends Estadistics {


// VARIABLES DE ESTADISTICAS

    private String AñosFumador;
    private String FumadorPorDia;
    private String CigarrillosPorAtado;
    private String ValorPaquete;


//ESTO ES PARA CONFIGURAR QUE AL PRESIONAR EL BOTON SE CAMBIE DE ACTIVITY

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


//GUARDA LAS VARIABLES DE ESTADISTICAS AL TOCAS EL BOTON SAVE <-- IMPORTANTE


        Button guardarTodo = findViewById(R.id.saveAll);
        guardarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final EditText Años = findViewById(R.id.Years);
                AñosFumador = Años.getText().toString();

                final EditText CigarrillosPorDia = findViewById(R.id.CigarsPerDay);
                FumadorPorDia = CigarrillosPorDia.getText().toString();

                final EditText CigarrillosPorPaquete = findViewById(R.id.CigarsPerPack);
                CigarrillosPorAtado = CigarrillosPorPaquete.getText().toString();

                final EditText PrecioDelPaquete = findViewById(R.id.PackPrice);
                ValorPaquete = PrecioDelPaquete.getText().toString();


                if (FumadorPorDia.equals("") || AñosFumador.equals("")||CigarrillosPorAtado.equals("")||ValorPaquete.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Complete todos los datos antes de continuar",Toast.LENGTH_LONG).show();

                }
                else
                    {


                    Senddata();

                    startActivity(new Intent(Inicio.this, TabbedActivity.class));


                }

            }
        });


    }


    //ACA SE CONFIGURÓ EL BOTON



//------------------ ACÁ ESTÁ LA PARTE DE PARA ENVIAR EL VALOR DESDE EL SPLASH, HASTA EL FRAGMENT, PASANDO POR EL TABBED ------------------------

    void Senddata() {
        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        boolean senddata = pref.getBoolean("onstart", true);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("YearsSmoke", AñosFumador);
        editor.putString("SmokedPerDay",FumadorPorDia);
        editor.putString("CigarsPerBox",CigarrillosPorAtado);
        editor.putString("ValuePerBox",ValorPaquete);
        editor.apply();
    }
}