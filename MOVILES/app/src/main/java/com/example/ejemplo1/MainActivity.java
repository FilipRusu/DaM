package com.example.ejemplo1;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ejemplo1.DataBase;
import com.example.ejemplo1.R;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etEmail;
    Button btnGuardar, btnMostrar;
    TextView tvResultado;

    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar BD
        db = new DataBase(this);


        // Referencias
        etNombre = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etEmail);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnMostrar = findViewById(R.id.btnMostrar);
        tvResultado = findViewById(R.id.tvResultado);

        // Botón guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String email = etEmail.getText().toString();

                db.insertarUsuario(nombre, email);

                etNombre.setText("");
                etEmail.setText("");
            }
        });

        // Botón mostrar
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.obtenerUsuarios();
                StringBuilder sb = new StringBuilder();

                while (cursor.moveToNext()) {
                    sb.append("ID: ").append(cursor.getInt(0))
                            .append("\nNombre: ").append(cursor.getString(1))
                            .append("\nEmail: ").append(cursor.getString(2))
                            .append("\n\n");
                }

                tvResultado.setText(sb.toString());
                cursor.close();
            }
        });
    }
}
