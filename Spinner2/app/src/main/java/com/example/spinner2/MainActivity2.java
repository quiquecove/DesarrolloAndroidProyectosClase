package com.example.spinner2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.sax.TextElementListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
Spinner spinner;
EditText etnombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etnombre=findViewById(R.id.nombre);
        spinner=findViewById(R.id.spinner2);

        String[] operaciones = {"Selecciona","Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operaciones);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String operacion = (String) parentView.getItemAtPosition(position);

                // Verificar si las cadenas están vacías antes de intentar convertirlas


                        switch (operacion) {
                            case "Gryffindor":
                                Toast.makeText(getApplicationContext(), "Hola "+etnombre.getText().toString()+" tu casa es "+ operaciones[1].toString(), Toast.LENGTH_LONG).show();
                                break;
                            case "Hufflepuff":
                                Toast.makeText(getApplicationContext(), "Hola "+etnombre.getText().toString()+" tu casa es "+ operaciones[2].toString(), Toast.LENGTH_LONG).show();
                                break;
                            case "Ravenclaw":
                                Toast.makeText(getApplicationContext(), "Hola "+etnombre.getText().toString()+" tu casa es "+ operaciones[3].toString(), Toast.LENGTH_LONG).show();
                                break;
                            case "Slytherin":
                                Toast.makeText(getApplicationContext(), "Hola "+etnombre.getText().toString()+" tu casa es "+ operaciones[4].toString(), Toast.LENGTH_LONG).show();
                                break;

                        }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // En este ejemplo, no hacemos nada cuando no se selecciona nada en el spinner.
            }
        });
    }
}