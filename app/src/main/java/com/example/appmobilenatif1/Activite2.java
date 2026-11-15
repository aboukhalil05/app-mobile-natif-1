package com.example.appmobilenatif1;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Activite2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite2);

        Button btnRetour = findViewById(R.id.btnRetourAct2);
        // finish() ferme l'activité en cours et revient automatiquement au menu
        btnRetour.setOnClickListener(v -> finish());
    }
}