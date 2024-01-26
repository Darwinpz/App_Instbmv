package com.darwinpz.instbmv.Controladores;

import com.darwinpz.instbmv.Objetos.Usuario;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Ctl_usuario {

    public Ctl_usuario(){}

    public void crear_usuario(DatabaseReference dbref, String uid, Usuario usuario){

        dbref.child("usuarios").child(uid).setValue(usuario);

    }


    public void actualizar_usuario(DatabaseReference dbref, Usuario usuario){

        Map<String, Object> datos = new HashMap<>();
        datos.put("direccion", usuario.direccion);
        datos.put("telefono",usuario.telefono);

        dbref.child("usuarios").child(usuario.uid).updateChildren(datos);

    }

    public void eliminar_usuario(DatabaseReference dbref, String uid_usuario){

        dbref.child("usuarios").child(uid_usuario).removeValue();

    }


}
