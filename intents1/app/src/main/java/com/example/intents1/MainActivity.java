package com.example.intents1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void siguiente1(View view) {
        et = findViewById(R.id.nombre);
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("str1", String.valueOf(et.getText()));
        startActivity(i);
    }
}