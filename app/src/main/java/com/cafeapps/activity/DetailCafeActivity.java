package com.cafeapps.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.cafeapps.API.CafeAPI;
import com.cafeapps.R;
import com.cafeapps.adapter.FasilitasAdapter;
import com.cafeapps.model.Cafe;
import com.cafeapps.model.DetailCafe;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailCafeActivity extends AppCompatActivity implements OnMapReadyCallback{

    ImageView imageCafe;
    TextView namaCafe;
    TextView addressCafe;
    TextView deskripsiCafe;
    RecyclerView rvFasilitas;
    DetailCafe detailCafe;
    FasilitasAdapter adapter;
    MapFragment mapFragment;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cafe);

        initView();

        Intent intent = getIntent();
        Cafe cafe = new Gson().fromJson(intent.getStringExtra("cafe"), Cafe.class);

        reqDetailCafe(cafe);
    }

    private void reqDetailCafe(final Cafe cafe) {
        CafeAPI cafeAPI = CafeAPI.Factory.create();
        Call<DetailCafe.DetailCafeData> call = cafeAPI.getDetailCafe(cafe.getId());
        call.enqueue(new Callback<DetailCafe.DetailCafeData>() {
            @Override
            public void onResponse(Call<DetailCafe.DetailCafeData> call, Response<DetailCafe.DetailCafeData> response) {
                detailCafe = response.body().getDATA();
                bindData(cafe,detailCafe);
            }

            @Override
            public void onFailure(Call<DetailCafe.DetailCafeData> call, Throwable t) {

            }
        });

    }

    private void bindData(Cafe cafe, DetailCafe detailCafe) {
        Picasso.with(this).load(cafe.getUrl_foto()).into(imageCafe);
        namaCafe.setText(cafe.getNama());
        addressCafe.setText(cafe.getAlamat());
        deskripsiCafe.setText(detailCafe.getDeskripsi());
        setupRecycler();
        mapFragment.getMapAsync(this);
    }

    private void setupRecycler() {
        ArrayList<String> strings = new ArrayList<>();
        for(DetailCafe.Fasilitas fasilitas : detailCafe.getFasilitas()){
            strings.add(fasilitas.getNama());
        }
            rvFasilitas.setLayoutManager(new LinearLayoutManager(this));
            adapter = new FasilitasAdapter(strings);
            rvFasilitas.setAdapter(adapter);

    }

    private void initView() {
        imageCafe = (ImageView)findViewById(R.id.img_detail);
        namaCafe = (TextView)findViewById(R.id.name_detail);
        addressCafe = (TextView)findViewById(R.id.address_detail);
        deskripsiCafe = (TextView)findViewById(R.id.txt_description);
        rvFasilitas = (RecyclerView) findViewById(R.id.recycler_fasilitas);
        mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng latLng = new LatLng(Double.parseDouble(detailCafe.getLocation().getLatitude().get(0)), Double.parseDouble(detailCafe.getLocation().getLongitude().get(0)));
        mMap.addMarker(new MarkerOptions().position(latLng));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
    }

}
