package com.example.dm2.whatsapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;

public class Llamadas extends AppCompatActivity {

    private String nombre;
    private String duracion;
    private Drawable imagen;

    public Llamadas(String nom, String dur, Drawable img){

        nombre=nom;
        this.duracion=dur;
        this.imagen=img;
    }

    public String getNombre() {
        return nombre;
    }
    public String getUrl() {
        return duracion;
    }
    public Drawable getImagen() {
        return imagen;
    }
}
