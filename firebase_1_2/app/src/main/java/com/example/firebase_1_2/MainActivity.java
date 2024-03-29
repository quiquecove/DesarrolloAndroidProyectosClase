package com.example.firebase_1_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;
    EditText nombre, apellido, edad, hobbies;
    Switch adulto;
    DatabaseReference raiz;
    ChildEventListener bartChildEventListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseDatabase.getInstance();
        nombre = findViewById(R.id.etnombre);
        apellido = findViewById(R.id.apellido);
        edad = findViewById(R.id.edad);
        hobbies = findViewById(R.id.hobbies);
        adulto = findViewById(R.id.adulto);

        raiz = db.getReference();
        bartChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String nuevoPersonaje = dataSnapshot.getKey();
                if (!nuevoPersonaje.equalsIgnoreCase("Milhouse")) {
                    insertarMilhouseAmigoOcupa(nuevoPersonaje);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        //vListener=bartChildEventListener;
        raiz.addChildEventListener(bartChildEventListener);


        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String nuevoPersonaje = snapshot.getKey();
                    if (!nuevoPersonaje.equalsIgnoreCase("Milhouse")) {
                        insertarMilhouseAmigoOcupa(nuevoPersonaje);
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Manejar errores de cancelación
            }
        };

        raiz.addListenerForSingleValueEvent(vListener);





        //raiz.addListenerForSingleValueEvent(vListener);
        //que solo se ejecute una vez
        //addListenerforSingleValueEvent(ValueEventListener vListener);

    }

    String nombreRaiz;


    public void insertar(View view) {

        DatabaseReference ref = db.getReference().child(nombre.getText().toString()).child("Nombre");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (Objects.equals(dataSnapshot.getValue(), "Bart")) {
                    String data = nombre.getText().toString();
                    db.getReference().child("Bart").child("Amigos").child("Milhouse").child("Nombre").setValue("Milhouse");

                    DatabaseReference rf = db.getReference().child("Bart").child("Amigos").child("Milhouse").child("Apellido");
                    rf.setValue(apellido.getText().toString());

                    rf = db.getReference().child("Bart").child("Amigos").child("Milhouse").child("Edad");
                    rf.setValue(Integer.valueOf(edad.getText().toString()));

                    rf = db.getReference().child("Bart").child("Amigos").child("Milhouse").child("Hobbies");
                    List<String> hobysList = Arrays.asList(hobbies.getText().toString().split(","));
                    rf.setValue(hobysList);

                    rf = db.getReference().child("Bart").child("Amigos").child("Milhouse").child("Adulto");
                    rf.setValue(adulto.isChecked());

                    //childListener
//        ref.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                // ...
//
//                if(dataSnapshot.getKey().equalsIgnoreCase("Bart")){
//
//
//                    String data = nombre.getText().toString();
//                    db.getReference().child("Bart").child("Amigos").child("Milhouse").child("Nombre").setValue("Milhouse");
//
//                    DatabaseReference rf = db.getReference().child("Bart").child("Amigos").child("Milhouse").child("Apellido");
//                    rf.setValue(apellido.getText().toString());
//
//                    rf = db.getReference().child("Bart").child("Amigos").child("Milhouse").child("Edad");
//                    rf.setValue(Integer.valueOf(edad.getText().toString()));
//
//                    rf = db.getReference().child("Bart").child("Amigos").child("Milhouse").child("Hobbies");
//                    List<String> hobysList = Arrays.asList(hobbies.getText().toString().split(","));
//                    rf.setValue(hobysList);
//
//                    rf = db.getReference().child("Bart").child("Amigos").child("Milhouse").child("Adulto");
//                    rf.setValue(adulto.isChecked());


                } else {
                    // El nodo no existe

                    if (nombre.getText().toString().equalsIgnoreCase("Bart")) {

                        db.getReference().child("Milhouse").child("Nombre").setValue("Milhouse");

                        DatabaseReference rf = db.getReference().child("Milhouse").child("Apellido");

                        rf.setValue("VanPuto");

                        rf = db.getReference().child("Milhouse").child("Edad");
                        rf.setValue(Integer.valueOf(edad.getText().toString()));

                        rf = db.getReference().child("Milhouse").child("Hobys");

                        List<String> hobysList = Arrays.asList("jugar", "videojuegos");
                        rf.setValue(hobysList);

                        rf = db.getReference().child("Milhouse").child("Adulto");
                        rf.setValue(false);
                    }
                    String data = nombre.getText().toString();
                    db.getReference().child(nombre.getText().toString()).child("Nombre").setValue(data);

                    DatabaseReference rf = db.getReference().child(nombre.getText().toString()).child("Apellido");

                    rf.setValue(apellido.getText().toString());

                    rf = db.getReference().child(nombre.getText().toString()).child("Edad");
                    rf.setValue(Integer.valueOf(edad.getText().toString()));

                    rf = db.getReference().child(nombre.getText().toString()).child("Hobbies");

                    List<String> hobbiesList = Arrays.asList(hobbies.getText().toString().split(","));
                    rf.setValue(hobbiesList);

                    rf = db.getReference().child(nombre.getText().toString()).child("Adulto");
                    rf.setValue(adulto.isChecked());
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });
//        String data = nombre.getText().toString();
//        db.getReference().child(nombre.getText().toString()).child("Nombre").setValue(data);
//        nombreRaiz = nombre.getText().toString();
//        DatabaseReference rf = db.getReference().child("Homer").child("Apellido");
//        rf.setValue(apellido.getText().toString());
//
//        rf = db.getReference().child("Homer").child("Edad");
//        rf.setValue(Integer.valueOf(edad.getText().toString()));
//
//        rf = db.getReference().child("Homer").child("Hobbies");
//        List<String> hobysList = Arrays.asList(hobbies.getText().toString().split(","));
//        rf.setValue(hobysList);
//
//        rf = db.getReference().child("Homer").child("Adulto");
//        rf.setValue(adulto.isChecked());
//
//        Toast.makeText(this, "Se ha insertado el nombre en la base de datos", Toast.LENGTH_SHORT).show();

    }
