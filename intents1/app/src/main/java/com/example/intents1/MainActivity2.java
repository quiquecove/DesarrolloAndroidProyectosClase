package com.example.intents1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.txt2);
        String nuevo = getIntent().getStringExtra("str1");
        tv.setText("Hola "+nuevo+", que bien tenerte de vuelta\nPantalla 2");
        Toast.makeText(getApplicationContext(), "Hola " + nuevo, Toast.LENGTH_SHORT).show();
    }

    public void anterior(View view) {

        startActivity(new Intent(this, MainActivity.class));
    }
}