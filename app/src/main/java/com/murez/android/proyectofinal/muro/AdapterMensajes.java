package com.murez.android.proyectofinal.muro;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.murez.android.proyectofinal.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterMensajes extends RecyclerView.Adapter<AdapterMensajes.MensajeHolder> {

    private List<Mensaje> listMensaje;



    public AdapterMensajes(List<Mensaje> listMensaje) {
        this.listMensaje = listMensaje;
    }

    @NonNull
    @Override
    public MensajeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_mensajes,viewGroup,false);
        return new MensajeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MensajeHolder mensajeHolder, int position) {


        mensajeHolder.mensaje.setText(listMensaje.get(position).getMensaje());
        mensajeHolder.nombre.setText(listMensaje.get(position).getNombre());
        mensajeHolder.hora.setText(listMensaje.get(position).getHora());



    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }

    class MensajeHolder extends RecyclerView.ViewHolder {


        private TextView nombre, mensaje, hora;
        private ImageView fotoMensaje;


        public MensajeHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.nombreMensaje);
            mensaje = itemView.findViewById(R.id.mensajeMensaje);
            hora = itemView.findViewById(R.id.horaMensaje);
            fotoMensaje = itemView.findViewById(R.id.fotoPerfilMensaje);




        }
    }

}







/*
    private List<Mensaje> listMensaje = new ArrayList<>();
    private android.content.Context c;


    public AdapterMensajes(Context c) {
        this.c = c;
    }

    public void addMensaje(Mensaje m){
        listMensaje.add(m);
        notifyItemInserted(listMensaje.size());

    }



    @Override
    public HolderMensaje onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes,parent,false);
        return new HolderMensaje(v);
    }

    @Override
    public void onBindViewHolder(HolderMensaje holder, int position) {

        holder.getNombre().setText(listMensaje.get(position).getNombre());
        holder.getMensaje().setText(listMensaje.get(position).getMensaje());
        holder.getHora().setText(listMensaje.get(position).getHora());

    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }
}
*/