package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onBtnClick(View view){
        TextView txtHello=findViewById(R.id.texto);
        TextView email=findViewById(R.id.texto2);

        EditText txt=findViewById(R.id.editable);
        EditText txt2=findViewById(R.id.editable2);
        EditText mail=findViewById(R.id.email);
        txtHello.setText("Hola, "+txt.getEditableText().toString()+" "+txt2.getEditableText().toString()+".");
        email.setText("Email: "+mail.getEditableText().toString());

    }
}