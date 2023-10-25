package com.example.datoscuriosos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListaHechos lista1 = new ListaHechos();
    Colores lColor = new Colores();
    ArrayList<String> listaDatos;
    ArrayList<Integer> listaColores;
    int[] aux;
    CheckBox cb;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //System.out.println(getString(R.string.dato1));
        listaDatos = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.ArrayHechos)));
        lista1.setLista(listaDatos);
        cb = findViewById(R.id.checkBox);
        btn=findViewById(R.id.btn);

        aux = getResources().getIntArray(R.array.ArrayColores);

        listaColores = new ArrayList<>();

        for (int p : aux) {

            listaColores.add(p);
        }
        lColor.setLista(listaColores);


    }
    public void check(View view){
        if (cb.isChecked()) {
            Toast.makeText(getApplicationContext(), "Casilla marcada", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Casilla desmarcada", Toast.LENGTH_SHORT).show();

        }
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
        if (cb.isChecked()){
            cambiar(view);
            //extractedI(da);
            //rl.setBackgroundColor(lColor.RandomColor());

        }else {
            extracted1(da);
            rl.setBackgroundColor(lColor.color());

        }

    }

    public void cambiarCtn(View view) {
        TextView da = findViewById(R.id.dato);
        ConstraintLayout rl = findViewById(R.id.backgroundCol);

        if (cb.isChecked()){
            //performclick
            btn.performClick();
            //cambiar(view);
            //extractedI(da);
            //rl.setBackgroundColor(lColor.RandomColor());

        }else{


            extractedI(da);
            rl.setBackgroundColor(lColor.color2());

        }

    }

    public void cambiarRgt(View view) {
        TextView da = findViewById(R.id.dato);
        ConstraintLayout rl = findViewById(R.id.backgroundCol);
        if (cb.isChecked()){
            btn.callOnClick();
            //cambiar(view);
            // extractedI(da);
            //rl.setBackgroundColor(lColor.RandomColor());

        }else {
            extractedD(da);
            rl.setBackgroundColor(lColor.color3());
        }

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