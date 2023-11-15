package com.example.candidatospoliticos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    AdminSQLiteOpenHelper gestor;
    EditText tnombre_partido, tescannos, tpresidente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Assuming you have EditText widgets with the following IDs in your layout
        tnombre_partido = findViewById(R.id.etnombrepartido);
        tescannos = findViewById(R.id.etescannos);
        tpresidente = findViewById(R.id.etpresidente);

        gestor = new AdminSQLiteOpenHelper(this, "PARTIDOSPOLITICOS", null, 1);
    }

    public void guardarPolitico(View view) {
        SQLiteDatabase bd = gestor.getWritableDatabase();
        ContentValues registro = new ContentValues();
        if (tnombre_partido.getText().toString().equals("") || tpresidente.getText().toString().equals("")) {
            Toast.makeText(this, "Error, campos vacíos", Toast.LENGTH_SHORT).show();
        } else {
            registro.put("NOMBRE_PARTIDO", tnombre_partido.getText().toString());
            registro.put("PRESIDENTE", tpresidente.getText().toString());
            registro.put("ESCANNOS", Integer.parseInt(tescannos.getText().toString()));
            bd.insert("PARTIDOSPOLITICOS", null, registro);
            bd.close();
            Toast.makeText(this, "Agregado  " + tnombre_partido.getText().toString(), Toast.LENGTH_SHORT).show();
            tnombre_partido.setText("");
            tescannos.setText("");
            tpresidente.setText("");
        }
    }

    public void modificarPolitico(View view) {
        if (tnombre_partido.getText().toString().equals("") || tpresidente.getText().toString().equals("")) {
            Toast.makeText(this, "Error, campos vacíos", Toast.LENGTH_SHORT).show();
        } else {
            SQLiteDatabase bd = gestor.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("PRESIDENTE", tpresidente.getText().toString());
            registro.put("ESCANNOS", Integer.parseInt(tescannos.getText().toString()));
            int filasActualizadas = bd.update("PARTIDOSPOLITICOS", registro, "NOMBRE_PARTIDO=?", new String[]{tnombre_partido.getText().toString()});

            if (filasActualizadas == 1) {
                Toast.makeText(this, "Se ha modificado el líder político " + tnombre_partido.getText().toString(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El líder político " + tnombre_partido.getText().toString() + " no se encuentra en la base de datos", Toast.LENGTH_SHORT).show();
            }
            bd.close();
        }
    }


    @SuppressLint("Range")
    public void consultarPartido(View view) {
        SQLiteDatabase bd = gestor.getWritableDatabase();
        String[] aux = {tnombre_partido.getText().toString()};
        Cursor fila = bd.query("PARTIDOSPOLITICOS", null, "NOMBRE_PARTIDO=?", aux, null, null, null);
        if (fila.moveToFirst()) {
            tnombre_partido.setText(fila.getString(fila.getColumnIndex("NOMBRE_PARTIDO")));
            tpresidente.setText(fila.getString(fila.getColumnIndex("PRESIDENTE")));
            tescannos.setText(fila.getString(fila.getColumnIndex("ESCANNOS")));
            Toast.makeText(this, "Encontrado: " + fila.getString(0), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se ha encontrado al partido político " + tnombre_partido.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }

    public void borrarPolitico(View view) {
        SQLiteDatabase bd = gestor.getWritableDatabase();
        int filasBorradas = bd.delete("PARTIDOSPOLITICOS", "NOMBRE_PARTIDO=?", new String[]{tnombre_partido.getText().toString()});
        if (filasBorradas == 1) {
            Toast.makeText(this, "Se ha borrado el partido político " + tnombre_partido.getText().toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se ha encontrado al partido político " + tnombre_partido.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }

    public void volver(View view){
      finish();
    }
}