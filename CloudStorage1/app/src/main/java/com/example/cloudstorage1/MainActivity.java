package com.example.cloudstorage1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    ImageView imagen;
    Bitmap foto;
    Button tomarFoto, subirFoto;
    ActivityResultLauncher<Intent> cameraLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen = findViewById(R.id.imageView);
        tomarFoto = findViewById(R.id.caputurar);
        subirFoto = findViewById(R.id.subir);

        cameraLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            // La foto fue tomada con éxito
                            Toast.makeText(getApplicationContext(), "Foto tomada correctamente", Toast.LENGTH_SHORT).show();
                            foto = (Bitmap) result.getData().getExtras().get("data");
                            imagen.setImageBitmap(foto);
                        } else {
                            // Error al tomar la foto
                            Toast.makeText(getApplicationContext(), "Error al tomar la foto", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void capturar(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            cameraLauncher.launch(takePictureIntent);
        }
    }

    public void subir(View view) {
        foto = ((BitmapDrawable) imagen.getDrawable()).getBitmap();
        // Convertir el bitmap en un array de bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        foto.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        // Generar un nombre único para el archivo
        String fileName = UUID.randomUUID().toString() + ".jpg";

        // Referencia a la ubicación en Cloud Storage donde se almacenará la imagen
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference imageRef = storageRef.child("imagenes/" + fileName);

        // Subir la imagen a Cloud Storage
        Toast.makeText(getApplicationContext(), "Foto Subida", Toast.LENGTH_SHORT).show();

    }

    public void seleccionarImagenAleatoria(View view) {
        StorageReference fotosRef = FirebaseStorage.getInstance().getReference().child("imagenes");
        fotosRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                // Obtener una imagen aleatoria de la lista de imágenes disponibles
                int randomIndex = new Random().nextInt(listResult.getItems().size());
                StorageReference randomImageRef = listResult.getItems().get(randomIndex);

                // Descargar la imagen aleatoria y mostrarla usando Glide
                randomImageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Glide.with(MainActivity.this).load(uri).into(imagen);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error al cargar la imagen", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error al obtener la lista de imágenes", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
