package com.example.nicolas.pourjulien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nicolas.pourjulien.model.Simple;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Simple simple = (Simple) getIntent().getSerializableExtra("simple");
            System.out.println(simple);
        }
    }
}
