package com.example.proyectofinalandroidev1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.OnNewIntentProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;

public class Login extends AppCompatActivity {
EditText etnombre;
AdminSQLiteOpenHelper gestor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnombre=findViewById(R.id.etnombre);
        gestor = new AdminSQLiteOpenHelper(this, "PERSONAJESDND", null, 1);

    }
    ActivityResultLauncher<Intent> startForResult =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == RESULT_OK) {
                                String res = result.getData().getStringExtra("saludo");
                                Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
                                etnombre.setText("");
                            } else {

                                Toast.makeText(getApplicationContext(), "Resultado cancelado", Toast.LENGTH_LONG).show();
                                etnombre.setText("");

                            }

                        }
                    });

    public void crearPersonaje(View view){
        Intent i = new Intent(this, MenuCreacion.class);
        i.putExtra("nombrej",String.valueOf(etnombre.getText()));
        startForResult.launch(i);

    }

    public void verLista(View view){
        Intent i= new Intent(this,ListaPersonajes.class);
        startActivity(i);
    }


}