package com.darwinpz.instbmv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.darwinpz.instbmv.Objetos.Usuario;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class Registro extends AppCompatActivity {

    private EditText editText_email, editText_password,editText_nombre;

    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button btn_registrarse = (Button) findViewById(R.id.btn_registrarse);
        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_password = (EditText) findViewById(R.id.editText_password);
        editText_nombre = (EditText) findViewById(R.id.editText_nombre);

        dbRef = MainActivity.DB.getReference();

        toolbar.setOnClickListener(view -> finish());

        btn_registrarse.setOnClickListener(view -> {

            if(!editText_email.getText().toString().trim().isEmpty()) {

                if (!editText_password.getText().toString().trim().isEmpty()) {

                    MainActivity.mAuth.createUserWithEmailAndPassword(editText_email.getText().toString(), editText_password.getText().toString())
                            .addOnCompleteListener(this, task -> {

                                if (task.isSuccessful()) {
                                    FirebaseUser user = MainActivity.mAuth.getCurrentUser();
                                    if (user != null){
                                        user.sendEmailVerification();
                                        MainActivity.mAuth.signOut();
                                        Usuario usuario = new Usuario();
                                        usuario.nombre = editText_nombre.getText().toString();
                                        usuario.email = user.getEmail();
                                        usuario.url_foto = "";
                                        MainActivity.ctlUsuario.crear_usuario(dbRef,user.getUid(),usuario);
                                        Toast.makeText(this, "¡Usuario creado Correctamente!, Verifica Tu Correo", Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(this, "Error al Obtener el usuario", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(this, "Error al Crear el usuario", Toast.LENGTH_SHORT).show();
                                }
                            });
                }else {
                    Toast.makeText(this, "Contraseña no válida",Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(this, "Correo no válido",Toast.LENGTH_SHORT).show();
            }

        });

    }
}