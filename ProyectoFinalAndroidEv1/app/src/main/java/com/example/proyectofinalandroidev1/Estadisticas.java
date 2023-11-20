package com.example.proyectofinalandroidev1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Estadisticas extends AppCompatActivity {
    TextView fuerza, destreza, constitucion, inteligencia, sabiduria, carisma;
    Button btnFuerza, btnDestreza, btnConstitucion, btnInteligencia, btnSabiduria, btnCarisma;
    int contador = 0;
    int valorFuerza, valorDestreza, valorConstitucion, valorInteligencia, valorSabiduria, valorCarisma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        fuerza = findViewById(R.id.NFuerza);
        destreza = findViewById(R.id.NDestreza);
        constitucion = findViewById(R.id.NConstitucion);
        inteligencia = findViewById(R.id.NInteligencia);
        sabiduria = findViewById(R.id.NSabiduria);
        carisma = findViewById(R.id.NCarisma);

        btnFuerza = findViewById(R.id.btnFuerza);
        btnDestreza = findViewById(R.id.btnDestreza);
        btnConstitucion = findViewById(R.id.btnConstitucion);
        btnInteligencia = findViewById(R.id.btnInteligencia);
        btnSabiduria = findViewById(R.id.btnSabiduria);
        btnCarisma = findViewById(R.id.btnCarisma);
    }

    public void generarFuerza(View view) {
        valorFuerza = lanzarDados();
        Log.d("Habilidades", "Valor de Fuerza: " + valorFuerza);
        fuerza.setText(String.valueOf(valorFuerza));
        btnFuerza.setEnabled(false);
        checkFinalizar();
    }

    public void generarDestreza(View view) {
        valorDestreza = lanzarDados();
        Log.d("Habilidades", "Valor de Destreza: " + valorDestreza);
        destreza.setText(String.valueOf(valorDestreza));
        btnDestreza.setEnabled(false);
        checkFinalizar();
    }

    public void generarConstitucion(View view) {
        valorConstitucion = lanzarDados();
        Log.d("Habilidades", "Valor de Constitución: " + valorConstitucion);
        constitucion.setText(String.valueOf(valorConstitucion));
        btnConstitucion.setEnabled(false);
        checkFinalizar();
    }

    public void generarInteligencia(View view) {
        valorInteligencia = lanzarDados();
        Log.d("Habilidades", "Valor de Inteligencia: " + valorInteligencia);
        inteligencia.setText(String.valueOf(valorInteligencia));
        btnInteligencia.setEnabled(false);
        checkFinalizar();
    }

    public void generarSabiduria(View view) {
        valorSabiduria = lanzarDados();
        Log.d("Habilidades", "Valor de Sabiduría: " + valorSabiduria);
        sabiduria.setText(String.valueOf(valorSabiduria));
        btnSabiduria.setEnabled(false);
        checkFinalizar();
    }

    public void generarCarisma(View view) {
        valorCarisma = lanzarDados();
        Log.d("Habilidades", "Valor de Carisma: " + valorCarisma);
        carisma.setText(String.valueOf(valorCarisma));
        btnCarisma.setEnabled(false);
        checkFinalizar();
    }

    private int lanzarDados() {
        Random random = new Random();
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        int dado3 = random.nextInt(6) + 1;
        contador++;
        return dado1 + dado2 + dado3;
    }

    private void checkFinalizar() {
        if (contador == 6) {
            String resultado = valorFuerza + "-" + valorDestreza + "-" + valorConstitucion + "-" +
                    valorInteligencia + "-" + valorSabiduria + "-" + valorCarisma;
            setResult(RESULT_OK, getIntent().putExtra("resultado", resultado));
            finish();
        }
    }
}
