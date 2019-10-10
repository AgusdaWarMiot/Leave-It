package com.murez.android.proyectofinal.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.murez.android.proyectofinal.R;
import com.murez.android.proyectofinal.TabbedActivity;
import com.murez.android.proyectofinal.muro.AdapterMensajes;
import com.murez.android.proyectofinal.muro.Mensaje;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;


import javax.annotation.Nullable;

import static android.app.Activity.RESULT_OK;

public class Frag2 extends Fragment {

    private ImageView fotoPerfil;
    private TextView nombre;
    private RecyclerView rvMensaje;
    private EditText edtMensaje;
    private Button btnEnviar;
    private ImageButton btnEnviarFoto;

    private TabbedActivity activity;

    private AdapterMensajes adapter;
    private List<Mensaje> listMensaje;


    private static final int CANT_MSG = 20;



    private static final int PHOTO_SEND = 1;
    private static final int PHOTO_PERFIL = 2;

   // private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public Frag2() {
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag2_layout, container, false);


//----------------------HORA MENSAJE-----------------------------

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        final Date HoraMensaje = Calendar.getInstance().getTime();

        final String strHora = dateFormat.format(HoraMensaje);


//----------------------Relaciono las cositas--------------------------------------------

        activity = (TabbedActivity) getActivity();

        fotoPerfil = v.findViewById(R.id.fotoPerfil);
        nombre = v.findViewById(R.id.nombre);
        rvMensaje = v.findViewById(R.id.rvMensajes);
        edtMensaje = v.findViewById(R.id.edtMensaje);
        btnEnviar = v.findViewById(R.id.btnEnviar);
        btnEnviarFoto = v.findViewById(R.id.btnEnviarFoto);


//-------------------------LIST---------------------------------------

        listMensaje = new ArrayList<>();

//-------------------------Adapter----------------------------------------------------------

        adapter = new AdapterMensajes(listMensaje);

        LinearLayoutManager i = new LinearLayoutManager(activity);
        i.setReverseLayout(false); //pone los mensajes arriba
        i.setStackFromEnd(true);
        rvMensaje.setLayoutManager(i);
        rvMensaje.setAdapter(adapter);
        rvMensaje.setHasFixedSize(true);


//---------------------------------firestore------------------------------------------

        FirebaseFirestore.getInstance().collection("Chat")
                .orderBy("hora", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        for (DocumentChange documentChange : queryDocumentSnapshots.getDocumentChanges()) {
                            if (documentChange.getType() == DocumentChange.Type.ADDED) {
                                listMensaje.add(documentChange.getDocument().toObject(Mensaje.class));
                                adapter.notifyDataSetChanged();
                                rvMensaje.smoothScrollToPosition(listMensaje.size());
                            }
                        }

                    }
                });

//-------------------------------ENVIAR MENSAJES-------------------------------------------------

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (edtMensaje.length() == 0)
                    return;

                Mensaje msj = new Mensaje(edtMensaje.getText().toString(), nombre.getText().toString(), "", "1", getCurrentTimeStamp());

                FirebaseFirestore.getInstance().collection("Chat").add(msj);

                edtMensaje.setText("");

            }
        });


//-------------------------------------------ENVIAR FOTO--------------------------------------------------------------------


        btnEnviarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/jpg");
                i.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                startActivityForResult(Intent.createChooser(i,"Selecciona una foto"),PHOTO_SEND);

            }
        });





//-----------------------CAMBIAR FOTO DE PERFIL----------------------------------------------------------------------------------------
        fotoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/jpg");
                i.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                startActivityForResult(Intent.createChooser(i,"Selecciona una foto"),PHOTO_PERFIL);

            }
        });

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                rvMensaje.scrollToPosition(adapter.getItemCount()-1);                   //pa que el mensaje vaya bajando

            }
        });








        return v;
    }

    String getCurrentTimeStamp(){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.format(new Date());
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
