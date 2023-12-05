package com.darwinpz.instbmv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ingresar = (Button) findViewById(R.id.btn_ingresar);

        btn_ingresar.setOnClickListener(view -> {

            Intent i = new Intent();
            i.setClass(this,Login.class);
            startActivity(i);

        });

    }
}