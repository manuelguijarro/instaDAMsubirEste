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
        publicaciones.add(new Publicacion("pako", "vacaciones 2023"));
        publicaciones.add(new Publicacion("Manuel GUijarro Sanchez", "vacaciones 2023"));

        return view;
    }
}
