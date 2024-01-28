package com.example.boceto1proyecto_r;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtén una referencia al RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv);

        // Crea una instancia del adaptador
        AdaptadorRecycler adaptador = new AdaptadorRecycler(this);

        // Configura el RecyclerView con un LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Asigna el adaptador al RecyclerView
        recyclerView.setAdapter(adaptador);
    }
}