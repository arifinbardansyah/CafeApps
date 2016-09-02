package com.cafeapps.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cafeapps.R;

import java.util.List;

public class FasilitasAdapter extends RecyclerView.Adapter<FasilitasAdapter.ViewHolder> {

    private List<String> fasilitases;

    public FasilitasAdapter(List<String> fasilitases) {
        this.fasilitases = fasilitases;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textFasilitas;

        public ViewHolder(View itemView) {
            super(itemView);
            textFasilitas = (TextView)itemView.findViewById(R.id.txt_fasilitas);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fasilitas,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textFasilitas.setText(fasilitases.get(position));
    }

    @Override
    public int getItemCount() {
        return fasilitases.size();
    }
}
