package com.darwinpz.instbmv.Citas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.darwinpz.instbmv.Principal;
import com.darwinpz.instbmv.R;

public class Ver_Citas extends AppCompatActivity {

    Button btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_citas);

        btn_add = findViewById(R.id.btn_add);


        if(Principal.rol.equals("Administrador")){
            btn_add.setVisibility(View.VISIBLE); //visible
        }else{
            btn_add.setVisibility(View.GONE); //invisible

        }


    }
}