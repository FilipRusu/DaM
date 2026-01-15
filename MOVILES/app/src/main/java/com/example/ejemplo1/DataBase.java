package com.example.ejemplo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    // 🔹 Nombre y versión de la base de datos
    private static final String DATABASE_NAME = "mi_base.db";
    private static final int DATABASE_VERSION = 1;

    // 🔹 Tabla
    public static final String TABLE_USUARIOS = "usuarios";

    // 🔹 Columnas
    public static final String COL_ID = "id";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_EMAIL = "email";

    // 🔹 Constructor
    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // 🔹 Se ejecuta la primera vez que se crea la BD
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_USUARIOS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NOMBRE + " TEXT NOT NULL, " +
                COL_EMAIL + " TEXT NOT NULL)";

        db.execSQL(CREATE_TABLE);
    }

    // 🔹 Se ejecuta cuando cambias DATABASE_VERSION
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        onCreate(db);
    }

    // 🔹 INSERTAR
    public boolean insertarUsuario(String nombre, String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NOMBRE, nombre);
        values.put(COL_EMAIL, email);

        long result = db.insert(TABLE_USUARIOS, null, values);
        db.close();

        return result != -1;
    }

    // 🔹 OBTENER TODOS
    public Cursor obtenerUsuarios() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_USUARIOS, null);
    }

    // 🔹 ACTUALIZAR
    public boolean actualizarUsuario(int id, String nombre, String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NOMBRE, nombre);
        values.put(COL_EMAIL, email);

        int rows = db.update(TABLE_USUARIOS, values,
                COL_ID + " = ?", new String[]{String.valueOf(id)});

        db.close();
        return rows > 0;
    }

    // 🔹 ELIMINAR
    public boolean eliminarUsuario(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        int rows = db.delete(TABLE_USUARIOS,
                COL_ID + " = ?", new String[]{String.valueOf(id)});

        db.close();
        return rows > 0;
    }
}
