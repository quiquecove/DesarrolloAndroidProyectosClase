package com.example.fragmentoestatico1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContadorFragmento extends Fragment {

    EditText et;
    Button btn;
    TextView tv;

    public ContadorFragmento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contador_fragmento, container, false);

        et = view.findViewById(R.id.etmLetras);
        btn = view.findViewById(R.id.button);
        tv = view.findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                String texto = et.getText().toString();
                int cantidad = texto.length();
                tv.setText("Cantidad de letras: " + cantidad);
            }
        });

        return view;
    }


}