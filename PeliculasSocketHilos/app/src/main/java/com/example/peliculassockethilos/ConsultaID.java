package com.example.peliculassockethilos;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConsultaID extends AppCompatActivity {
    int PUERTO = 2018;
    private EditText getid;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_id);
        getid = findViewById(R.id.etid);
        tv = findViewById(R.id.tres);
    }

    public void consultar(View v) {
        String id = getid.getText().toString();
        new ConsultaPeliculaTask().execute(id);
    }

    private class ConsultaPeliculaTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String id = params[0];
            String resultado = "";

            try (Socket socketAlServidor = new Socket()) {
                InetSocketAddress direccionServidor = new InetSocketAddress("tu_ip_servidor", PUERTO);

                // Intenta conectar al servidor
                socketAlServidor.connect(direccionServidor);

                // Envía la solicitud al servidor
                try (PrintStream salida = new PrintStream(socketAlServidor.getOutputStream())) {
                    String result = "1" + "-" + id;
                    salida.println(result);
                }

                // Lee la respuesta del servidor
                try (InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
                     BufferedReader bf = new BufferedReader(entrada)) {
                    resultado = bf.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
                resultado = "Error: " + e.getMessage();
            }

            return resultado;
        }

        @Override
        protected void onPostExecute(String resultado) {
            // Actualiza la interfaz de usuario con el resultado
            tv.setText(resultado);
        }
    }
}
