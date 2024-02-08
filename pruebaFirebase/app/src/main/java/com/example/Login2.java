package com.example;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pruebafirebase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login2 extends AppCompatActivity {
    private FirebaseAuth miFirebaseAuth;
    private FirebaseAuth fba;
    private FirebaseUser user;
    private EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        miFirebaseAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.usr);
        password=findViewById(R.id.pass);



    }


    public void acceder(View view){
        miFirebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = miFirebaseAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login2.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }}});




    }


    public void registrar(View view){
        miFirebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = miFirebaseAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Login2.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }}});
    }

//    private void login(){
//        String email1=email.getText().toString();
//        String password1=password.getText().toString();
//        if(email1.isEmpty()){
//            email.setError("Por favor ingrese su correo");
//            email.requestFocus();
//        }
//        else if(password1.isEmpty()){
//            password.setError("Por favor ingrese su contraseña");
//            password.requestFocus();
//        }
//        else if(email1.isEmpty() && password1.isEmpty()){
//            Toast.makeText(Login2.this,"Campos vacios",Toast.LENGTH_SHORT).show();
//        }
//        else if(!(email1.isEmpty() && password1.isEmpty())){
//            miFirebaseAuth.signInWithEmailAndPassword(email1,password1).addOnCompleteListener(Login2.this, new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
//                    if(!task.isSuccessful()){
//                        Toast.makeText(Login2.this,"Error al iniciar sesion, por favor intente de nuevo",Toast.LENGTH_SHORT).show();
//                    }
//                    else{
//                        user=miFirebaseAuth.getCurrentUser();
//                        Toast.makeText(Login2.this,"Bienvenido",Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//        else{
//            Toast.makeText(Login2.this,"Error",Toast.LENGTH_SHORT).show();
//        }
//    }







}