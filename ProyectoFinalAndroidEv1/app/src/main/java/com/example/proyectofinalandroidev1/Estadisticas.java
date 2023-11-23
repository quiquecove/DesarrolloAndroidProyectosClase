package com.example.proyectofinalandroidev1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Estadisticas extends AppCompatActivity {

    private TextView fuerza, destreza, constitucion, inteligencia, sabiduria, carisma;
    private List<Integer> dados = new ArrayList<>();
    private Map<Button, List<ImageView>> buttonDiceMap = new HashMap<>();
    private Map<Button, TextView> buttonTextViewMap = new HashMap<>();
    private int contador = 0;
    private int dado1, dado2, dado3;
    private Button button, btnFuerza, btnDestreza, btnConstitucion, btnInteligencia, btnSabiduria, btnCarisma;

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

        buttonTextViewMap.put(btnFuerza, fuerza);
        buttonTextViewMap.put(btnDestreza, destreza);
        buttonTextViewMap.put(btnConstitucion, constitucion);
        buttonTextViewMap.put(btnInteligencia, inteligencia);
        buttonTextViewMap.put(btnSabiduria, sabiduria);
        buttonTextViewMap.put(btnCarisma, carisma);

        // Inicializa las listas de ImageView para cada botón
        List<ImageView> dadosFuerza = new ArrayList<>();
        dadosFuerza.add(findViewById(R.id.imageViewDado1F));
        dadosFuerza.add(findViewById(R.id.imageViewDado2F));
        dadosFuerza.add(findViewById(R.id.imageViewDado3F));
        buttonDiceMap.put(btnFuerza, dadosFuerza);

        // Repite este bloque para los otros botones y sus respectivas ImageView
        // ...

        dados.add(R.drawable.dado0);
        dados.add(R.drawable.dado1);
        dados.add(R.drawable.dado2);
        dados.add(R.drawable.dado3);
        dados.add(R.drawable.dado4);
        dados.add(R.drawable.dado5);
        dados.add(R.drawable.dado6);
    }

    public void generarAtributo(View view) {
        button = (Button) view;
        TextView textView = buttonTextViewMap.get(button);

        int valorAtributo = lanzarDados(button);

        // Actualiza las ImageView con los valores de los dados asociados al botón
        List<ImageView> dadosImageView = buttonDiceMap.get(button);
        for (int i = 0; i < dadosImageView.size(); i++) {
            dadosImageView.get(i).setImageResource(dados.get(i));
        }

        textView.setText(String.valueOf(valorAtributo));
        button.setEnabled(false);

        contador++;
        checkFinalizar();
    }

    private int lanzarDados(Button button) {
        List<ImageView> dadosImageView = buttonDiceMap.get(button);

        Random random = new Random();
        int sumaDados = 0;

        for (int i = 0; i < dadosImageView.size(); i++) {
            int valorDado = random.nextInt(6) + 1;
            dados.set(i, valorDado);
            sumaDados += valorDado;
        }

        return sumaDados;
    }

    private void checkFinalizar() {
        if (contador == 6) {
            String resultado = fuerza.getText() + "-" + destreza.getText() + "-" +
                    constitucion.getText() + "-" + inteligencia.getText() + "-" +
                    sabiduria.getText() + "-" + carisma.getText();

            setResult(RESULT_OK, getIntent().putExtra("resultado", resultado));
            finish();
        }
    }
}



//    TextView fuerza, destreza, constitucion, inteligencia, sabiduria, carisma;
//    Button btnFuerza, btnDestreza, btnConstitucion, btnInteligencia, btnSabiduria, btnCarisma;
//    int contador = 0;
//    int valorFuerza, valorDestreza, valorConstitucion, valorInteligencia, valorSabiduria, valorCarisma;
//
//    List<Integer> dados = new LinkedList<>();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_estadisticas);
//
//        fuerza = findViewById(R.id.NFuerza);
//        destreza = findViewById(R.id.NDestreza);
//        constitucion = findViewById(R.id.NConstitucion);
//        inteligencia = findViewById(R.id.NInteligencia);
//        sabiduria = findViewById(R.id.NSabiduria);
//        carisma = findViewById(R.id.NCarisma);
//
//        btnFuerza = findViewById(R.id.btnFuerza);
//        btnDestreza = findViewById(R.id.btnDestreza);
//        btnConstitucion = findViewById(R.id.btnConstitucion);
//        btnInteligencia = findViewById(R.id.btnInteligencia);
//        btnSabiduria = findViewById(R.id.btnSabiduria);
//        btnCarisma = findViewById(R.id.btnCarisma);
//        dados.add(R.drawable.dado0);
//        dados.add(R.drawable.dado1);
//        dados.add(R.drawable.dado2);
//        dados.add(R.drawable.dado3);
//        dados.add(R.drawable.dado4);
//        dados.add(R.drawable.dado5);
//        dados.add(R.drawable.dado6);
//
//    }
//
//    public void generarFuerza(View view) {
//        valorFuerza = lanzarDados();
//        ImageView d1f=findViewById(R.id.d1F);
//        d1f.setImageResource(dados.get(valorFuerza));
//        Log.d("Habilidades", "Valor de Fuerza: " + valorFuerza);
//        fuerza.setText(String.valueOf(valorFuerza));
//        btnFuerza.setEnabled(false);
//        checkFinalizar();
//    }
//
//    public void generarDestreza(View view) {
//        valorDestreza = lanzarDados();
//        Log.d("Habilidades", "Valor de Destreza: " + valorDestreza);
//        destreza.setText(String.valueOf(valorDestreza));
//        btnDestreza.setEnabled(false);
//        checkFinalizar();
//    }
//
//    public void generarConstitucion(View view) {
//        valorConstitucion = lanzarDados();
//        Log.d("Habilidades", "Valor de Constitución: " + valorConstitucion);
//        constitucion.setText(String.valueOf(valorConstitucion));
//        btnConstitucion.setEnabled(false);
//        checkFinalizar();
//    }
//
//    public void generarInteligencia(View view) {
//        valorInteligencia = lanzarDados();
//        Log.d("Habilidades", "Valor de Inteligencia: " + valorInteligencia);
//        inteligencia.setText(String.valueOf(valorInteligencia));
//        btnInteligencia.setEnabled(false);
//        checkFinalizar();
//    }
//
//    public void generarSabiduria(View view) {
//        valorSabiduria = lanzarDados();
//        Log.d("Habilidades", "Valor de Sabiduría: " + valorSabiduria);
//        sabiduria.setText(String.valueOf(valorSabiduria));
//        btnSabiduria.setEnabled(false);
//        checkFinalizar();
//    }
//
//    public void generarCarisma(View view) {
//        valorCarisma = lanzarDados();
//        Log.d("Habilidades", "Valor de Carisma: " + valorCarisma);
//        carisma.setText(String.valueOf(valorCarisma));
//        btnCarisma.setEnabled(false);
//        checkFinalizar();
//    }
//
//    private int lanzarDados() {
//        Random random = new Random();
//        int dado1 = random.nextInt(6) + 1;
//        int dado2 = random.nextInt(6) + 1;
//        int dado3 = random.nextInt(6) + 1;
//        contador++;
//        return dado1 + dado2 + dado3;
//    }
//
//    private void checkFinalizar() {
//        if (contador == 6) {
//            String resultado = valorFuerza + "-" + valorDestreza + "-" + valorConstitucion + "-" +
//                    valorInteligencia + "-" + valorSabiduria + "-" + valorCarisma;
//            setResult(RESULT_OK, getIntent().putExtra("resultado", resultado));
//            finish();
//        }
//    }
//}
