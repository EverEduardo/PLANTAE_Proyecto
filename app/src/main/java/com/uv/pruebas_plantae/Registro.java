package com.uv.pruebas_plantae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.metrics.EditingSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText nom, tel, us, correo, contra;
    Button reg, can;
    dbUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nom = (EditText) findViewById(R.id.nombreReg);
        tel = (EditText) findViewById(R.id.telefonoReg);
        us = (EditText) findViewById(R.id.usuarioReg);
        correo = (EditText) findViewById(R.id.correoReg);
        contra = (EditText) findViewById(R.id.contrasenaReg);
        reg = (Button) findViewById(R.id.btn_Registrarse);

        reg.setOnClickListener(this);

        dao = new dbUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Registrarse:
                Usuario u = new Usuario();
                u.setNombre(nom.getText().toString());
                u.setTelefono(tel.getText().toString());
                u.setUsuario(us.getText().toString());
                u.setCorreo(correo.getText().toString());
                u.setContraseña(contra.getText().toString());

                if(!u.isNull()){
                    Toast.makeText(this, "ERROR: Se deben llenar todos los campos", Toast.LENGTH_LONG).show();
                }else if(dao.insertUsuario(u)){
                    Toast.makeText(this, "¡Usuario registrado exitosamente!", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(Registro.this, MainActivity.class);
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this, "ERROR: El usuario ya se encuentra registrado", Toast.LENGTH_LONG).show();
                }break;
        }
    }
}