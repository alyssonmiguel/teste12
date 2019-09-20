package com.example.turismo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.turismo.Modelos.Lugares;
import com.example.turismo.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LugarAdapter extends ArrayAdapter<Lugares> {

    private Context context;
    private List<Lugares> lugares;

    public  LugarAdapter(Context context, ArrayList<Lugares> lugares){
        super(context,0, lugares);
        this.lugares = lugares;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listaLugares = convertView;

        if (listaLugares == null){
            listaLugares = LayoutInflater.from(context).inflate(R.layout.
                    activity_lista_lugares, parent,false);
        }

        Lugares lugarAtual = lugares.get(position);

        TextView textViewLugar = listaLugares.findViewById(R.id.textViewNomeLugar);
        TextView textViewDistancia = listaLugares.findViewById(R.id.textViewDistancia);
        ImageView imageViewListaLugar = listaLugares.findViewById(R.id.imageViewListaLugar);

        textViewLugar.setText(lugarAtual.getNome());
        textViewDistancia.setText(lugarAtual.getDistancia());
        imageViewListaLugar.setImageResource(lugarAtual.getImage());

        return listaLugares;

    }
}
