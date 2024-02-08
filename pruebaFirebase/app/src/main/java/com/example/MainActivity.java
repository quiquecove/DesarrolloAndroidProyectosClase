package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pruebafirebase.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth miFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miFirebaseAuth = FirebaseAuth.getInstance();


    }




}