package com.example.proyectofinalandroidev1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name,
                                 @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL("DROP TABLE PERSONAJESDND");
        // Create the first table
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS PERSONAJESDND ("
                + "NOMBREJUGADOR TEXT, "
                + "NOMBREPERSONAJE TEXT, "
                + "CLASE TEXT,"
                + "FUERZA INT,"
                + "DESTREZA INT,"
                + "CONSTITUCION INT,"
                + "INTELIGENCIA INT,"
                + "SABIDURIA INT,"
                + "CARISMA INT,"
                + "HABILIDADES TEXT,"
                + "PRIMARY KEY (NOMBREJUGADOR, NOMBREPERSONAJE))");
    }


        @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Add any necessary upgrade logic here
    }
}

