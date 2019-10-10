package com.murez.android.proyectofinal;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dialog extends AppCompatDialogFragment {

    EditText edt_cambiarNombre;
    Button nombreDeUsuario;

    public SharedPreferences prefs;

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder  = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_name_user,null);

        builder.setView(view)
                .setTitle("¿Desea Cambiar Su Nombre De Usuario?")
                .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getContext(),"no paso nada jaja saludos",Toast.LENGTH_LONG).show();

                    }
                });

        edt_cambiarNombre = view.findViewById(R.id.edtCambiarUser);
        nombreDeUsuario = view.findViewById(R.id.nombre);

        return builder.create();

    }
}
