package com.example.nicolas.pourjulien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

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
                sendRequest();
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
}
