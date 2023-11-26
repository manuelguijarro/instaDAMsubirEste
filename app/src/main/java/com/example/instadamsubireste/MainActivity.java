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
    public boolean  activarCancion(Boolean estadoCancion){
        if(estadoCancion){
            myMediaPlayer.stop();
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
        myMediaPlayer = MediaPlayer.create(this, R.raw.qyevedo);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,fragment).commit();
        usuarios.add(new Usuario(0,"Manuel Guijarro Sánchez","manu2506.1994@gmail.com"));
        usuarios.add(new Usuario(1,"Francisco Javier Casado Asensio","fjpaco.asens@gmail.com"));
        usuarios.add(new Usuario(2,"Alex Muñoz Sánchez","jonnywalker@gmail.com"));
        floatingActionButton = findViewById(R.id.floatingActionButton2);
        estadoCancion = false;
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estadoCancion = activarCancion(estadoCancion);
            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inferior, menu);
        return true;
    }
}