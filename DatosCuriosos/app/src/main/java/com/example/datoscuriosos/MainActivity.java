package com.example.datoscuriosos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListaHechos lista1 = new ListaHechos();
    Colores lColor = new Colores();
    ArrayList<String> listaDatos;
    ArrayList<Integer> listaColores;
    int[] aux;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //System.out.println(getString(R.string.dato1));
        listaDatos = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.ArrayHechos)));
        lista1.setLista(listaDatos);

        aux = getResources().getIntArray(R.array.ArrayColores);

        listaColores = new ArrayList<>();

        for (int p: aux) {

            listaColores.add(p);
        }
        lColor.setLista(listaColores);


    }

    public void cambiar(View view) {
        TextView da = findViewById(R.id.dato);
        ConstraintLayout rl = findViewById(R.id.backgroundCol);
        extractedI(da);
        rl.setBackgroundColor(lColor.RandomColor());
    }




    public void cambiarIzd(View view) {
        TextView da = findViewById(R.id.dato);
        ConstraintLayout rl = findViewById(R.id.backgroundCol);
        extracted1(da);

        rl.setBackgroundColor(lColor.color());

    }

    public void cambiarCtn(View view) {
        TextView da = findViewById(R.id.dato);
        ConstraintLayout rl = findViewById(R.id.backgroundCol);

        extractedI(da);

        rl.setBackgroundColor(lColor.color2());

    }

    public void cambiarRgt(View view) {
        TextView da = findViewById(R.id.dato);
        ConstraintLayout rl = findViewById(R.id.backgroundCol);

        extractedD(da);

        rl.setBackgroundColor(lColor.color3());

    }

    public void extracted(TextView da) {
        da.setText(lista1.getHechoAleatorio());
    }

    public void extracted1(TextView da) {
        da.setText(lista1.getHecho());
    }

    public void extractedI(TextView da) {
        da.setText(lista1.getHechoAleatorioImpar());
    }

    public void extractedD(TextView da) {
        da.setText(lista1.getHechoVocal());
    }





}