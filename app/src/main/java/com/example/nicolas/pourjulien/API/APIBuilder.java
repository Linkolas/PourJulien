package com.example.nicolas.pourjulien.API;

import android.content.Context;

import com.example.nicolas.pourjulien.API.okhttp.interceptor.AddCookiesInterceptor;
import com.example.nicolas.pourjulien.API.okhttp.interceptor.ReceivedCookiesInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIBuilder {

    static private RetrofitAPI retrofit = null;

    public static RetrofitAPI getAPI(Context context) {

        if(retrofit != null) {
            return retrofit;
        }

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new AddCookiesInterceptor(context));
        builder.addInterceptor(new ReceivedCookiesInterceptor(context));

        OkHttpClient client = builder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitAPI.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitAPI.class);

        return retrofit;
    }

}
