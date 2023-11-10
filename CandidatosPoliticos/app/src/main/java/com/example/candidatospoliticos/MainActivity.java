package com.example.candidatospoliticos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    AdminSQLiteOpenHelper gestor;
    EditText tNombre, tEdad, tEstudios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assuming you have EditText widgets with the following IDs in your layout
        tNombre = findViewById(R.id.editTextNombre);
        tEdad = findViewById(R.id.editTextEdad);
        tEstudios = findViewById(R.id.editTextEstudios);

        gestor = new AdminSQLiteOpenHelper(this, "LIDERESPOLITICOS", null, 1);
    }

    public void guardarPolitico(View view) {
        SQLiteDatabase bd = gestor.getWritableDatabase();
        ContentValues registro = new ContentValues();
        if (tNombre.getText().toString().equals("") || tEstudios.getText().toString().equals("")) {
            Toast.makeText(this, "Error, campos vacíos", Toast.LENGTH_SHORT).show();
        } else {
            registro.put("NOMBRE", tNombre.getText().toString());
            registro.put("EDAD", Integer.parseInt(tEdad.getText().toString()));
            registro.put("ESTUDIOS", tEstudios.getText().toString());
            bd.insert("LIDERESPOLITICOS", null, registro);
            bd.close();
            Toast.makeText(this, "Agregado  " + tNombre.getText().toString(), Toast.LENGTH_SHORT).show();
            tNombre.setText("");
            tEdad.setText("");
            tEstudios.setText("");
        }
    }

    public void modificarPolitico(View view) {
        if (tNombre.getText().toString().equals("") || tEstudios.getText().toString().equals("")) {
            Toast.makeText(this, "Error, campos vacíos", Toast.LENGTH_SHORT).show();
        } else {
            SQLiteDatabase bd = gestor.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("EDAD", Integer.parseInt(tEdad.getText().toString()));
            registro.put("ESTUDIOS", tEstudios.getText().toString());
            int filasActualizadas = bd.update("LIDERESPOLITICOS", registro, "NOMBRE=?", new String[]{tNombre.getText().toString()});

            if (filasActualizadas == 1) {
                Toast.makeText(this, "Se ha modificado el líder político " + tNombre.getText().toString(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El líder político " + tNombre.getText().toString() + " no se encuentra en la base de datos", Toast.LENGTH_SHORT).show();
            }
            bd.close();
        }
    }


    @SuppressLint("Range")
    public void consultarPolitico(View view) {
        SQLiteDatabase bd = gestor.getWritableDatabase();
        String[] aux = {tNombre.getText().toString()};
        Cursor fila = bd.query("LIDERESPOLITICOS", null, "NOMBRE=?", aux, null, null, null);
        if (fila.moveToFirst()) {
            tNombre.setText(fila.getString(fila.getColumnIndex("NOMBRE")));
            tEdad.setText(fila.getString(fila.getColumnIndex("EDAD")));
            tEstudios.setText(fila.getString(fila.getColumnIndex("ESTUDIOS")));
            Toast.makeText(this, "Encontrado: " + fila.getString(1), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se ha encontrado al líder político " + tNombre.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }

    public void borrarPolitico(View view) {
        SQLiteDatabase bd = gestor.getWritableDatabase();
        int filasBorradas = bd.delete("LIDERESPOLITICOS", "NOMBRE=?", new String[]{tNombre.getText().toString()});
        if (filasBorradas == 1) {
            Toast.makeText(this, "Se ha borrado el líder político " + tNombre.getText().toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se ha encontrado al líder político " + tNombre.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }
}