//    public void insertar(View view) {
//        db.getReference().child(nombre.getText().toString()).child("Nombre").setValue(nombre.getText().toString());
//
//    }


    private void insertarMilhouseAmigoOcupa(String nuevoPersonaje) {
        DatabaseReference nodoPadre = raiz.child(nuevoPersonaje).child("Amigos").child("Milhouse");
        nodoPadre.child("Nombre").setValue("Milhouse");
        nodoPadre.child("Apellido").setValue("Van Houten");
        nodoPadre.child("Edad").setValue(10);
        nodoPadre.child("Hobbies").setValue(Arrays.asList("Jugar con Bart", "Acosar a Lisa"));
        nodoPadre.child("EsAdulto").setValue(false);

        // Agregar a Milhouse como amigo del personaje recién insertado jeje
        DatabaseReference refAmigo = raiz.child("Milhouse").child("Amigos").child(nuevoPersonaje);
        refAmigo.child("Nombre").setValue(nuevoPersonaje);
        refAmigo.child("Apellido").setValue("");
        refAmigo.child("Edad").setValue(0);
        refAmigo.child("Hobbies").setValue(Arrays.asList());
        refAmigo.child("EsAdulto").setValue(false);

        Toast.makeText(MainActivity.this, "Milhouse insertado como amigo de " + nuevoPersonaje, Toast.LENGTH_SHORT).show();
    }

    public void insertarAmigo(View view) {
//        DatabaseReference rf = db.getReference().child("Homer").child("Amigos");
//        rf.setValue(nombre.getText().toString());
        DatabaseReference rf = db.getReference().child("Homer").child("Amigos").push();
//        rf = db.getReference().child("Homer").child("Amigos").child(nombre.getText().toString());
        rf = db.getReference().child(nombreRaiz).child("Amigos").child(nombre.getText().toString());
        rf.child("Apellido").setValue(apellido.getText().toString());
        rf.child("Edad").setValue(Integer.valueOf(edad.getText().toString()));
        rf.child("Hobbies").setValue(Arrays.asList(hobbies.getText().toString().split(",")));
        rf.child("Adulto").setValue(adulto.isChecked());
    }

    public void eliminarAmigo(View view) {
        DatabaseReference rf = db.getReference().child("Homer").child("Amigos").child(nombre.getText().toString());
        rf.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Amigo eliminado con éxito", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error al eliminar amigo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void  listar(View view){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Aquí puedes acceder a cada nodo
                    System.out.println(snapshot.getKey());
                    for (DataSnapshot snapshotHijo : snapshot.getChildren()) {
                        System.out.print(snapshotHijo.getKey() + " - " + snapshotHijo.getValue());
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Manejar errores
            }
        });

    }
}


