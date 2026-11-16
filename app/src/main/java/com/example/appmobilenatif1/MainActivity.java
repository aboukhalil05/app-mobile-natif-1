package com.example.appmobilenatif1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoAct2 = findViewById(R.id.btnGoAct2);
        Button btnGoAct3 = findViewById(R.id.btnGoAct3);
        Button btnGoAct4 = findViewById(R.id.btnGoAct4);
        Button btnGoAct5 = findViewById(R.id.btnGoAct5);
        Button btnGoAct6 = findViewById(R.id.btnGoAct6);
        Button btnGoAnalyseTexte = findViewById(R.id.btnGoAnalyseTexte);
        Button btnGoNotification = findViewById(R.id.btnGoNotification);
        Button btnGoAct11 = findViewById(R.id.btnGoAct11);
        Button btnGoAct12 = findViewById(R.id.btnGoAct12);


        btnGoAct2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Activite2.class)));
        btnGoAct3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Activite3.class)));
        btnGoAct4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Activite4.class)));
        btnGoAct5.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Activite5.class)));
        btnGoAct6.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Activite6.class)));
        btnGoAnalyseTexte.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AnalyseTexteActivity.class)));
        btnGoNotification.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, NotificationActivity.class)));
        btnGoAct11.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MultimediaAct11Activity.class)));
        btnGoAct12.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AnimauxListeActivity.class)));
    }
}