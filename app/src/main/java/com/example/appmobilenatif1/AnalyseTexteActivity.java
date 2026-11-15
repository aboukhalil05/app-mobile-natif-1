package com.example.appmobilenatif1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AnalyseTexteActivity extends AppCompatActivity {

    private EditText t1, t2, t3, t4;
    private Button b1, b2, btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse_texte);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        btnRetour = findViewById(R.id.btnRetourAnalyse);

        // Bouton Analyser (b1)
        b1.setOnClickListener(v -> {
            String texte = t1.getText().toString();

            // 1. Nombre de caractères dans t2
            int nbCaracteres = texte.length();
            t2.setText("Nombre de caractères : " + nbCaracteres);

            // 2. Nombre de mots dans t3
            String texteNettoye = texte.trim();
            int nbMots = texteNettoye.isEmpty() ? 0 : texteNettoye.split("\\s+").length;
            t3.setText("Nombre de mots : " + nbMots);

            // 3. Nombre de voyelles dans t4
            int nbVoyelles = compterVoyelles(texte);
            t4.setText("Nombre de voyelles : " + nbVoyelles);
        });

        // Bouton Effacer (b2) : vide t1 et réinitialise t2, t3, t4 à zéro
        b2.setOnClickListener(v -> {
            t1.setText("");
            t2.setText("Nombre de caractères : 0");
            t3.setText("Nombre de mots : 0");
            t4.setText("Nombre de voyelles : 0");
        });

        // Retour au menu principal
        btnRetour.setOnClickListener(v -> finish());
    }

    private int compterVoyelles(String texte) {
        int compteur = 0;
        String voyelles = "aeiouyàâäéèêëîïôöùûüÿ";
        String min = texte.toLowerCase();

        for (int i = 0; i < min.length(); i++) {
            if (voyelles.indexOf(min.charAt(i)) != -1) {
                compteur++;
            }
        }
        return compteur;
    }
}