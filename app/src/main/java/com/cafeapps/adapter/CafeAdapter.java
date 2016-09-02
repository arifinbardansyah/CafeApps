package com.cafeapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cafeapps.R;
import com.cafeapps.activity.DetailCafeActivity;
import com.cafeapps.model.Cafe;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.ViewHolder> {

    private List<Cafe> cafes;
    private Context context;

    public CafeAdapter(Context context,List<Cafe> cafes) {
        this.cafes = cafes;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageCafe;
        TextView nameCafe;
        TextView addressCafe;
        public ViewHolder(View itemView) {
            super(itemView);
            imageCafe = (ImageView)itemView.findViewById(R.id.img_cafe);
            nameCafe = (TextView)itemView.findViewById(R.id.txt_cafe);
            addressCafe = (TextView)itemView.findViewById(R.id.txt_address);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailCafeActivity.class);
            intent.putExtra("cafe", new Gson().toJson(cafes.get(getAdapterPosition())));
            context.startActivity(intent);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cafe,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String url=cafes.get(position).getUrl_foto();
        Picasso.with(context).load(url).into(holder.imageCafe);
        holder.nameCafe.setText(cafes.get(position).getNama());
        holder.addressCafe.setText(cafes.get(position).getAlamat());
    }

    @Override
    public int getItemCount() {
        return cafes.size();
    }

}
