package com.example.candidatospoliticos;

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
        // Create the first table
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS PARTIDOSPOLITICOS ("
                + "NOMBRE TEXT PRIMARY KEY, "
                + "EDAD INT, "
                + "ESTUDIOS TEXT)");

        // Create the second table with a foreign key constraint
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS OTRA_TABLA ("
                + "NOMBRE_PARTIDO TEXT PRIMARY KEY, "
                + "POLITICO TEXT, "
                + "ESCANNOS INT, "
                + "FOREIGN KEY (POLITICO) REFERENCES PARTIDOSPOLITICOS(NOMBRE))");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Add any necessary upgrade logic here
    }
}
