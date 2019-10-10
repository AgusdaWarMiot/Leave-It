package com.murez.android.proyectofinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

//import com.google.firebase.auth.FirebaseAuth;


public class LogIn extends AppCompatActivity {

    EditText edtNombre, edtContraseña, edtEmail;
    Button btnCrearCuenta;

//    FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        edtNombre = findViewById(R.id.edtNombre);
        edtEmail = findViewById(R.id.edtEmail);
        edtContraseña = findViewById(R.id.edtContraseña);

        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);

    }

    private void register (String userName, String email, String password){

    }
}
