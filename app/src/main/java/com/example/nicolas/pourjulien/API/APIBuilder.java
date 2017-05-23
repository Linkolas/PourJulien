package com.example.nicolas.pourjulien.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIBuilder {

    static private RetrofitAPI retrofit = null;

    public static RetrofitAPI getAPI() {

        if(retrofit != null) {
            return retrofit;
        }

        retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitAPI.class);

        return retrofit;
    }

}
