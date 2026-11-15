package com.example.appmobilenatif1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activite4 extends AppCompatActivity {

    private EditText t1, t2, t3;
    private Button btnAction, btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activite4);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        btnAction = findViewById(R.id.btnAction);
        btnRetour = findViewById(R.id.btnRetourAct4);

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texteT1 = t1.getText().toString();

                // a. Copier le texte de t1 dans t2
                t2.setText(texteT1);

                // b. Afficher dans t3 le nombre de caractères saisis dans t1
                int nombreCaracteres = texteT1.length();
                t3.setText(String.valueOf(nombreCaracteres));
            }
        });

        btnRetour.setOnClickListener(v -> finish());
    }
}