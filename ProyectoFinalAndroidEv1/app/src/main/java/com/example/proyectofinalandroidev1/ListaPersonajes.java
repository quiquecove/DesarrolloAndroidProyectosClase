// ListaPersonajes.java
package com.example.proyectofinalandroidev1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListaPersonajes extends AppCompatActivity {
    ListView listView;
    AdminSQLiteOpenHelper gestor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personajes);

        listView = findViewById(R.id.listView);
        gestor = new AdminSQLiteOpenHelper(this, "PERSONAJESDND", null, 1);

        mostrarPersonajes();
    }

    private void mostrarPersonajes() {
        SQLiteDatabase bd = gestor.getReadableDatabase();
        String[] projection = {
                "NOMBREJUGADOR",
                "NOMBREPERSONAJE",
                "CLASE",
                "FUERZA",
                "DESTREZA",
                "CONSTITUCION",
                "INTELIGENCIA",
                "SABIDURIA",
                "CARISMA",
                "HABILIDADES"
        };

        Cursor cursor = bd.query(
                "PERSONAJESDND",
                projection,
                null,
                null,
                null,
                null,
                null
        );

        List<String> personajes = new ArrayList<>();
        while (cursor.moveToNext()) {
            String nombreJugador = cursor.getString(cursor.getColumnIndexOrThrow("NOMBREJUGADOR"));
            String nombrePersonaje = cursor.getString(cursor.getColumnIndexOrThrow("NOMBREPERSONAJE"));
            String clase = cursor.getString(cursor.getColumnIndexOrThrow("CLASE"));
            int fuerza = cursor.getInt(cursor.getColumnIndexOrThrow("FUERZA"));
            int destreza = cursor.getInt(cursor.getColumnIndexOrThrow("DESTREZA"));
            int constitucion = cursor.getInt(cursor.getColumnIndexOrThrow("CONSTITUCION"));
            int inteligencia = cursor.getInt(cursor.getColumnIndexOrThrow("INTELIGENCIA"));
            int sabiduria = cursor.getInt(cursor.getColumnIndexOrThrow("SABIDURIA"));
            int carisma = cursor.getInt(cursor.getColumnIndexOrThrow("CARISMA"));
            String habilidades = cursor.getString(cursor.getColumnIndexOrThrow("HABILIDADES"));

            String infoPersonaje = "Jugador: " + nombreJugador +
                    "\nNombre: " + nombrePersonaje +
                    "\nClase: " + clase +
                    "\nFuerza: " + fuerza +
                    "\nDestreza: " + destreza +
                    "\nConstitución: " + constitucion +
                    "\nInteligencia: " + inteligencia +
                    "\nSabiduría: " + sabiduria +
                    "\nCarisma: " + carisma +
                    "\nHabilidades: " + habilidades;

            personajes.add(infoPersonaje);
        }
        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                personajes
        );

        listView.setAdapter(adapter);
    }
}
