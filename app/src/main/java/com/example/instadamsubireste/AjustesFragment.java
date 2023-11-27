package com.example.instadamsubireste;

import static com.example.instadamsubireste.MainActivity.publicaciones;
import static com.example.instadamsubireste.MainActivity.usuarioPrincipal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AjustesFragment extends Fragment {

    private TextView emailTextView;
    private EditText emailEditText;

    private TextView userNameTextView;
    private EditText userNameEditText;
    private Button buttonActualizar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_ajustes, container, false);
        emailTextView = view.findViewById(R.id.emailNameField);
        userNameTextView = view.findViewById(R.id.userNameField);
        userNameEditText = view.findViewById(R.id.editTextAjustName);
        emailEditText = view.findViewById(R.id.editTextTextAjustEmail);
        buttonActualizar = view.findViewById(R.id.buttonActualizar);
        emailTextView.setText(usuarioPrincipal.getEmailUsuario());
        userNameTextView.setText(usuarioPrincipal.getNombreUsuario());
        /*
        En este evento, al hacer click, actualizaremos el usuario principal de la app.
         */
        buttonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario = String.valueOf(userNameEditText.getText());
                String emailUsuario = String.valueOf(emailEditText.getText());
                Toast notificacion = null;
                if(nombreUsuario.isEmpty() || emailUsuario.isEmpty()){
                    notificacion = Toast.makeText(getContext(), "No se a podido actualizar el usuario, los campos tienen que estar completos", Toast.LENGTH_LONG);
                }else{
                    int id = usuarioPrincipal.getId() + 2;
                    notificacion = Toast.makeText(getContext(), "Se ha añadido actualizado correctamente el usuario principal", Toast.LENGTH_LONG);
                    usuarioPrincipal = new Usuario(id,nombreUsuario,emailUsuario);
                    emailTextView.setText(usuarioPrincipal.getEmailUsuario());
                    userNameTextView.setText(usuarioPrincipal.getNombreUsuario());
                }
            }
        });
        return view;
    }
}