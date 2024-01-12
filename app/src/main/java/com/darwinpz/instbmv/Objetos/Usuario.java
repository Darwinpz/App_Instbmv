package com.darwinpz.instbmv.Objetos;

public class Usuario {


    public String uid;
    public String nombre;
    public String email;
    public String direccion;
    public String telefono;
    public String url_foto;

    public Usuario(){

    }

    public Usuario(String uid, String nombre, String email, String direccion, String telefono, String url_foto) {
        this.uid = uid;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.url_foto = url_foto;
    }


}
