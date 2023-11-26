package com.example.instadamsubireste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;
    private FragmentContainerView fragmentContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.menu_inferior);
        fragmentContainerView = findViewById(R.id.fragmentContainerView);
        fragment = new PublicacionFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,fragment).commit();

       bottomNavigationView.setOnItemSelectedListener(item -> {
            int idItem = item.getItemId();
            if(idItem == R.id.boton_inicio){
                 fragment = new PublicacionFragment();
            }
            if(idItem == R.id.boton_aniadir){
                 fragment = new AniadirFragment();
            }
            if(idItem == R.id.boton_buscar){
                //fragment = new InicioFragment();
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