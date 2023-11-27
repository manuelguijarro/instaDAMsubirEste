package com.example.instadamsubireste;

import static com.example.instadamsubireste.MainActivity.publicaciones;
import static com.example.instadamsubireste.MainActivity.usuarios;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.LinkedList;
//Este fragmento se encarga de realizar la busqueda de usuarios, mediante un patron
//que se introduce en el campo input.
public class BuscarFragment extends Fragment {
    private EditText editTextInputNombre;
    private Button buttonBuscador;
    private LinkedList<Usuario>nuevosUsuarios;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buscar, container, false);
        //Esta LinkedList la utilizaremos para añadir los usuarios que coincidan
        //en el patron de busqueda.
        nuevosUsuarios = new LinkedList<>();
        editTextInputNombre = view.findViewById(R.id.editTextInputNombre);
        buttonBuscador = view.findViewById(R.id.buttonBuscador);
        //Si nuestra lista de usuarios esta vacía como pasa al inicio de la carga de la app
        // nosotros precargamos unos usuarios para que aparezcan como ejemplo.
        if(usuarios.isEmpty()){
            usuarios.add(new Usuario(0,"Manuel Guijarro Sánchez","manu2506.1994@gmail.com"));
            usuarios.add(new Usuario(1,"Francisco Javier Casado Asensio","fjpaco.asens@gmail.com"));
            usuarios.add(new Usuario(2,"Alex Muñoz Sánchez","jonnywalker@gmail.com"));
        }
        RecyclerView recyclerView = view.findViewById(R.id.recyclerUsuarios);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //Despues seteamos el nuevo adaptador con la clase UsuarioAdapter(previamente creada)
        recyclerView.setAdapter(new UsuarioAdapter(usuarios));
        /*
        El buttonBuscador al ser pulsado realiza la funcion de buscar en nuestra LinkedList de usuarios
        el patron que coincide:
        usuario.getNombreUsuario().contains(nombreUsuario)
        y el resultado lo volcamos en una nueva linkedlist para mostrar.
         */
        buttonBuscador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario = String.valueOf(editTextInputNombre.getText());
                for(Usuario usuario:usuarios){
                    if(usuario.getNombreUsuario().contains(nombreUsuario)){
                       //los añadimos a nuestra linkedlist de usuarios, los que coinciden
                        //para luego setearlo con la nueva linkedlist
                        nuevosUsuarios.add(usuario);
                    }
                }
                recyclerView.setAdapter(new UsuarioAdapter(nuevosUsuarios));
            }
        });
        return view;
    }
}