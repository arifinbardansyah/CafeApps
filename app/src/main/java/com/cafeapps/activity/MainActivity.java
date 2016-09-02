package com.cafeapps.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.cafeapps.API.CafeAPI;
import com.cafeapps.R;
import com.cafeapps.adapter.CafeAdapter;
import com.cafeapps.model.Cafe;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView rvCafe;
    CafeAdapter adapter;
    List<Cafe> cafes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setupRecycler();
        refresh();
        setupRefresh();
    }

    private void setupRefresh() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    private void refresh() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                reqData();
            }
        });
    }

    private void reqData() {
        CafeAPI cafeAPI = CafeAPI.Factory.create();
        Call<Cafe.CafeList> call = cafeAPI.getCafe();
        call.enqueue(new Callback<Cafe.CafeList>() {
            @Override
            public void onResponse(Call<Cafe.CafeList> call, Response<Cafe.CafeList> response) {
                cafes.addAll(response.body().getDATA());
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<Cafe.CafeList> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"tidak ada koneksi",Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void setupRecycler() {
        rvCafe.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CafeAdapter(this, cafes);
        rvCafe.setAdapter(adapter);
    }

    private void initView() {
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        rvCafe = (RecyclerView)findViewById(R.id.recycler_cafe);
    }
}
