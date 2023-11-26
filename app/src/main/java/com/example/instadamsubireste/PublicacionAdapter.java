package com.example.instadamsubireste;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PublicacionAdapter extends RecyclerView.Adapter<PublicacionAdapter.PublicacionViewHolder> {

    private List<Publicacion> publicaciones;

    public PublicacionAdapter(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    @NonNull
    @Override
    public PublicacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_publicacion, parent, false);
        return new PublicacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PublicacionViewHolder holder, int position) {
        Publicacion publicacion = publicaciones.get(position);
        holder.textViewAutor.setText(publicacion.getAutorPublicacion());
        holder.textViewTitulo.setText(publicacion.getAutorPublicacion());
        holder.textViewUbicacion.setText(publicacion.getUbicacionPublicacion());
        holder.textViewDescripcion.setText(publicacion.getDescripcionPublicacion());
    }

    @Override
    public int getItemCount() {
        return publicaciones.size();
    }

    static class PublicacionViewHolder extends RecyclerView.ViewHolder {
        TextView textViewAutor;
        TextView textViewTitulo;
        TextView textViewUbicacion;
        TextView textViewDescripcion;


        PublicacionViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAutor = itemView.findViewById(R.id.textViewAutor);
            textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
            textViewUbicacion = itemView.findViewById(R.id.textViewUbicacion);
            textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);
        }
    }
}
