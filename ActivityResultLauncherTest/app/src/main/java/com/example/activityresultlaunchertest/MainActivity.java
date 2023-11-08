package com.example.activityresultlaunchertest;

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

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ActivityResultLauncher<Intent> startActivityForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);

    }

    ActivityResultLauncher<Intent> startForResult =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            int resultCode = result.getResultCode();
                            if (resultCode == RESULT_OK) {
                                String n = result.getData().getStringExtra("nom");
                                String a = result.getData().getStringExtra("ape");
                                String a2 = result.getData().getStringExtra("ape2");
                                String res = "Hola " + n + " " + a + " " + a2+", que bueno tenerte de vuelta";
                                tv.setText(res);
                            } else {

                                Toast.makeText(getApplicationContext(), "Resultado cancelado", Toast.LENGTH_LONG).show();
                            }

                        }
                    });

    public void form(View view) {
        Intent i = new Intent(this, MainActivity2.class);
        startForResult.launch(i);
    }
}