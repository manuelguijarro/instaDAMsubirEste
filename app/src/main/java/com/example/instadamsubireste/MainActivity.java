package com.example.instadamsubireste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;
    private FragmentContainerView fragmentContainerView;
    public static LinkedList<Publicacion> publicaciones = new LinkedList<>();
    public static LinkedList<Usuario> usuarios = new LinkedList<>();
    private FloatingActionButton floatingActionButton;
    private Boolean estadoCancion;
    private MediaPlayer myMediaPlayer;
    /*
       Con esta funcion comprobamos si el estado de la cancion esta en funcionamiento o en cambio
       esta parada, y mediante la comprobacion, moficamos su estado y devolvemos el booleano, para cuando
       se vuelva a pulsar el boton
     */
    public boolean  activarCancion(Boolean estadoCancion){
        if(estadoCancion){
            myMediaPlayer.pause();
            estadoCancion = false;
        }else{
            myMediaPlayer.start();
            estadoCancion = true;
        }
        return estadoCancion;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.menu_inferior);
        fragmentContainerView = findViewById(R.id.fragmentContainerView);
        fragment = new PublicacionFragment();
        //MediaPlayer es la API principal para reproducir sonido y video que nos proporciona Android Studio.
        myMediaPlayer = MediaPlayer.create(this, R.raw.qyevedo);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,fragment).commit();
        estadoCancion = false;
        floatingActionButton = findViewById(R.id.floatingActionButton2);
        /*
        Con este metodo, al hacer click en el evento del boton flotante, llamamos a la funcion
        activarCancion y comprobamos el estado de la cancion, para realizar una funcion o otra.
         */
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estadoCancion = activarCancion(estadoCancion);
            }
        });
        //Con este boton controlamos los eventos al pulsar el menu inferior(para cargar Fragmentos)
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int idItem = item.getItemId();
            if(idItem == R.id.boton_inicio){
                 fragment = new PublicacionFragment();
            }
            if(idItem == R.id.boton_aniadir){
                 fragment = new AniadirFragment();
            }
            if(idItem == R.id.boton_buscar){
                fragment = new BuscarFragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,fragment).commit();

            return true;
        });
    }
    //Metodo necesario para poder inflar el menu_inferior
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inferior, menu);
        return true;
    }
}