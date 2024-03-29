package com.murez.android.proyectofinal.muro;

import java.util.Date;

public class Mensaje {

    private String mensaje;
    private String nombre;
    private String urlFoto;
    private String fotoPerfil;
    private String type_Mensaje;
    private String hora;


    public Mensaje() {
    }

    public Mensaje(String mensaje, String nombre, String fotoPerfil, String type_Mensaje, String hora) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.fotoPerfil = fotoPerfil;
        this.type_Mensaje = type_Mensaje;
        this.hora = hora;
    }

    public Mensaje(String mensaje, String nombre, String urlFoto, String fotoPerfil, String type_Mensaje, String hora) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.fotoPerfil = fotoPerfil;
        this.type_Mensaje = type_Mensaje;
        this.hora = hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getType_Mensaje() {
        return type_Mensaje;
    }

    public void setType_Mensaje(String type_Mensaje) {
        this.type_Mensaje = type_Mensaje;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
