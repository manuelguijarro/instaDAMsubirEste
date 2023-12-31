package com.example.instadamsubireste;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class PublicacionAdapter extends RecyclerView.Adapter<PublicacionAdapter.PublicacionViewHolder> {

    private LinkedList<Publicacion> publicaciones;

    public PublicacionAdapter(LinkedList<Publicacion> publicaciones) {
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
        holder.textViewTitulo.setText(publicacion.getTituloPublicacion());
        holder.textViewUbicacion.setText(publicacion.getUbicacionPublicacion());
        holder.textViewDescripcion.setText(publicacion.getDescripcionPublicacion());
        if (publicacion.getUrlImagen() != null) {
            int imageResourceId = holder.itemView.getContext().getResources().getIdentifier(publicacion.getUrlImagen(), "drawable", holder.itemView.getContext().getPackageName());
            Drawable imageDrawable = holder.itemView.getContext().getResources().getDrawable(imageResourceId);
            holder.imageViewPublicacion.setImageDrawable(imageDrawable);
        } else {
            // Si el nombre de la imagen es nulo, puedes manejarlo de alguna manera, por ejemplo, establecer una imagen por defecto.
            holder.imageViewPublicacion.setImageResource(R.drawable.casablanca);
        }
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
        ImageView imageViewPublicacion;


        PublicacionViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAutor = itemView.findViewById(R.id.textViewAutor);
            textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
            textViewUbicacion = itemView.findViewById(R.id.textViewUbicacion);
            textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);
            imageViewPublicacion = itemView.findViewById(R.id.imageViewPublicacion);
        }
    }
}
