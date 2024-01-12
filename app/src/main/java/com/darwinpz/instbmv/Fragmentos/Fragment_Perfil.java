package com.darwinpz.instbmv.Fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.darwinpz.instbmv.MainActivity;
import com.darwinpz.instbmv.Principal;
import com.darwinpz.instbmv.R;
import com.google.firebase.auth.FirebaseUser;


public class Fragment_Perfil extends Fragment {

    private TextView txt_email;
    private Button btn_salir;
    private FirebaseUser usuario;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        final View vista = inflater.inflate(R.layout.fragmento_perfil,container,false);

        Toolbar toolbar = (Toolbar) vista.findViewById(R.id.toolbar);
        txt_email = (TextView) vista.findViewById(R.id.txt_email);
        btn_salir = (Button) vista.findViewById(R.id.btn_salir);

        usuario = MainActivity.mAuth.getCurrentUser();

        if (usuario != null){
            txt_email.setText(usuario.getEmail());
        }

        btn_salir.setOnClickListener(view -> {
            MainActivity.mAuth.signOut();
            Principal.actividad.finish();

        });

        toolbar.inflateMenu(R.menu.menu_perfil);

        return vista;

    }


}
