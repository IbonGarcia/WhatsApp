package com.example.dm2.whatsapp;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    private ListView listachat;
    private ListView listacontacto;
    private ListView listallamada;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AQUI DEFINIMOS LAS PESTAÑAS Y SU CONTENIDO

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Resources res = getResources();
        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec=tabs.newTabSpec("Llamadas");
        spec.setContent(R.id.tab1);
        spec.setIndicator("LLAMADAS",
                res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("CHATS");
        spec.setContent(R.id.tab2);
        spec.setIndicator("CHATS",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("CONTACTOS");
        spec.setContent(R.id.tab3);
        spec.setIndicator("CONTACTOS",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        tabs.setCurrentTab(1);

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @SuppressLint("RestrictedApi")
            public void onTabChanged(String tabId) {

                ActionMenuItemView icono=findViewById(R.id.otros);
                if (tabId.equalsIgnoreCase("Llamadas")){

                    icono.setIcon(getDrawable(R.mipmap.ic_call));
                    return;
                }
                if(tabId.equalsIgnoreCase("CHATS")){
                    icono.setIcon(getDrawable(R.mipmap.ic_chat));
                    return;
                }
                if(tabId.equalsIgnoreCase("CONTACTOS")){
                    icono.setIcon(getDrawable(R.mipmap.ic_contact));
                    return;
                }
            }
        });

        // ESTO ES PARA RELLENAR LAS LISTAS
        //LISTA DE LAS LLAMADAS
        listallamada=(ListView)findViewById(R.id.lista_llamadas);
        final Llamadas[] llamadas= new Llamadas[]{new Llamadas("Aita","0:0",getDrawable(R.mipmap.ic_perdida)),
                new Llamadas("Anaitz","10:27",getDrawable(R.mipmap.ic_llamada)),
                new Llamadas("Tia Blanca","0:0",getDrawable(R.mipmap.ic_perdida)),
                new Llamadas("Julen","6:13",getDrawable(R.mipmap.ic_llamada)),
                new Llamadas("Trabajo","2:02",getDrawable(R.mipmap.ic_llamada))};
        AdaptadorLlamadas adaptadorcall= new AdaptadorLlamadas(this,llamadas);
        listallamada.setAdapter(adaptadorcall);

        // LISTA DE LOS CHATS
        listachat=(ListView)findViewById(R.id.lista_chat);
        final Chats[] chats= new Chats[]{new Chats("Unai","has echo el ejercicio 4?",getDrawable(R.mipmap.ic_contacto)),
                new Chats("Goio","menuda notaza he sacado en pros",getDrawable(R.mipmap.ic_contacto)),
                new Chats("Marck","jajaja ya te digo",getDrawable(R.mipmap.ic_contacto)),
                new Chats("Hector","agur! buenas noches",getDrawable(R.mipmap.ic_contacto))};
        AdaptadorChats adaptadorchat= new AdaptadorChats(this,chats);
        listachat.setAdapter(adaptadorchat);

        // LISTA DE LOS CONTACTOS
        listacontacto=(ListView)findViewById(R.id.lista_contacto);
        final Contactos[] contactos= new Contactos[]{new Contactos("Aa Ama","Siempre de vacaciones",getDrawable(R.mipmap.ic_contacto)),
                new Contactos("Ainhoa","Lo esencial es invisible a los ojos",getDrawable(R.mipmap.ic_contacto)),
                new Contactos("Carlos","Impetu temore libertus",getDrawable(R.mipmap.ic_contacto)),
                new Contactos("Endika","Quien mucho habla, mucho yerra",getDrawable(R.mipmap.ic_contacto))};
        AdaptadorContactos adaptador= new AdaptadorContactos(this,contactos);
        listacontacto.setAdapter(adaptador);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
