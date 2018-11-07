package com.example.dm2.whatsapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Chats extends AppCompatActivity {

    private String nombre;
    private String ultimomensaje;
    private Drawable imagen;

    public Chats(String nom, String msg, Drawable img){

        nombre=nom;
        this.ultimomensaje=msg;
        this.imagen=img;
    }

    public String getNombre() {
        return nombre;
    }
    public String getUrl() {
        return ultimomensaje;
    }
    public Drawable getImagen() {
        return imagen;
    }
}
