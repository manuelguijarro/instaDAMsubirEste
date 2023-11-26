package com.example.instadamsubireste;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String emailUsuario;


    public Usuario(int id, String nombreUsuario, String emailUsuario) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
}
