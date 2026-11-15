package com.example.appmobilenatif1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Activite6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite6);

        EditText etPrix = findViewById(R.id.etPrixUnitaire);
        EditText etQte = findViewById(R.id.etQuantite);
        RadioButton rbExpress = findViewById(R.id.rbExpress);
        CheckBox cbRemise = findViewById(R.id.cbRemiseEtudiant);
        Button btnCalculer = findViewById(R.id.btnCalculerTotal);
        TextView tvTotal = findViewById(R.id.tvTotal);
        Button btnRetour = findViewById(R.id.btnRetourAct6);

        btnCalculer.setOnClickListener(v -> {
            String sPrix = etPrix.getText().toString().trim();
            String sQte = etQte.getText().toString().trim();

            if (sPrix.isEmpty() || sQte.isEmpty()) {
                Toast.makeText(this, "Saisissez le prix et la quantité", Toast.LENGTH_SHORT).show();
                return;
            }

            double prix = Double.parseDouble(sPrix);
            int qte = Integer.parseInt(sQte);
            double total = prix * qte;

            if (cbRemise.isChecked()) {
                total = total * 0.90; // Réduction de 10%
            }

            if (rbExpress.isChecked()) {
                total += 30.0; // Frais de livraison express
            }

            tvTotal.setText("Total à payer : " + total + " DH");
        });

        btnRetour.setOnClickListener(v -> finish());
    }
}