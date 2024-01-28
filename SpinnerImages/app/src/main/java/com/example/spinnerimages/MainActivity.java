package com.example.spinnerimages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Integer> imagenes = new ArrayList<>();
    List<String> casas = new ArrayList<>();
    String casaSeleccionada;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarDatos();

        iconosAdapter adaptadorIconos = new iconosAdapter();

        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adaptadorIconos);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                casaSeleccionada = casas.get(i);
                Toast.makeText(getApplicationContext(), "Perteneces a la casa " + casaSeleccionada, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void cargarDatos() {
        imagenes.add(R.drawable.gryffindor);
        imagenes.add(R.drawable.hufflepuff);
        imagenes.add(R.drawable.ravenclaw);
        imagenes.add(R.drawable.slytherin);

        casas.add("Gryffindor");
        casas.add("Hufflepuff");
        casas.add("Ravenclaw");
        casas.add("Slytherin");
    }

    class iconosAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imagenes.size();
        }

        @Override
        public Object getItem(int position) {
            return imagenes.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            convertView = inflater.inflate(R.layout.itemspinner, null);

            ImageView iv1 = convertView.findViewById(R.id.imageView);
            TextView tv1 = convertView.findViewById(R.id.tvClase);

            iv1.setImageResource(imagenes.get(position));
            tv1.setText(casas.get(position));

            return convertView;
        }
    }
}
