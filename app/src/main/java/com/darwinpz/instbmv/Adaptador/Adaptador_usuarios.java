package com.darwinpz.instbmv.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.darwinpz.instbmv.Holders.Holder_usuarios;
import com.darwinpz.instbmv.Objetos.Usuario;
import com.darwinpz.instbmv.Principal;
import com.darwinpz.instbmv.R;
import com.darwinpz.instbmv.Vi_det_usuario;

import java.util.ArrayList;
import java.util.List;

public class Adaptador_usuarios extends RecyclerView.Adapter<Holder_usuarios> {

    List<Usuario> lista_usuarios = new ArrayList<>();
    Context context;

    public Adaptador_usuarios(Context context){
        this.context = context;
    }

    public void Add_usuarios(Usuario user){

        lista_usuarios.add(user);
        notifyItemInserted(lista_usuarios.size());
    }

    public void Clear(){
        lista_usuarios.clear();

    }


    @NonNull
    @Override
    public Holder_usuarios onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_usuarios,parent, false);

        return new Holder_usuarios(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_usuarios holder, int position) {

        holder.card_nombre.setText(lista_usuarios.get(position).nombre);
        holder.card_direccion.setText(lista_usuarios.get(position).direccion);
        holder.card_telefono.setText(lista_usuarios.get(position).telefono);

        holder.card_usuarios.setOnClickListener(view -> {

            Intent i = new Intent();
            i.setClass(context, Vi_det_usuario.class);
            i.putExtra("uid",lista_usuarios.get(position).uid);
            context.startActivity(i);

        });

    }

    @Override
    public int getItemCount() {
        return lista_usuarios.size();
    }
}
