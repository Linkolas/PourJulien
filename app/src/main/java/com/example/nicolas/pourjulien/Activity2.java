package com.example.nicolas.pourjulien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nicolas.pourjulien.model.Complexe;
import com.example.nicolas.pourjulien.model.NotSoSimple;
import com.example.nicolas.pourjulien.model.Simple;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Simple simple = (Simple) getIntent().getSerializableExtra("simple");
            NotSoSimple nssimple = (NotSoSimple) getIntent().getSerializableExtra("nssimple");
            Complexe complexe = (Complexe) getIntent().getSerializableExtra("complexe");
            System.out.println(simple);
            System.out.println(nssimple);
            System.out.println(complexe);
        }
    }
}
