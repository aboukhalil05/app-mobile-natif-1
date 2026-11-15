package com.example.appmobilenatif1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Activite3 extends AppCompatActivity {

    Button b2, btnSupprimer, btnRetour;
    TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite3);

        b2 = findViewById(R.id.b1);
        t2 = findViewById(R.id.t1);
        btnSupprimer = findViewById(R.id.btnSupprimer);
        btnRetour = findViewById(R.id.btnRetourAct3);

        // Question 4 : Remplacer "Bonjour" par "Bonsoir"
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText("Bonsoir");
            }
        });

        // Question 5 : Vider le contenu de la zone de texte
        btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText("");
            }
        });

        // Retour au menu principal
        btnRetour.setOnClickListener(v -> finish());
    }
}