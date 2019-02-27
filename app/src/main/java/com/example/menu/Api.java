package com.example.menu;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("daily_json.js")
    Call<Data> getInfo();
}