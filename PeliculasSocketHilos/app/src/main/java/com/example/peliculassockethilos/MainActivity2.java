package com.example.peliculassockethilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.PrintStream;
import java.net.Socket;

public class MainActivity2 extends AppCompatActivity {
    private String nuevo;

    Button btnid, btntit, btndirec, btnagregar, btnexit;
    Socket socketAlServidor = new Socket();
    PrintStream salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnid = findViewById(R.id.btnid);
        btntit = findViewById(R.id.btntitulo);
        btndirec = findViewById(R.id.btndirector);
        btnagregar = findViewById(R.id.btnagregar);
        btnexit = findViewById(R.id.btnsalir);

        // Obtener la IP del intent
        nuevo = getIntent().getStringExtra("ip");

        // Conectar al servidor en un AsyncTask
        //new ConnectToServerTask().execute();

    }

    public void consultarId(View v) {
        Intent i = new Intent(this, ConsultaID.class);
        i.putExtra("ip", nuevo);
        startActivity(i);

    }

    public void consultarTitulo(View v) {


    }

    public void consultarDirector(View v) {


    }

    public void agregarPelicula(View v) {


    }

    public void salir(View v) {


    }


}