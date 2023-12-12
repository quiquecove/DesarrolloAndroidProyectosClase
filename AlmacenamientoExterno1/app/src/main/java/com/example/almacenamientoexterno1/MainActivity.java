package com.example.almacenamientoexterno1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText eTTFich;
    private EditText eTTContenido;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTTFich = findViewById(R.id.eTTFich);
        eTTContenido = findViewById(R.id.eTTContenido);
        sharedPreferences = getSharedPreferences("prefLocalizacionFicheros", Context.MODE_PRIVATE);

        Button btnEscribir = findViewById(R.id.writeButton);
        Button btnLeer = findViewById(R.id.readButton);


        btnEscribir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escribirFichero();
            }
        });

        btnLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leerFichero();
            }
        });
    }

    private void escribirFichero() {
        String fileName = eTTFich.getText().toString();
        String text = eTTContenido.getText().toString();

        // Decidir aleatoriamente si escribir en memoria externa privada o en la raíz
        boolean escribirEnPrivada = new Random().nextInt(10) < 7; // 70% privada, 30% raíz

        // Obtener la referencia al directorio de destino
        File directory;

        if (escribirEnPrivada) {
            directory = getExternalFilesDir(null);
            Log.d("MainActivity", "Escribir en privada");
        } else {
            directory = Environment.getExternalStorageDirectory();
            Log.d("MainActivity", "Escribir en la raíz");
        }

        // Escribir en el archivo
        File file = new File(directory, fileName);

        try {
            FileWriter fw = new FileWriter(file);
            fw.write(text);
            fw.close();
            Log.d("MainActivity", "Archivo guardado en: " + directory.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Guardar la ubicación en SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(fileName, directory.getAbsolutePath());
        editor.apply();
    }


    private void leerFichero() {
        String fileName = eTTFich.getText().toString();

        // Obtener la ubicación del archivo desde SharedPreferences
        String ubicacion = sharedPreferences.getString(fileName, "privada");

        // Obtener la referencia al directorio de destino
        File directory;
        if (ubicacion.equals("privada")) {
            directory = getExternalFilesDir(null);
        } else {
            directory = Environment.getExternalStorageDirectory();
        }

        // Leer el archivo
        File file = new File(directory, fileName + ".txt");

        try {
            if (file.exists()) {
                StringBuilder text = new StringBuilder();
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                while ((line = br.readLine()) != null) {
                    text.append(line).append("\n");
                }

                br.close();
                eTTContenido.setText(text.toString().trim());
                Log.d("MainActivity", "Archivo leído desde: " + ubicacion);

                // Lógica específica para la ubicación privada
                if (ubicacion.equals("privada")) {
                    // Hacer algo específico para la ubicación privada
                    Log.d("MainActivity", "Operación específica para la ubicación privada");
                } else {
                    // Hacer algo específico para la raíz
                    Log.d("MainActivity", "Operación específica para la raíz");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
