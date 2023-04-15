package com.uv.pruebas_plantae.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.uv.pruebas_plantae.Barra_navegacion;
import com.uv.pruebas_plantae.MainActivity;
import com.uv.pruebas_plantae.Perfil;
import com.uv.pruebas_plantae.R;
import com.uv.pruebas_plantae.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    Button irPerfil;

    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        // Inicializar la variable irPerfil
        irPerfil = root.findViewById(R.id.irPerfil);
        // Asignar el listener de clic al botón irPerfil
        irPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Perfil.class);
                startActivity(i);
            }
        });

        return root;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}