package com.example.appmobilenatif1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MultimediaAct11Activity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia_act11);

        ImageView imgChat = findViewById(R.id.imgChat);
        ImageView imgChien = findViewById(R.id.imgChien);
        ImageView imgVersChiffre = findViewById(R.id.imgVersChiffre);
        Button btnRetour = findViewById(R.id.btnRetourAct11);

        // Clic sur chat -> Toast + son chat
        imgChat.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Coucou chat !", Toast.LENGTH_SHORT).show();
            jouerSon(R.raw.chat);
        });

        // Clic sur chien -> Toast + son chien
        imgChien.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Coucou chien !", Toast.LENGTH_SHORT).show();
            jouerSon(R.raw.chien);
        });

        // Navigation vers Partie 2 (Chiffres) via l'image i7
        imgVersChiffre.setOnClickListener(v ->
                startActivity(new Intent(MultimediaAct11Activity.this, ChiffreActivity.class))
        );

        btnRetour.setOnClickListener(v -> finish());
    }

    private void jouerSon(int ressourceAudio) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(getApplicationContext(), ressourceAudio);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}