package com.example.salu2truman;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
EditText etape;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etape=findViewById(R.id.etapellido);
        tv=findViewById(R.id.textView);
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
                                tv.setText(res);
                            } else {

                                Toast.makeText(getApplicationContext(), "Resultado cancelado", Toast.LENGTH_LONG).show();
                                tv.setText("fok");

                            }

                        }
                    });


    public void truman(View view){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("ape",String.valueOf(etape.getText()));
        startForResult.launch(i);
    }
}