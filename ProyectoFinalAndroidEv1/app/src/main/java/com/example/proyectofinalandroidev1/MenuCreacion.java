package com.example.proyectofinalandroidev1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MenuCreacion extends AppCompatActivity {
    EditText etnp;
    Spinner spinner;
    String nombreJugador;
    String nombrePersonaje;
    AdminSQLiteOpenHelper gestor;
    String res;
    Button estadisticas;
    Button habilidades;
    Button guardar;
    String spinnerSel;

    // Variables para habilidades
    private int iNumero1;
    private int iNumero2;
    private int iNumero3;
    private int iNumero4;
    private int iNumero5;
    private int iNumero6;

    List<Integer> imagenes = new LinkedList<>();
    List<String> clasesDnd = new ArrayList<>();


    // Variables para estadísticas y habilidades
    private String estadisticasGuardadas;
    private String habilidadesGuardadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        gestor = new AdminSQLiteOpenHelper(this, "PERSONAJESDND", null, 1);
        etnp = findViewById(R.id.etnombrepersonaje);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("nombrej")) {
            nombreJugador = String.valueOf(intent.getStringExtra("nombrej"));
        }

        iconosAdapter adaptadorIconos = new iconosAdapter();

//Lista imagenes
        imagenes.add(R.drawable.icono1);
        imagenes.add(R.drawable.icono2);
        imagenes.add(R.drawable.icono3);
        imagenes.add(R.drawable.icono4);
        imagenes.add(R.drawable.icono5);
        imagenes.add(R.drawable.icono6);
        imagenes.add(R.drawable.icono7);
        imagenes.add(R.drawable.icono8);
        imagenes.add(R.drawable.icono9);
        imagenes.add(R.drawable.icono10);
        imagenes.add(R.drawable.icono11);
        imagenes.add(R.drawable.icono12);
        //spinner
        spinner = findViewById(R.id.spinner);
        //lista para el spinner
        clasesDnd.add("Bárbaro");
        clasesDnd.add("Bardo");
        clasesDnd.add("Clérigo");
        clasesDnd.add("Druida");
        clasesDnd.add("Guerrero");
        clasesDnd.add("Monje");
        clasesDnd.add("Paladín");
        clasesDnd.add("Explorador");
        clasesDnd.add("Pícaro");
        clasesDnd.add("Hechicero");
        clasesDnd.add("Brujo");
        clasesDnd.add("Mago");

        // Ordenar alfabéticamente
        //Collections.sort(clasesDnd);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                clasesDnd
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);
        spinner.setAdapter(adaptadorIconos);
        estadisticas = findViewById(R.id.Estadisticas);
        habilidades = findViewById(R.id.Habilidades);
        guardar = findViewById(R.id.Guardar_Personaje);
        estadisticas.setEnabled(true);
        habilidades.setEnabled(true);
        guardar.setEnabled(false);
    }

    ActivityResultLauncher<Intent> startForResult2 =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == RESULT_OK) {
                                res = result.getData().getStringExtra("resultado");
                                guardarEstadisticas(res);
                                Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
                                estadisticas.setEnabled(false);
                                estadisticas.setActivated(false);
                                estadisticas.setVisibility(View.GONE);
                                if (!habilidades.isActivated() && !estadisticas.isActivated()) {
                                    guardar.setEnabled(true);
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Resultado cancelado", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

    public void estadisticas(View view) {
        Intent i = new Intent(this, Estadisticas.class);
        startForResult2.launch(i);
    }

    ActivityResultLauncher<Intent> startForResult3 =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == RESULT_OK) {
                                res = result.getData().getStringExtra("habilidadesSeleccionadas");
                                guardarHabilidades(res);
                                Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
                                habilidades.setEnabled(false);
                                habilidades.setActivated(false);
                                habilidades.setVisibility(View.GONE);
                                if (!habilidades.isActivated() && !estadisticas.isActivated()) {
                                    guardar.setEnabled(true);
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Resultado cancelado", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

    public void habilidades(View view) {
        Intent i = new Intent(this, Habilidades.class);
        startForResult3.launch(i);
    }

    private void guardarEstadisticas(String res) {
        estadisticasGuardadas = res;

        String[] habilidades = estadisticasGuardadas.split("-");

        if (habilidades.length >= 6) {
            iNumero1 = Integer.parseInt(habilidades[0]);
            iNumero2 = Integer.parseInt(habilidades[1]);
            iNumero3 = Integer.parseInt(habilidades[2]);
            iNumero4 = Integer.parseInt(habilidades[3]);
            iNumero5 = Integer.parseInt(habilidades[4]);
            iNumero6 = Integer.parseInt(habilidades[5]);
        } else {
            Log.e("guardarEstadisticas", "No hay suficientes valores en el array");
        }
    }

    private void guardarHabilidades(String res) {
        habilidadesGuardadas = res;
        Toast.makeText(getApplicationContext(), habilidadesGuardadas, Toast.LENGTH_LONG).show();
    }

    public void guardarPersonaje(View view) {
        if (etnp.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Introduce un nombre de personaje", Toast.LENGTH_LONG).show();
        } else {
            nombrePersonaje = etnp.getText().toString();
            SQLiteDatabase bd = gestor.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("NOMBREJUGADOR", String.valueOf(nombreJugador));
            registro.put("NOMBREPERSONAJE", nombrePersonaje);
            //String claseSeleccionada = spinner.getSelectedItem().toString();
            //registro.put("CLASE", claseSeleccionada);

            //String claseSeleccionada = spinner.getSelectedItem().toString();
            registro.put("CLASE", spinnerSel);
            registro.put("FUERZA", iNumero1);
            registro.put("DESTREZA", iNumero2);
            registro.put("CONSTITUCION", iNumero3);
            registro.put("INTELIGENCIA", iNumero4);
            registro.put("SABIDURIA", iNumero5);
            registro.put("CARISMA", iNumero6);
            registro.put("HABILIDADES", habilidadesGuardadas);
            bd.insert("PERSONAJESDND", null, registro);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("saludo", "Pesonaje Guardado");
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }

    class iconosAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imagenes.size();
        }

        @Override
        public Object getItem(int position) {
            return imagenes.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=LayoutInflater.from(MenuCreacion.this);
            convertView=inflater.inflate(R.layout.itemspinner,null);
            ImageView iv1=convertView.findViewById(R.id.imageView);
            TextView tv1=convertView.findViewById(R.id.tvClase);
            iv1.setImageResource(imagenes.get(position));
            tv1.setText(clasesDnd.get(position));
            spinnerSel= clasesDnd.get(position);
            return convertView;
        }
    }
}
