package com.example.firebase_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference ref;
    EditText nombre;
    TextView tv;
    //private FirebaseAuth miFirebaseAuth;
    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.etnombre);
        tv = findViewById(R.id.tv);
        //miFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);



    }

    public void insertar(View view){
//necesito insertar el nombre en la base de datos junto a un child llamado nombre

        FirebaseDatabase.getInstance().getReference().child("nombre").setValue(nombre.getText().toString());
        tv.setText("Se ha insertado el nombre en la base de datos");



    }



}