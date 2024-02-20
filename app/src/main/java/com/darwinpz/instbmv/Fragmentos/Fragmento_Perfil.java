package com.darwinpz.instbmv.Fragmentos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.darwinpz.instbmv.Controladores.Alert_dialog;
import com.darwinpz.instbmv.GPS;
import com.darwinpz.instbmv.MainActivity;
import com.darwinpz.instbmv.Principal;
import com.darwinpz.instbmv.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;


public class Fragmento_Perfil extends Fragment {

    private TextView txt_email, txt_nombre;
    private Button btn_salir, btn_gps;
    private FirebaseUser usuario;
    Alert_dialog alert_dialog;

    private DatabaseReference dbReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        final View vista = inflater.inflate(R.layout.fragmento_perfil,container,false);

        Toolbar toolbar = (Toolbar) vista.findViewById(R.id.toolbar);
        txt_email = (TextView) vista.findViewById(R.id.txt_email);
        btn_salir = (Button) vista.findViewById(R.id.btn_salir);
        txt_nombre = vista.findViewById(R.id.txt_nombre);
        btn_gps = vista.findViewById(R.id.btn_gps);

        dbReference = MainActivity.DB.getReference();


        alert_dialog = new Alert_dialog(vista.getContext());

        usuario = MainActivity.mAuth.getCurrentUser();

        if (usuario != null){
            txt_email.setText(usuario.getEmail());

            dbReference.child("usuarios").child(usuario.getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot datos) {

                    if(datos.exists()){

                        String nombre = datos.child("nombre").getValue().toString();
                        txt_nombre.setText(nombre);


                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }

        btn_gps.setOnClickListener(view -> {

            startActivity(new Intent(vista.getContext(), GPS.class));

        });

        btn_salir.setOnClickListener(view -> {

            alert_dialog.crear_mensaje("Confirmación","¿Estás seguro que deseas cerrar sesión", builder -> {

                builder.setPositiveButton("Aceptar",(dialogInterface, i) -> {

                    MainActivity.mAuth.signOut();

                    SharedPreferences.Editor editor = Principal.preferencias.edit();
                    editor.putString("uid","");
                    editor.putString("rol","");
                    editor.apply();
                    startActivity(new Intent(vista.getContext(),MainActivity.class));
                    //requireActivity().finish();


                });

                builder.setNegativeButton("Cancelar",(dialogInterface, i) -> {});
                builder.setCancelable(false);
                builder.create().show();

            });


        });

        toolbar.inflateMenu(R.menu.menu_perfil);

        return vista;

    }


}
