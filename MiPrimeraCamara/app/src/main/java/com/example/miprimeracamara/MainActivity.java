package com.example.miprimeracamara;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    Button btnCam;
    String rutaImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.imageView);
        btnCam = findViewById(R.id.button);

        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCam();
            }
        });
    }

    //miniatura foto camara

//    ActivityResultLauncher<Intent> startForResult =
//            registerForActivityResult(
//                    new ActivityResultContracts.StartActivityForResult(),
//                    new ActivityResultCallback<ActivityResult>() {
//                        @Override
//                        public void onActivityResult(ActivityResult result) {
//                            if (result.getResultCode() == RESULT_OK) {
//                                Bundle extras=result.getData().getExtras();
//                                Bitmap imgBitmap=(Bitmap) extras.get("data");
//                                iv.setImageBitmap(imgBitmap);
//                            }
//                        }
//                    });
//
//    public void abrirCam() {
//        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startForResult.launch(i);
//    }


    ActivityResultLauncher<Intent> startForResult =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == RESULT_OK) {
                                Bundle extras = result.getData().getExtras();
                                Bitmap imgBitmap = (Bitmap) extras.get("data");
                                iv.setImageBitmap(imgBitmap);
                            }
                        }
                    });

    public void abrirCam() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (i.resolveActivity(getPackageManager()) != null) {
            File imagenArchivo = null;
            try {
                imagenArchivo = crearImagen();

            } catch (Exception e) {
                Log.e("error al crear",e.toString());
            }
        }
        startForResult.launch(i);
    }

    private File crearImagen() throws IOException {
        String nombreImagen = "foto_";
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagen = File.createTempFile(nombreImagen, "jpg", directorio);
        rutaImagen = imagen.getAbsolutePath();
        return imagen;
    }

}