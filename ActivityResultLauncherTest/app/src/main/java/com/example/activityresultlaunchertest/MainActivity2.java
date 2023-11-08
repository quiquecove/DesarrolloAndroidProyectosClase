package com.example.activityresultlaunchertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText nom;
    EditText ape;
    EditText ape2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void enviar(View view) {
        nom = findViewById(R.id.ed1);
        ape = findViewById(R.id.ed2);
        ape2 = findViewById(R.id.ed3);
        String nombr = String.valueOf(nom.getText());
        String apell = String.valueOf(ape.getText());
        String apell2 = String.valueOf(ape2.getText());

        Intent data = new Intent();
        data.putExtra("nom", nombr);
        data.putExtra("ape", apell);
        data.putExtra("ape2", apell2);
        setResult(RESULT_OK, data);
        finish();

    }

}