package com.example.proyectofinalandroidev1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Estadisticas extends AppCompatActivity {

    private TextView fuerza, destreza, constitucion, inteligencia, sabiduria, carisma;
    private Map<Button, List<ImageView>> buttonDiceMap = new HashMap<>();
    private Map<Button, TextView> buttonTextViewMap = new HashMap<>();
    private int contador = 0;
    private Button button, btnFuerza, btnDestreza, btnConstitucion, btnInteligencia, btnSabiduria, btnCarisma;
    private List<Integer> dados = new ArrayList<>();

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

        // Asociar botones con listas de ImageView
        buttonDiceMap.put(btnFuerza, asociarDados(R.id.d1F, R.id.d2F, R.id.d3F));
        buttonDiceMap.put(btnDestreza, asociarDados(R.id.d1D, R.id.d2D, R.id.d3D));
        buttonDiceMap.put(btnConstitucion, asociarDados(R.id.d1C, R.id.d2C, R.id.d3C));
        buttonDiceMap.put(btnInteligencia, asociarDados(R.id.d1I, R.id.d2I, R.id.d3I));
        buttonDiceMap.put(btnSabiduria, asociarDados(R.id.d1S, R.id.d2S, R.id.d3S));
        buttonDiceMap.put(btnCarisma, asociarDados(R.id.d1CAR, R.id.d2CAR, R.id.d3CAR));

        // Inicializar dados con los recursos de las imágenes
        dados.add(R.drawable.dado1);
        dados.add(R.drawable.dado2);
        dados.add(R.drawable.dado3);
        dados.add(R.drawable.dado4);
        dados.add(R.drawable.dado5);
        dados.add(R.drawable.dado6);
    }

    private List<ImageView> asociarDados(int id1, int id2, int id3) {
        List<ImageView> dados = new ArrayList<>();
        dados.add(findViewById(id1));
        dados.add(findViewById(id2));
        dados.add(findViewById(id3));
        return dados;
    }

    public void generarAtributo(View view) {
        button = (Button) view;
        TextView textView = buttonTextViewMap.get(button);

        // Generar 3 números aleatorios entre 1 y 6
        List<Integer> valoresDados = lanzarDados(button);

        // Actualiza las ImageView con los valores de los dados asociados al botón
        List<ImageView> dadosImageView = buttonDiceMap.get(button);

        for (int i = 0; i < dadosImageView.size(); i++) {
            int resourceId = dados.get(valoresDados.get(i) - 1); // Restar 1 porque los índices comienzan en 0
            dadosImageView.get(i).setImageResource(resourceId);
        }

        int sumaDados = valoresDados.stream().mapToInt(Integer::intValue).sum();
        textView.setText(String.valueOf(sumaDados));
        button.setEnabled(false);

        contador++;
        checkFinalizar();
    }

    private List<Integer> lanzarDados(Button button) {
        List<Integer> valoresDados = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int valorDado = random.nextInt(6) + 1;
            valoresDados.add(valorDado);
        }

        return valoresDados;
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
