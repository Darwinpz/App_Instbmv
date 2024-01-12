package com.darwinpz.instbmv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.darwinpz.instbmv.Controladores.Ctl_usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    public static FirebaseAuth mAuth;
    public static FirebaseDatabase DB = FirebaseDatabase.getInstance();
    public static Ctl_usuario ctlUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_ingresar = (Button) findViewById(R.id.btn_ingresar);

        mAuth = FirebaseAuth.getInstance();

        ctlUsuario = new Ctl_usuario();

        btn_ingresar.setOnClickListener(view -> {

            Intent i = new Intent();
            i.setClass(this,Login.class);
            startActivity(i);

        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser usuario = mAuth.getCurrentUser();

        if(usuario!=null) {
            Intent i = new Intent();
            i.setClass(this,Principal.class);
            startActivity(i);
        }

    }


}