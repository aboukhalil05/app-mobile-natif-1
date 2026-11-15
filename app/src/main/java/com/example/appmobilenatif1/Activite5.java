package com.example.appmobilenatif1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Activite5 extends AppCompatActivity {

    private EditText etVar1, etVar2, etResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite5);

        etVar1 = findViewById(R.id.etVar1);
        etVar2 = findViewById(R.id.etVar2);
        etResultat = findViewById(R.id.etResultat);

        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnMoins = findViewById(R.id.btnMoins);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnMult = findViewById(R.id.btnMult);
        Button btnCls = findViewById(R.id.btnCls);
        Button btnRetour = findViewById(R.id.btnRetourAct5);

        btnPlus.setOnClickListener(v -> calculer('+'));
        btnMoins.setOnClickListener(v -> calculer('-'));
        btnMult.setOnClickListener(v -> calculer('*'));
        btnDiv.setOnClickListener(v -> calculer('/'));

        // Bouton CLS : effacer les trois champs
        btnCls.setOnClickListener(v -> {
            etVar1.setText("");
            etVar2.setText("");
            etResultat.setText("");
        });

        // Retour au menu principal
        btnRetour.setOnClickListener(v -> finish());
    }

    private void calculer(char operation) {
        String s1 = etVar1.getText().toString().trim();
        String s2 = etVar2.getText().toString().trim();

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir Variable 1 et Variable 2", Toast.LENGTH_SHORT).show();
            return;
        }

        double v1 = Double.parseDouble(s1);
        double v2 = Double.parseDouble(s2);
        double res = 0;

        switch (operation) {
            case '+':
                res = v1 + v2;
                break;
            case '-':
                res = v1 - v2;
                break;
            case '*':
                res = v1 * v2;
                break;
            case '/':
                if (v2 == 0) {
                    Toast.makeText(this, "Division par zéro impossible", Toast.LENGTH_SHORT).show();
                    return;
                }
                res = v1 / v2;
                break;
        }

        etResultat.setText(String.valueOf(res));
    }
}