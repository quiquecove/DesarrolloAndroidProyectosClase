package com.example.miprimere_mail;


import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etcorreo;
    EditText etasunto;
    EditText etmcorreo;
    Button btnenviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etcorreo = findViewById(R.id.etnombre);
        etasunto = findViewById(R.id.etasunto);
        etmcorreo = findViewById(R.id.etmensaje);
        btnenviar = findViewById(R.id.btnenviar);

        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mandarMail();
            }
        });
    }

//    ActivityResultLauncher<Intent> startForResult =
//            registerForActivityResult(
//                    new ActivityResultContracts.StartActivityForResult(),
//                    new ActivityResultCallback<Instrumentation.ActivityResult>() {
//                        @Override
//                        public void onActivityResult(ActivityResult result) {
//                            if (result.getResultCode() == RESULT_OK) {
//                                Bundle extras = result.getData().getExtras();
//
//                            }
//                        }
//                    });

    public void mandarMail() {
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:" + etcorreo.getText().toString()));
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{etcorreo.getText().toString()});
        i.putExtra(Intent.EXTRA_SUBJECT, etasunto.getText().toString());
        i.putExtra(Intent.EXTRA_TEXT, etmcorreo.getText().toString());

        //startForResult.launch(i);
        startActivity(i);
    }
}