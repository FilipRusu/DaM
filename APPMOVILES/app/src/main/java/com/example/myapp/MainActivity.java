package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private Button btnAceptar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos una referencia a los controles de la interfaz
        txtNombre = findViewById(R.id.txtnombre);
        btnAceptar = findViewById(R.id.btnAcceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creamos el Intent
                Intent intent = new Intent(MainActivity.this, SaludoActivity.class);
                // Añadimos al intent la información a pasar entre actividades
                intent.putExtra("NOMBRE", txtNombre.getText().toString());
                // Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }
}