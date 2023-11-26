package com.example.instadamsubireste;

import static com.example.instadamsubireste.MainActivity.publicaciones;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class AniadirFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aniadir, container, false);
        EditText inputAutor = view.findViewById(R.id.editTextTextAutor);
        EditText inputDescripcion = view.findViewById(R.id.editTextTextDescripcion);
        Button buttonPublicar = view.findViewById(R.id.buttonPublicar);
        buttonPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String autorPublicacion = String.valueOf(inputAutor.getText());
                String descripcionPublicacion = String.valueOf(inputDescripcion.getText());
                publicaciones.add(new Publicacion(autorPublicacion,descripcionPublicacion));
            }
        });
        return  view;
    }
}