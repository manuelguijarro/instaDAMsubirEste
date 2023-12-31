package com.example.instadamsubireste;

public class Publicacion {
    private int id;
    private String tituloPublicacion;
    private String urlImagen;
    private String autorPublicacion;
    private String descripcionPublicacion;
    private String ubicacionPublicacion;
    private String drawableTitulo;

    public Publicacion(int id, String tituloPublicacion, String ubicacionPublicacion, String descripcionPublicacion,String drawableTitulo) {
        this.id = id;
        this.tituloPublicacion = tituloPublicacion;
        this.ubicacionPublicacion = ubicacionPublicacion;
        this.autorPublicacion = "Manuel Guijarro Sánchez";
        this.descripcionPublicacion = descripcionPublicacion;
        this.drawableTitulo = drawableTitulo;
    }
    public Publicacion( String autorPublicacion, String descripcionPublicacion) {

        this.autorPublicacion = autorPublicacion;
        this.descripcionPublicacion = descripcionPublicacion;
    }
    public int getId() {
        return id;
    }

    public String getUbicacionPublicacion() {
        return ubicacionPublicacion;
    }

    public void setUbicacionPublicacion(String ubicacionPublicacion) {
        this.ubicacionPublicacion = ubicacionPublicacion;
    }

    public String getDrawableTitulo() {
        return drawableTitulo;
    }

    public void setDrawableTitulo(String drawableTitulo) {
        this.drawableTitulo = drawableTitulo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloPublicacion() {
        return tituloPublicacion;
    }

    public void setTituloPublicacion(String tituloPublicacion) {
        this.tituloPublicacion = tituloPublicacion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getAutorPublicacion() {
        return autorPublicacion;
    }

    public void setAutorPublicacion(String autorPublicacion) {
        this.autorPublicacion = autorPublicacion;
    }

    public String getDescripcionPublicacion() {
        return descripcionPublicacion;
    }

    public void setDescripcionPublicacion(String descripcionPublicacion) {
        this.descripcionPublicacion = descripcionPublicacion;
    }
}
