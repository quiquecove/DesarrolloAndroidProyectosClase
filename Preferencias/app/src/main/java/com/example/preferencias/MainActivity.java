package com.example.preferencias;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    EditText et1;
    EditText et2;
    String dato1;
    String dato2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
    }

    public void guardar(View view) {
        pref = getSharedPreferences("x", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        // Use a unique identifier for each set of data
        String uniqueKey = String.valueOf(System.currentTimeMillis());
        dato1 = et1.getText().toString();
        dato2 = et2.getText().toString();

        // Use the unique key to store the data
        editor.putString(dato1 , dato2);
        editor.apply();
        et1.setText("");
        et2.setText("");

    }

    public void consultar(View view) {
    SharedPreferences  pref = getSharedPreferences("x", MODE_PRIVATE);

        // You need to know the unique key associated with the data you want to retrieve
        String uniqueKey = et1.getText().toString();

        // Use the unique key to retrieve the data
        String valor = pref.getString(uniqueKey ,"");
        et2.setText(valor);
    }
}
