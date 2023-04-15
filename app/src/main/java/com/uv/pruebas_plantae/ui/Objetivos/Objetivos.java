package com.uv.pruebas_plantae.ui.Objetivos;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.uv.pruebas_plantae.MainActivity;
import com.uv.pruebas_plantae.R;
import com.uv.pruebas_plantae.Registro;
import com.uv.pruebas_plantae.Usuario;
import com.uv.pruebas_plantae.dbUsuario;

import org.w3c.dom.Text;

public class Objetivos extends Fragment implements View.OnClickListener {

    private ObjetivosViewModel mViewModel;

    private TextView myTextView;


    public static Objetivos newInstance() {
        return new Objetivos();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_objetivos, container, false);


        // Hacer algo con la vista nombre
        return rootView;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ObjetivosViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_editar:
                break;
            case R.id.btn_cerrarSesion:
                Intent i = new Intent(getContext(), MainActivity.class);
                startActivity(i);
                break;
            case R.id.btn_eliminar:
                break;
        }
    }
}