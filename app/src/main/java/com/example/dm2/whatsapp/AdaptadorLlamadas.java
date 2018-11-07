package com.example.dm2.whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorLlamadas extends ArrayAdapter<Llamadas> {

    private Llamadas[] datosllamada;

    public AdaptadorLlamadas(Context context, Llamadas[] datosllamada) {

        super(context, R.layout.listallamada, datosllamada);
        this.datosllamada=datosllamada;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listallamada, null);

        TextView llamante = (TextView)item.findViewById(R.id.nombrellamante);
        llamante.setText(datosllamada[position].getNombre());

        TextView duracion= (TextView)item.findViewById(R.id.duracion);
        duracion.setText(datosllamada[position].getUrl());

        ImageView estado = (ImageView) item.findViewById(R.id.estadollamada);
        estado.setImageDrawable(datosllamada[position].getImagen());
        return(item);
    }
}
