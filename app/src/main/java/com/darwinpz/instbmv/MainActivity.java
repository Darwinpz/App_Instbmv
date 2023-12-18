package com.darwinpz.instbmv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    public static FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_ingresar = (Button) findViewById(R.id.btn_ingresar);

        mAuth = FirebaseAuth.getInstance();

        btn_ingresar.setOnClickListener(view -> {

            Intent i = new Intent();
            i.setClass(this,Login.class);
            startActivity(i);

        });


    }
}