package com.example.spinner2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText1, editText2;
    private TextView textView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);

        String[] operaciones = {"suma", "resta", "multiplicacion", "division", "modulo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operaciones);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String operacion = (String) parentView.getItemAtPosition(position);
                String strNumero1 = editText1.getText().toString();
                String strNumero2 = editText2.getText().toString();

                // Verificar si las cadenas están vacías antes de intentar convertirlas
                if (!strNumero1.isEmpty() && !strNumero2.isEmpty()) {
                    try {
                        int numero1 = Integer.parseInt(strNumero1);
                        int numero2 = Integer.parseInt(strNumero2);

                        switch (operacion) {
                            case "suma":
                                textView.setText(String.valueOf(numero1 + numero2));
                                break;
                            case "resta":
                                textView.setText(String.valueOf(numero1 - numero2));
                                break;
                            case "multiplicacion":
                                textView.setText(String.valueOf(numero1 * numero2));
                                break;
                            case "division":
                                textView.setText(String.valueOf(numero1 / numero2));
                                break;
                            case "modulo":
                                textView.setText(String.valueOf(numero1 % numero2));
                                break;
                        }
                    } catch (NumberFormatException e) {
                        // Manejar la excepción, por ejemplo, mostrando un mensaje de error
                        textView.setText("Ingrese números válidos");
                    }
                } else {
                    // Manejar el caso cuando las cadenas están vacías
                    textView.setText("Ingrese números válidos");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // En este ejemplo, no hacemos nada cuando no se selecciona nada en el spinner.
            }
        });
    }
}