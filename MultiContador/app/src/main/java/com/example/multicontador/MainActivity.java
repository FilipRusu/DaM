package com.example.multicontador;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.multicontador.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private int contadorMain=0;
    private int contador1=0;
    private int contador2=0;

    private int contador3=0;
    private int contador4=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView((binding=ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

    binding.button1d1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contador1++;
          contadorMain++;
        binding.textViewALL.setText(String.valueOf(contadorMain));
        binding.textView1.setText(String.valueOf(contador1));
        }
    });
    binding.button1d2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contador2++;
            contadorMain++;
            binding.textViewALL.setText(String.valueOf(contadorMain));
            binding.textView2.setText(String.valueOf(contador2));
        }
    });
    binding.button1d3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contador3++;
            contadorMain++;
            binding.textViewALL.setText(String.valueOf(contadorMain));
            binding.textView3.setText(String.valueOf(contador3));

        }
    });
    binding.button1d4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contador4++;
            contadorMain++;
            binding.textViewALL.setText(String.valueOf(contadorMain));
            binding.textView4.setText(String.valueOf(contador4));
        }
    });
    binding.buttonr1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contadorMain-=contador1;
            contador1=0;
            binding.textViewALL.setText(String.valueOf(contadorMain));
            binding.textView1.setText(String.valueOf(contador1));

        }
    });

    binding.buttonr2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contadorMain-=contador2;
            contador2=0;
            binding.textView2.setText(String.valueOf(contador2));
            binding.textViewALL.setText(String.valueOf(contadorMain));
        }
    });

    binding.buttonr3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contadorMain-=contador3;
            contador3=0;
            binding.textView3.setText(String.valueOf(contador3));
            binding.textViewALL.setText(String.valueOf(contadorMain));
        }
    });

    binding.buttonr4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contadorMain-=contador4;
            contador4=0;
            binding.textView4.setText(String.valueOf(contador4));
            binding.textViewALL.setText(String.valueOf(contadorMain));
        }
    });

    binding.buttonALL.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contadorMain=0;
            contador4=0;
            contador3=0;
            contador2=0;
            contador1=0;
            binding.textViewALL.setText(String.valueOf(contadorMain));
            binding.textView4.setText(String.valueOf(contador4));
            binding.textView3.setText(String.valueOf(contador3));
            binding.textView2.setText(String.valueOf(contador2));
            binding.textView1.setText(String.valueOf(contador1));
        }
    });


    }
}