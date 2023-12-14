package com.darwinpz.instbmv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button btn_ingresar = (Button) findViewById(R.id.btn_ingresar);

        toolbar.setOnClickListener(view -> finish());

        btn_ingresar.setOnClickListener(view -> {

            Intent i = new Intent();
            i.setClass(this, Principal.class);
            startActivity(i);

        });

    }
}