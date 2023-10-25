package com.example.salu2truman;

import androidx.appcompat.app.AppCompatActivity;
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
    private EditText et;
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
        et = findViewById(R.id.et);
        et2 = findViewById(R.id.et2);
        tv = findViewById(R.id.tv);
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
        String nombre = et.getText().toString();
        String apellido = et2.getText().toString();

        if (selectedRadioButton == radioButtonSr) {
            saludo.append("Sr. " + nombre + " " + apellido);
        } else if (selectedRadioButton == radioButtonSrta) {
            saludo.append("Srta. " + nombre + " " + apellido);
        } else if (selectedRadioButton == radioButtonNA) {
            saludo.append("" + nombre + " " + apellido);
        }

        tv.setText(saludo.toString());
        tv.setVisibility(View.VISIBLE);
    }

    public void saludarConTruman(View view) {
        StringBuilder saludo = new StringBuilder("Y por si no nos vemos luego: ¡Buenos días, buenas tardes y buenas noches!");
        tv.setText(saludo.toString());
        tv.setVisibility(View.VISIBLE);
    }
}
