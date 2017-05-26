package com.example.nicolas.pourjulien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.nicolas.pourjulien.API.APIBuilder;
import com.example.nicolas.pourjulien.API.RetrofitAPI;
import com.example.nicolas.pourjulien.model.Complexe;
import com.example.nicolas.pourjulien.model.NotSoSimple;
import com.example.nicolas.pourjulien.model.Simple;
import com.google.gson.JsonObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String debugTag = "WOLOLO";

    @BindView(R.id.buttonSendRequest)
    Button button1;
    @BindView(R.id.buttonSendRequest2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // sendRequest();
                //switchActivity();
                sendRequestConnect();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequestSendMessage();
            }
        });
    }



    private void sendRequest() {
        RetrofitAPI API = APIBuilder.getAPI(this);
        Call<JsonObject> request = API.testPost("leparam");
        request.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                //... traiter réponse
                Log.w(debugTag, "TRAITER REPONSE");
                Log.w(debugTag, ""+response.code());
                Log.w(debugTag, ""+response.body());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                //... traiter échec
                Log.w(debugTag, "TRAITER ECHEC");
                Log.w(debugTag, t.getMessage());
            }
        });
    }

    private void sendRequestConnect() {
        RetrofitAPI API = APIBuilder.getAPI(this);
        Call<JsonObject> request = API.connexion();
        request.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                //... traiter réponse
                Log.w(debugTag, "TRAITER REPONSE");
                Log.w(debugTag, ""+response.code());
                Log.w(debugTag, ""+response.body());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                //... traiter échec
                Log.w(debugTag, "TRAITER ECHEC");
                Log.w(debugTag, t.getMessage());
            }
        });
    }

    private void sendRequestSendMessage() {
        RetrofitAPI API = APIBuilder.getAPI(this);
        Call<JsonObject> request = API.sendMessage(1, 3 , "UESH CA MARCHE");
        request.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                //... traiter réponse
                Log.w(debugTag, "TRAITER REPONSE");
                Log.w(debugTag, ""+response.code());
                Log.w(debugTag, ""+response.body());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                //... traiter échec
                Log.w(debugTag, "TRAITER ECHEC");
                Log.w(debugTag, t.getMessage());
            }
        });
    }

    private void switchActivity() {
        Simple simple = new Simple();
        simple.setId(42);
        simple.setLibelle("The Answer");

        NotSoSimple nssimple = new NotSoSimple();
        nssimple.setId(42);
        nssimple.setLibelle("The Answer");
        nssimple.setPrice(12);

        Complexe complexe = new Complexe(666, "El Diablo");

        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("simple", simple);
        intent.putExtra("complexe", complexe);
        intent.putExtra("nssimple", nssimple);
        startActivity(intent);
    }
}
