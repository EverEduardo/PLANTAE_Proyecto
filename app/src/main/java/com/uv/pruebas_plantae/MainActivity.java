package com.uv.pruebas_plantae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irMenu(View view){
        Intent i = new Intent(this, Barra_navegacion.class);
        startActivity(i);
    }

    public void irRegistro(View view){
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
    }
}