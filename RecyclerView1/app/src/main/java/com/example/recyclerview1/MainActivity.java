package com.example.recyclerview1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener datos de prueba de la clase Datos
// Cambia esta línea
        ArrayList<ItemLista> listaItems = new ArrayList<>(Datos.obtenerDatosDePrueba());

// Configurar RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MiAdaptador adaptador = new MiAdaptador(listaItems);
        recyclerView.setAdapter(adaptador);
    }
}
