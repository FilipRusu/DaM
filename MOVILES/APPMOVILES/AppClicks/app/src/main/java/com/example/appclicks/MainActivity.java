package com.example.appclicks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appclicks.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    int contador;
    TextView contadorDeClics;
    Button augmentarElContador;

    String textinfo;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contadorDeClics = findViewById(R.id.contadorDeClics);
        augmentarElContador =findViewById(R.id.augmentarElContador);

        augmentarElContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
            textinfo =getString(R.string.click_counts,contador);
            contadorDeClics.setText(textinfo);
            }
        });

    }
}