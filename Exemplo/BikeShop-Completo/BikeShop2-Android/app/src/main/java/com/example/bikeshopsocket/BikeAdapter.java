package com.example.bikeshopsocket;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import modelDominio.Bike;

public class BikeAdapter extends RecyclerView.Adapter<BikeAdapter.MyViewHolder> {
    private ArrayList<Bike> listaBikes;
    private BikeOnClickListener bikeOnClickListener;

    public BikeAdapter(ArrayList<Bike> listaBikes, BikeOnClickListener bikeOnClickListener) {
        this.listaBikes = listaBikes;
        this.bikeOnClickListener = bikeOnClickListener;
    }

    @Override
    public BikeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemdalista, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BikeAdapter.MyViewHolder holder, final int position) {
        Bike meuBike = listaBikes.get(position);
        holder.tvBikeModelo.setText("Modelo: "+meuBike.getModelo());
        holder.tvBikeMarca.setText("Marca: "+meuBike.getMarca().getNomemarca());
        holder.tvBikePreco.setText("Preço: "+meuBike.getPrecoString());

        // clique no item do cliente
        if (bikeOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bikeOnClickListener.onClickBike(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaBikes.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvBikeModelo, tvBikeMarca, tvBikePreco;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvBikeModelo = itemView.findViewById(R.id.tvModelo);
            tvBikeMarca = itemView.findViewById(R.id.tvMarca);
            tvBikePreco = itemView.findViewById(R.id.tvPreco);
        }
    }

    public interface BikeOnClickListener {
        public void onClickBike(View view, int position);
    }


}
