package com.example.proparelgridlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Grid;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



public class MainActivity extends AppCompatActivity {
    GridLayout gridLayout;

    public void parametros(Button btn,int i){
        int columnCount=5;
        GridLayout.LayoutParams params=new GridLayout.LayoutParams();
        params.columnSpec = GridLayout.spec(i % columnCount);
        params.width=GridLayout.LayoutParams.WRAP_CONTENT;
        params.height=GridLayout.LayoutParams.WRAP_CONTENT;
        params.setMargins(10,10,10,10);
        btn.setLayoutParams(params);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Random rand= new Random();
        int totalButtons =rand.nextInt((21-6)+1)+6;
        gridLayout=findViewById(R.id.gridLayout);
        int contador=0;
        ArrayList<Button> listabottones=new ArrayList<Button>();
        int columnCount=5;
        gridLayout.setColumnCount(columnCount);

        for (int i=0;i< totalButtons;i++){

            Button btn= new Button(this);

            btn.setText(String.valueOf("B"+(i+1)));

            btn.setBackgroundColor(Color.YELLOW);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btn.setBackgroundColor(Color.WHITE);
                }
            });
            parametros(btn,i);
            listabottones.add(btn);
            gridLayout.addView(btn);
            contador++;
        }
        Button reset = new Button(this);
        reset.setText(String.valueOf("BOTON RESET"));
        parametros(reset,contador+1);
        reset.setBackgroundColor(Color.GREEN);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Button btn:listabottones
                     )
                {
                 btn.setBackgroundColor(Color.YELLOW);
                }
            }
        });
        gridLayout.addView(reset);
    }
}