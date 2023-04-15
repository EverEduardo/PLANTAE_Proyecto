package com.uv.pruebas_plantae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button btnEntrar, btnIrRegistro;
    dbUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.usuario);
        pass = (EditText) findViewById(R.id.contrasena);
        btnEntrar = (Button) findViewById(R.id.btn_IniciarSesion);
        btnIrRegistro = (Button) findViewById(R.id.btn_irRegistro);

        dao = new dbUsuario(this);

    }

    public void iniciarSeson(View view){
        String u= user.getText().toString();
        String c= pass.getText().toString();
        if(u.equals("")||c.equals("")){
            Toast.makeText(this, "Error: Campos vacios", Toast.LENGTH_SHORT).show();
        } else if (dao.login(u,c)==1) {
            Usuario ux = dao.getUsuario(u,c);
            Toast.makeText(this, "Datos correctos", Toast.LENGTH_SHORT).show();
            Intent i3 = new Intent(this, Barra_navegacion.class);
            i3.putExtra("Id", ux.getIdUsuario());
            startActivity(i3);
            //agregar limpiar campos
            EditText editText = findViewById(R.id.usuario);
            editText.setText("");
            EditText editText1 = findViewById(R.id.contrasena);
            editText1.setText("");
        }else{
            Toast.makeText(this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_SHORT).show();
        }
    }

    public void irMenu(View view){
        Intent i = new Intent(this, Barra_navegacion.class);
        startActivity(i);
    }

    public void irRegistro(View view) {
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
    }



}