package com.example.proyectofinalandroidev1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Habilidades extends AppCompatActivity {

    CheckBox checkBoxAtletismo, checkBoxAcrobacias, checkBoxJuegoDeManos,
            checkBoxSigilo, checkBoxArcano, checkBoxHistoria, checkBoxInvestigacion,
            checkBoxNaturaleza, checkBoxReligion, checkBoxMedicina, checkBoxPercepcion,
            checkBoxPerspicacia, checkBoxSupervivencia, checkBoxTratoDeAnimales,
            checkBoxEngano, checkBoxIntimidacion, checkBoxInterpretacion, checkBoxPersuasion;

    int contadorCheckBoxesSeleccionadas = 0;
    int maxCheckBoxes = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habilidades);

        // Inicialización de CheckBox
        checkBoxAtletismo = findViewById(R.id.checkBoxAtletismo);
        checkBoxAcrobacias = findViewById(R.id.checkBoxAcrobacias);
        checkBoxJuegoDeManos = findViewById(R.id.checkBoxJuegoDeManos);
        checkBoxSigilo = findViewById(R.id.checkBoxSigilo);
        checkBoxArcano = findViewById(R.id.checkBoxArcano);
        checkBoxHistoria = findViewById(R.id.checkBoxHistoria);
        checkBoxInvestigacion = findViewById(R.id.checkBoxInvestigacion);
        checkBoxNaturaleza = findViewById(R.id.checkBoxNaturaleza);
        checkBoxReligion = findViewById(R.id.checkBoxReligion);
        checkBoxMedicina = findViewById(R.id.checkBoxMedicina);
        checkBoxPercepcion = findViewById(R.id.checkBoxPercepcion);
        checkBoxPerspicacia = findViewById(R.id.checkBoxPerspicacia);
        checkBoxSupervivencia = findViewById(R.id.checkBoxSupervivencia);
        checkBoxTratoDeAnimales = findViewById(R.id.checkBoxTratoDeAnimales);
        checkBoxEngano = findViewById(R.id.checkBoxEngano);
        checkBoxIntimidacion = findViewById(R.id.checkBoxIntimidacion);
        checkBoxInterpretacion = findViewById(R.id.checkBoxInterpretacion);
        checkBoxPersuasion = findViewById(R.id.checkBoxPersuasion);

        // Asignar OnCheckedChangeListener a cada CheckBox
        asignarListener(checkBoxAtletismo);
        asignarListener(checkBoxAcrobacias);
        asignarListener(checkBoxJuegoDeManos);
        asignarListener(checkBoxSigilo);
        asignarListener(checkBoxArcano);
        asignarListener(checkBoxHistoria);
        asignarListener(checkBoxInvestigacion);
        asignarListener(checkBoxNaturaleza);
        asignarListener(checkBoxReligion);
        asignarListener(checkBoxMedicina);
        asignarListener(checkBoxPercepcion);
        asignarListener(checkBoxPerspicacia);
        asignarListener(checkBoxSupervivencia);
        asignarListener(checkBoxTratoDeAnimales);
        asignarListener(checkBoxEngano);
        asignarListener(checkBoxIntimidacion);
        asignarListener(checkBoxInterpretacion);
        asignarListener(checkBoxPersuasion);
    }

    private void asignarListener(CheckBox checkBox) {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (contadorCheckBoxesSeleccionadas < maxCheckBoxes) {
                        contadorCheckBoxesSeleccionadas++;
                    } else {
                        checkBox.setChecked(false);
                        devolver();
                        // Puedes mostrar un mensaje aquí indicando que ya se han seleccionado 3 habilidades.
                    }
                } else {
                    contadorCheckBoxesSeleccionadas--;
                }
            }
        });
    }


    public void devolver() {
        // Verificar si se han seleccionado exactamente 3 habilidades antes de cerrar la actividad
            // Crear un ArrayList para almacenar las habilidades seleccionadas
            ArrayList<String> habilidadesSeleccionadas = new ArrayList<>();

            // Agregar las habilidades seleccionadas al ArrayList
            agregarHabilidadSeleccionada(checkBoxAtletismo, habilidadesSeleccionadas, "Atletismo");
            agregarHabilidadSeleccionada(checkBoxAcrobacias, habilidadesSeleccionadas, "Acrobacias");
            agregarHabilidadSeleccionada(checkBoxJuegoDeManos, habilidadesSeleccionadas, "Juego de Manos");
            agregarHabilidadSeleccionada(checkBoxSigilo, habilidadesSeleccionadas, "Sigilo");
            agregarHabilidadSeleccionada(checkBoxArcano, habilidadesSeleccionadas, "Arcano");
            agregarHabilidadSeleccionada(checkBoxHistoria, habilidadesSeleccionadas, "Historia");
            agregarHabilidadSeleccionada(checkBoxInvestigacion, habilidadesSeleccionadas, "Investigacion");
            agregarHabilidadSeleccionada(checkBoxNaturaleza, habilidadesSeleccionadas, "Naturaleza");
            agregarHabilidadSeleccionada(checkBoxReligion, habilidadesSeleccionadas, "Religion");
            agregarHabilidadSeleccionada(checkBoxMedicina, habilidadesSeleccionadas, "Medicina");
            agregarHabilidadSeleccionada(checkBoxPercepcion, habilidadesSeleccionadas, "Percepcion");
            agregarHabilidadSeleccionada(checkBoxPerspicacia, habilidadesSeleccionadas, "Perspicacia");
            agregarHabilidadSeleccionada(checkBoxSupervivencia, habilidadesSeleccionadas, "Supervivencia");
            agregarHabilidadSeleccionada(checkBoxTratoDeAnimales, habilidadesSeleccionadas, "Trato de Animales");
            agregarHabilidadSeleccionada(checkBoxEngano, habilidadesSeleccionadas, "Engano");
            agregarHabilidadSeleccionada(checkBoxIntimidacion, habilidadesSeleccionadas, "Intimidacion");
            agregarHabilidadSeleccionada(checkBoxInterpretacion, habilidadesSeleccionadas, "Interpretacion");
            agregarHabilidadSeleccionada(checkBoxPersuasion, habilidadesSeleccionadas, "Persuasion");

            // Devolver las habilidades seleccionadas a la actividad principal
               devolverHabilidadesSeleccionadas(habilidadesSeleccionadas);

        }



    private void agregarHabilidadSeleccionada(CheckBox checkBox, ArrayList<String> habilidadesSeleccionadas, String habilidad) {
        if (checkBox.isChecked()) {
            habilidadesSeleccionadas.add(habilidad);
        }
    }

    private void devolverHabilidadesSeleccionadas(ArrayList<String> habilidadesSeleccionadas) {
        // Concatenar las habilidades seleccionadas en una única cadena
        StringBuilder habilidadesConcatenadas = new StringBuilder();
        for (String habilidad : habilidadesSeleccionadas) {
            habilidadesConcatenadas.append(habilidad).append(", ");
        }
        // Crear el intent y devolver la cadena de habilidades seleccionadas
        Intent resultIntent = new Intent();
        resultIntent.putExtra("habilidadesSeleccionadas", habilidadesConcatenadas.toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }


}
