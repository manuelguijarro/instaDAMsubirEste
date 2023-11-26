package com.example.instadamsubireste;

public class Publicacion {
    private int id;
    private String tituloPublicacion;
    private String urlImagen;
    private String autorPublicacion;
    private String descripcionPublicacion;

    public Publicacion(int id, String tituloPublicacion, String urlImagen, String autorPublicacion, String descripcionPublicacion) {
        this.id = id;
        this.tituloPublicacion = tituloPublicacion;
        this.urlImagen = urlImagen;
        this.autorPublicacion = autorPublicacion;
        this.descripcionPublicacion = descripcionPublicacion;
    }
    public Publicacion( String autorPublicacion, String descripcionPublicacion) {

        this.autorPublicacion = autorPublicacion;
        this.descripcionPublicacion = descripcionPublicacion;
    }
    public int getId() {
        return id;
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
