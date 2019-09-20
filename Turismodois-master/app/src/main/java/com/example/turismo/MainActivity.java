package com.example.turismo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.turismo.Adapter.LugarAdapter;
import com.example.turismo.Modelos.Lugares;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Lugares> lugares = new ArrayList<>();
    private ArrayAdapter<Lugares> arrayAdapterLugares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        criarLugares();

        listView = findViewById(R.id.listViewLugares);

        arrayAdapterLugares = new LugarAdapter(MainActivity.this,
                (ArrayList<Lugares>) lugares);
        listView.setAdapter(arrayAdapterLugares);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ActivityLugares.class);
                intent.putExtra("LUGAR", lugares.get(i).getNome());
                intent.putExtra("DISTANCIA", lugares.get(i).getDistancia());
                intent.putExtra("DESCRICAO", lugares.get(i).getDescricao());
                startActivity(intent);
            }
        });
    }

    public void criarLugares(){

        lugares.add(new Lugares(
                "Fazenda Santa Maria",
                " Distância 10 km",
                "Ótimo lugar para conhecer o passado da cidade" ,
                 R.drawable.fzdstmaria));

        lugares.add(new Lugares(
                "Parque Ecológico",
                " Distância 5,5 km",
                "Lugar para visitar com a família",
                 R.drawable.prqecologico));
        }
    }




