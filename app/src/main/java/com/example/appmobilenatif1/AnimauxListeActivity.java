package com.example.appmobilenatif1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AnimauxListeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animaux_liste);

        findViewById(R.id.ivChien).setOnClickListener(v -> ouvrirDetail(
                "Le Chien",
                R.drawable.chien,
                "Le chien (Canis lupus familiaris) est un mammifère domestique fidèle de la famille des canidés.",
                R.raw.a2
        ));

        findViewById(R.id.ivChat).setOnClickListener(v -> ouvrirDetail(
                "Le Chat",
                R.drawable.chat,
                "Le chat domestique est un petit mammifère carnivore agile appartenant à la famille des félidés.",
                R.raw.a6
        ));

        Button btnRetour = findViewById(R.id.btnRetourListeAnimaux);
        btnRetour.setOnClickListener(v -> finish());
    }

    private void ouvrirDetail(String nom, int imageRes, String description, int sonRes) {
        Intent intent = new Intent(AnimauxListeActivity.this, AnimalDetailActivity.class);
        intent.putExtra("NOM", nom);
        intent.putExtra("IMAGE", imageRes);
        intent.putExtra("DESC", description);
        intent.putExtra("SON", sonRes);
        startActivity(intent);
    }
}