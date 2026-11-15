package com.example.appmobilenatif1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Button btnToastCourt = findViewById(R.id.btnToastCourt);
        Button btnToastLong = findViewById(R.id.btnToastLong);
        Button btnDialog1 = findViewById(R.id.btnDialog1);
        Button btnDialog2 = findViewById(R.id.btnDialog2);
        Button btnDialog3 = findViewById(R.id.btnDialog3);
        Button btnRetour = findViewById(R.id.btnRetourNotif);

        // Bouton 1 : Toast pour une durée très légère (LENGTH_SHORT)
        btnToastCourt.setOnClickListener(v ->
                Toast.makeText(getApplicationContext(), "Toast durée courte (LENGTH_SHORT)", Toast.LENGTH_SHORT).show()
        );

        // Bouton 2 : Toast pour une durée moins légère (LENGTH_LONG)
        btnToastLong.setOnClickListener(v ->
                Toast.makeText(getApplicationContext(), "Toast durée longue (LENGTH_LONG)", Toast.LENGTH_LONG).show()
        );

        // Bouton 3 : Boîte de dialogue avec 1 seul bouton
        btnDialog1.setOnClickListener(v -> {
            AlertDialog.Builder boite = new AlertDialog.Builder(NotificationActivity.this);
            boite.setTitle("Boîte de dialogue 1");
            boite.setIcon(android.R.drawable.ic_dialog_info);
            boite.setMessage("Message avec un seul bouton.");
            boite.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(NotificationActivity.this, "Bouton OK cliqué", Toast.LENGTH_SHORT).show();
                }
            });
            boite.show();
        });

        // Bouton 4 : Boîte de dialogue avec 2 boutons
        btnDialog2.setOnClickListener(v -> {
            AlertDialog.Builder boite = new AlertDialog.Builder(NotificationActivity.this);
            boite.setTitle("Boîte de dialogue 2");
            boite.setIcon(android.R.drawable.ic_dialog_alert);
            boite.setMessage("Voulez-vous confirmer cette action ?");
            boite.setPositiveButton("Oui", (dialog, which) ->
                    Toast.makeText(NotificationActivity.this, "Action confirmée", Toast.LENGTH_SHORT).show()
            );
            boite.setNegativeButton("Non", (dialog, which) ->
                    Toast.makeText(NotificationActivity.this, "Action annulée", Toast.LENGTH_SHORT).show()
            );
            boite.show();
        });

        // Bouton 5 : Boîte de dialogue avec 3 boutons + une zone de saisie (EditText)
        btnDialog3.setOnClickListener(v -> {
            AlertDialog.Builder boite = new AlertDialog.Builder(NotificationActivity.this);
            boite.setTitle("Boîte de dialogue 3");
            boite.setIcon(android.R.drawable.ic_dialog_email);
            boite.setMessage("Veuillez saisir votre nom :");

            // Création de la zone de saisie intégrée à la boîte de dialogue
            final EditText zoneSaisie = new EditText(NotificationActivity.this);
            zoneSaisie.setHint("Tapez votre texte ici...");
            boite.setView(zoneSaisie);

            // Bouton 1 : Valider
            boite.setPositiveButton("Valider", (dialog, which) -> {
                String texte = zoneSaisie.getText().toString();
                Toast.makeText(NotificationActivity.this, "Saisi : " + texte, Toast.LENGTH_LONG).show();
            });

            // Bouton 2 : Annuler
            boite.setNegativeButton("Annuler", (dialog, which) -> dialog.cancel());

            // Bouton 3 : Plus tard (bouton neutre)
            boite.setNeutralButton("Plus tard", (dialog, which) ->
                    Toast.makeText(NotificationActivity.this, "Rappel programmé", Toast.LENGTH_SHORT).show()
            );

            boite.show();
        });

        // Retour à l'activité précédente (Menu principal)
        btnRetour.setOnClickListener(v -> finish());
    }
}