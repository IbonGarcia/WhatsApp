package com.example.dm2.whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorContactos extends ArrayAdapter<Contactos> {

    private Contactos[] datos;

    public AdaptadorContactos(Context context, Contactos[] datos) {

        super(context, R.layout.listacontacto, datos);
        this.datos=datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listacontacto, null);

        TextView contacto = (TextView)item.findViewById(R.id.nombrecontacto);
        contacto.setText(datos[position].getNombre());

        TextView estado = (TextView)item.findViewById(R.id.estado);
        estado.setText(datos[position].getUrl());

        ImageView imagen = (ImageView) item.findViewById(R.id.fotocontacto);
        imagen.setImageDrawable(datos[position].getImagen());
        return(item);
    }
}

