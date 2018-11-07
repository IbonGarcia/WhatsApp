package com.example.dm2.whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorChats extends ArrayAdapter<Chats> {

    private Chats[] datos;

    public AdaptadorChats(Context context, Chats[] datos) {

        super(context, R.layout.listachat, datos);
        this.datos=datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        View item = inflater.inflate(R.layout.listachat, null);
        TextView nombre = (TextView)item.findViewById(R.id.nombrecontacto);
        nombre.setText(datos[position].getNombre());

        TextView mensaje = (TextView)item.findViewById(R.id.mensaje);
        mensaje.setText(datos[position].getUrl());

        ImageView imagen = (ImageView) item.findViewById(R.id.fotocontacto);
        imagen.setImageDrawable(datos[position].getImagen());
        return(item);
    }
}
