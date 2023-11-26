package com.example.instadamsubireste;

import static com.example.instadamsubireste.MainActivity.publicaciones;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.LinkedList;


public class AniadirFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aniadir, container, false);
        EditText inputTitulo = view.findViewById(R.id.editTextTitulo);
        EditText inputUbicacion = view.findViewById(R.id.editTextUbicacion);
        EditText inputDescripcion = view.findViewById(R.id.editTextDescripcion);
        EditText inputImagen = view.findViewById(R.id.editTextImagen);
        Button buttonPublicar = view.findViewById(R.id.buttonPublicar);
        buttonPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tituloPublicacion = String.valueOf(inputTitulo.getText());
                String ubicacionPublicacion = String.valueOf(inputUbicacion.getText());
                String descripcionPublicacion = String.valueOf(inputDescripcion.getText());
                String nombreImagen = String.valueOf(inputImagen.getText());
                int id = publicaciones.size()+2;
                Toast notificacion = Toast.makeText(getContext(),"Se ha añadido una publicación nueva", Toast.LENGTH_LONG);

                publicaciones.addFirst(new Publicacion(id,tituloPublicacion,ubicacionPublicacion,descripcionPublicacion,nombreImagen));
                notificacion.show();
            }
        });
        return  view;
    }
}