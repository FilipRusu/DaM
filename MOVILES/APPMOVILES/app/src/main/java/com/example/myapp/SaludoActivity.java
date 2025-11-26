 package com.example.myapp;

 import android.os.Bundle;
 import android.widget.TextView;
 import androidx.appcompat.app.AppCompatActivity;

 public class SaludoActivity extends AppCompatActivity {

     private TextView txtSaludo;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_saludo);

         // Obtenemos una referencia a los controles de la interfaz
         txtSaludo = findViewById(R.id.txtSaludo);

         // Recuperamos la información pasada en el intent
         String saludo = getIntent().getStringExtra("NOMBRE");

         // Construimos el mensaje a mostrar
         txtSaludo.setText("Hola " + saludo);
     }
 }
