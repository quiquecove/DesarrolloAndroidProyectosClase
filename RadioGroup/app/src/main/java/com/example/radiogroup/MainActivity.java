package com.example.radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonLeft;
    private RadioButton radioButtonRight;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radioButtonLeft = findViewById(R.id.rbtn1);
        radioButtonRight = findViewById(R.id.rbtn2);
        textViewResult = findViewById(R.id.textViewResult);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radioButtonLeft.getId()) {
                    textViewResult.setText("El botón izquierdo está pulsado, mientras que el derecho no lo está");
                } else if (checkedId == radioButtonRight.getId()) {
                    textViewResult.setText("El botón derecho está pulsado, mientras que el izquierdo no lo está");
                }
            }
        });
    }
}
