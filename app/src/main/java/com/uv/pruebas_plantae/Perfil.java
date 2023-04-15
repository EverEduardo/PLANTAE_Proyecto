package com.uv.pruebas_plantae;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Perfil extends AppCompatActivity implements View.OnClickListener {


    int id = 0;
    Usuario u;
    dbUsuario dao;

    private TextView myTextView;

    Button btnEditar, btnEliminar, btnMostrar, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        TextView nombre = (TextView) findViewById(R.id.mostrarNombre);
        TextView telefono = (TextView) findViewById(R.id.mostrar_telefono);
        TextView mostrarUsuario = (TextView) findViewById(R.id.mostrarUsuario); // Cambio de nombre de variable
        TextView correo = (TextView) findViewById(R.id.mostrar_correo);
        btnEditar = (Button) findViewById(R.id.btn_editar);
        btnSalir = (Button) findViewById(R.id.btn_cerrarSesion);
        btnEliminar = (Button) findViewById(R.id.btn_eliminar);
        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

    /*
        Bundle b = getIntent().getExtras();

            dao = new dbUsuario(this);
            u = dao.getUsuarioById(id);
            nombre.setText(u.getNombre());
            //mostrarUsuario.setText(u.getUsuario()); // Asignación del valor de usuario al TextView
*/
    }

    /*
    public void cerrarSesion(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_editar:
                break;
            case R.id.btn_cerrarSesion:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.btn_eliminar:
                break;
        }
    }
}