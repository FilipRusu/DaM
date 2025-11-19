package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityMainBinding;




public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private int tiempo=20;

    public  void incrementar(){
        tiempo++;
        binding.textMostrarTiempo.setText(String.valueOf(tiempo+" MINUTOS"));
    }
    public void decrementar(){
        if(tiempo>1) {
            tiempo--;
            binding.textMostrarTiempo.setText(String.valueOf(tiempo + " MINUTOS"));
        }
    }
    public void predeterminado(){
        tiempo =20;
        binding.textMostrarTiempo.setText(String.valueOf(tiempo+" MINUTOS"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding=ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        binding.buttond1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            predeterminado();
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            incrementar();
            }
        });

        binding.buttond3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            decrementar();
                }
        });

    }
}