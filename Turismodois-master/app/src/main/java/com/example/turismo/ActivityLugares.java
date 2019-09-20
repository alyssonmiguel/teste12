package com.example.turismo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityLugares extends AppCompatActivity {

    private TextView textViewLugar;
    private TextView textViewDescricao;
    private TextView textViewDist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);

        textViewLugar = findViewById(R.id.textViewLugar);
        textViewDescricao = findViewById(R.id.textViewDescricao);
        textViewDist=findViewById(R.id.textViewDist);


        Intent intent = getIntent();
        String lugar = intent.getStringExtra("LUGAR");
        String descricao = intent.getStringExtra("DESCRICAO");
        String distancia = intent.getStringExtra("DISTANCIA");


        textViewLugar.setText(lugar);
        textViewDescricao.setText(descricao);
        textViewDist.setText(distancia);
    }
}
