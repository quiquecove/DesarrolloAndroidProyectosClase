package com.example.hechos_curiosos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> lista = new ArrayList();
    String dato1 = "dato1";
    String dato2 = "dato2";
    String dato3 = "dato3";
    String dato4 = "dato4";
    String dato5 = "dato5";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista.add(dato1);
        lista.add(dato2);
        lista.add(dato3);
        lista.add(dato4);
        lista.add(dato5);

    }

    public void cambiar(View view) {
        TextView da = findViewById(R.id.dato);

        while (lista.size() > 0) {

            int aux = (int) (Math.random() * 100);

            if (aux < lista.size() ) {

                //System.out.println(aux);
                da.setText(lista.get(aux));
                lista.remove(aux);

            } else {
                da.setText("nada");
            }
        }
    }
}
