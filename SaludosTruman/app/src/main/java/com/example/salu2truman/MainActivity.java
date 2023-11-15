package com.example.salu2truman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBoxDia;
    private CheckBox checkBoxTarde;
    private CheckBox checkBoxNoche;
    private RadioGroup radioGroupSaludo;
    private RadioButton radioButtonSr;
    private RadioButton radioButtonSrta;
    private RadioButton radioButtonNA;
    private EditText et2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxDia = findViewById(R.id.checkBoxDia);
        checkBoxTarde = findViewById(R.id.checkBoxTarde);
        checkBoxNoche = findViewById(R.id.checkBoxNoche);
        radioGroupSaludo = findViewById(R.id.radioGroupSaludo);
        radioButtonSr = findViewById(R.id.radioButtonSr);
        radioButtonSrta = findViewById(R.id.radioButtonSrta);
        radioButtonNA = findViewById(R.id.radioButtonNA);
        et2 = findViewById(R.id.etape);
        tv = findViewById(R.id.tv);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("ape")) {
            String apell = intent.getStringExtra("ape");
            et2.setText(String.valueOf(apell));
        } else {
            Toast.makeText(this, "Debe proporcionar un apellido", Toast.LENGTH_SHORT).show();
        }
    }

    public void saludarConCheckBox(View view) {
        StringBuilder saludo = new StringBuilder("");

        if (checkBoxDia.isChecked()) {
            saludo.append("Buenos días, ");
        }

        if (checkBoxTarde.isChecked()) {
            saludo.append("Buenas tardes, ");
        }

        if (checkBoxNoche.isChecked()) {
            saludo.append("Buenas noches, ");
        }

        int selectedRadioButtonId = radioGroupSaludo.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String apellido = et2.getText().toString();

        if (selectedRadioButton == radioButtonSr) {
            saludo.append("Sr." + apellido);
        } else if (selectedRadioButton == radioButtonSrta) {
            saludo.append("Srta. " + apellido);
        } else if (selectedRadioButton == radioButtonNA) {
            saludo.append("" + apellido);
        }

        tv.setText(saludo.toString());
        tv.setVisibility(View.VISIBLE);

        Intent data = new Intent();
        data.putExtra("saludo", String.valueOf(saludo));
        setResult(RESULT_OK, data);
        finish();
    }


    public void saludarConTruman(View view) {
        String apellido = et2.getText().toString();
        StringBuilder saludo = new StringBuilder("Y por si no nos vemos luego: ¡Buenos días, buenas tardes y buenas noches! "+apellido);

        Intent data = new Intent();
        data.putExtra("saludo", String.valueOf(saludo));
        setResult(RESULT_OK, data);
        finish();
        tv.setText(saludo.toString());
        tv.setVisibility(View.VISIBLE);
    }
}
