package com.example.turismo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.turismo.Adapter.LugarAdapter;
import com.example.turismo.Modelos.Lugares;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocation;
    private static final int CODIGO_GPS = 1000;
    private ListView listView;
    private TextView textView;
    private List<Lugares> lugares = new ArrayList<>();
    private ArrayAdapter<Lugares> arrayAdapterLugares;
    private Location minhaLoc = new Location( "Minha Localização");
    private Location LocFzdStMaria = new Location("Fazenda Santa Maria");
    private Location LocPqEco = new Location("Parque Ecológico");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewDist);


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

    @RequiresApi(api = Build.VERSION_CODES.M)

    public void mostrarDistancia(View v){


        //Verifica se a permissao não foi concedida

        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED);

        // Solicita o uso do GPS para o usuário

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION
        }, CODIGO_GPS);

        fusedLocation = LocationServices.getFusedLocationProviderClient(this);
        fusedLocation.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        minhaLoc.setLatitude(location.getLatitude());
                        minhaLoc.setLongitude(location.getLongitude());
                        calculaDistancia();
                    }
                });
    }
    public void calculaDistancia(){
        LocFzdStMaria.setLatitude(-22.0445403);
        LocFzdStMaria.setLongitude(-47.972365);

        Float distancia = minhaLoc.distanceTo(LocFzdStMaria)/1000;
        textView.setText(String.format("%.2f",distancia) + "  Km");
    }
    }




