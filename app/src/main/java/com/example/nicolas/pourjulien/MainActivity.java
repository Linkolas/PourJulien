package com.example.nicolas.pourjulien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nicolas.pourjulien.API.APIBuilder;
import com.example.nicolas.pourjulien.API.RetrofitAPI;
import com.example.nicolas.pourjulien.model.Simple;
import com.google.gson.JsonObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.buttonSendRequest)
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // sendRequest();
                switchActivity();
            }
        });
    }

    private void sendRequest() {
        RetrofitAPI API = APIBuilder.getAPI();
        Call<JsonObject> request = API.testPost("leparam");
        request.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                //... traiter réponse
                System.out.println("TRAITER REPONSE");
                System.out.println(response.code());
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                //... traiter échec
                System.out.println("TRAITER ECHEC");
                System.out.println(t.getMessage());
            }
        });
    }

    private void switchActivity() {
        Simple simple = new Simple();
        simple.setId(42);
        simple.setLibelle("The Answer");
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("simple", simple); //second param is Serializable
        startActivity(intent);
    }
}
