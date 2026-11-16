package com.example.appmobilenatif1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AnimalDetailActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        ImageView ivAnimal = findViewById(R.id.ivAnimalDetail);
        TextView tvNom = findViewById(R.id.tvAnimalNom);
        TextView tvDesc = findViewById(R.id.tvAnimalDesc);
        Button btnSon = findViewById(R.id.btnEcouterSon);
        Button btnRetour = findViewById(R.id.btnRetourDetail);

        Intent intent = getIntent();
        String nom = intent.getStringExtra("NOM");
        int imageRes = intent.getIntExtra("IMAGE", 0);
        String desc = intent.getStringExtra("DESC");
        int sonRes = intent.getIntExtra("SON", 0);

        if (nom != null) tvNom.setText(nom);
        if (imageRes != 0) ivAnimal.setImageResource(imageRes);
        if (desc != null) tvDesc.setText(desc);

        btnSon.setOnClickListener(v -> {
            if (sonRes != 0) {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(AnimalDetailActivity.this, sonRes);
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                }
            }
        });

        btnRetour.setOnClickListener(v -> finish());
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
