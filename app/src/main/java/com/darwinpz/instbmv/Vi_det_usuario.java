package com.darwinpz.instbmv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.darwinpz.instbmv.Objetos.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Vi_det_usuario extends AppCompatActivity {

    TextView txt_nombre, txt_email;
    EditText editext_direccion, editext_telefono;
    DatabaseReference dbref;
    Button btn_update, btn_delete;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi_det_usuario);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setOnClickListener(view -> finish());

        dbref = MainActivity.DB.getReference();

        uid = getIntent().getExtras().getString("uid");

        txt_nombre = findViewById(R.id.txt_nombre);
        txt_email = findViewById(R.id.txt_email);
        editext_direccion = findViewById(R.id.editext_direccion);
        editext_telefono = findViewById(R.id.editext_telefono);

        btn_update  = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);

        btn_update.setOnClickListener(v -> {

            if(editext_direccion.getText().toString().isEmpty() || editext_telefono.getText().toString().isEmpty()){
                Toast.makeText(this,"Rellena todos los campos",Toast.LENGTH_SHORT).show();
            }else{

                Usuario user = new Usuario();
                user.uid = uid;
                user.direccion = editext_direccion.getText().toString();
                user.telefono = editext_telefono.getText().toString();
                MainActivity.ctlUsuario.actualizar_usuario(dbref,user);

                Toast.makeText(this,"Usuario Actualizado Correctamente",Toast.LENGTH_SHORT).show();

            }

        });

        btn_delete.setOnClickListener(v ->{


            MainActivity.ctlUsuario.eliminar_usuario(dbref,uid);

            Toast.makeText(this,"Usuario Eliminado Correctamente",Toast.LENGTH_SHORT).show();

            finish();

        });


        dbref.child("usuarios").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datos) {

                if(datos.exists()){

                    txt_nombre.setText(datos.child("nombre").getValue().toString());
                    txt_email.setText(datos.child("email").getValue().toString());

                    if(datos.child("direccion").exists()){
                        editext_direccion.setText(datos.child("direccion").getValue().toString());
                    }else{
                        editext_direccion.setText("");
                    }
                    if(datos.child("telefono").exists()){
                        editext_telefono.setText(datos.child("telefono").getValue().toString());
                    }else{
                        editext_telefono.setText("");
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}