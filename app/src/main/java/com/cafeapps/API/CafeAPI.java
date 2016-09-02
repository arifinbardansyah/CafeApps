package com.cafeapps.API;

import com.cafeapps.model.Cafe;
import com.cafeapps.model.DetailCafe;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CafeAPI {
    String BASE_URL = "http://dev.gits.co.id/";

    @GET("/apicafe/public/list")
    Call<Cafe.CafeList> getCafe();

    @GET("/apicafe/public/list/{id}")
    Call<DetailCafe.DetailCafeData> getDetailCafe(@Path("id") String id);

    class Factory {
        public static CafeAPI create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(CafeAPI.class);
        }
    }
}
