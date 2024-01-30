package com.darwinpz.instbmv.Controladores;

import com.darwinpz.instbmv.Objetos.Usuario;
import com.google.firebase.database.DatabaseReference;

public class Ctl_usuario {

    public Ctl_usuario(){}

    public void crear_usuario(DatabaseReference dbref, String uid, Usuario usuario){

        dbref.child("usuarios").child(uid).setValue(usuario);

    }



}
