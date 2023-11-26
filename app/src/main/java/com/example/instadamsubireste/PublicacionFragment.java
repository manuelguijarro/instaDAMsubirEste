package com.example.instadamsubireste;

import static com.example.instadamsubireste.MainActivity.publicaciones;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PublicacionFragment extends Fragment {

    //private static List<Publicacion> publicaciones = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_publicacion, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new PublicacionAdapter(publicaciones));
        // Agrega algunas publicaciones de ejemplo
        //De esta manera nos aseguramos que se carge una vez solo si esta vacía, si no se nos duplicaría
        //cada vez que cargamos el fragmento.
        if(publicaciones.isEmpty()){
            publicaciones.add(new Publicacion(1,"nueva york 2023","Mérida,Badajoz", "vacaciones 2023","casablanca"));
            //publicaciones.add(new Publicacion(2,"nueva york 2023", "Nueva York, EEUU","Viaje a nueva york"));
        }

        return view;
    }
}
