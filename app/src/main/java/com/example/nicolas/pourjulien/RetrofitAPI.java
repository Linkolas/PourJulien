package com.example.nicolas.pourjulien;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.*;

interface RetrofitAPI {

    String BASE_URL = "http://opre.ddns.net/espoir/";

    @POST("data.php?action=connexion")
    Call<JsonObject> connexion(@Query("login") String login,
                               @Query("passe") String passe);

    @GET("profiles/")
    Call<JsonObject> getProfiles();

    @GET("profiles/{id}")
    Call<JsonObject> getProfile(@Path("id") int id);

    @FormUrlEncoded
    @POST("testPOST")
    Call<JsonObject> testPost(@Field("parametre") String leparam);
}
