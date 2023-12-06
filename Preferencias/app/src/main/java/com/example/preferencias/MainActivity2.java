package com.example.preferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity2 extends AppCompatActivity {
    EditText et1;
    EditText etm;
    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1 = findViewById(R.id.fichero);
        etm = findViewById(R.id.etm);
    }

    public void escribir(View v) {
        try {
            txt = etm.getText().toString();
            String fileName = et1.getText().toString() + ".txt";
            FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(txt.getBytes());
            fos.close();
            etm.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leer(View v) {
        try {
            String fileName = et1.getText().toString() + ".txt";
            FileInputStream fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append("\n");
            }

            etm.setText(sb.toString());

            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    