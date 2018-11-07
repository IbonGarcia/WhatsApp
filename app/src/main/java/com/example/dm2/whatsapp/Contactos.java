package com.example.dm2.whatsapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;

public class Contactos extends AppCompatActivity {

    private String nombre;
    private String estado;
    private Drawable imagen;

    public Contactos(String nom, String msg, Drawable img){

        nombre=nom;
        this.estado=msg;
        this.imagen=img;
    }

    public String getNombre() {
        return nombre;
    }
    public String getUrl() {
        return estado;
    }
    public Drawable getImagen() {
        return imagen;
    }
}