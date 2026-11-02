package com.example.losowaniekostek;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final Random random = new Random();
    private int[] wyniki = new int[0];

    private EditText editTextLiczbaKostek;
    private GridLayout gridKostki;
    private TextView textViewWyniki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLiczbaKostek = findViewById(R.id.editTextLiczbaKostek);
        gridKostki = findViewById(R.id.gridKostki);
        textViewWyniki = findViewById(R.id.textViewWyniki);

        Button buttonLosuj = findViewById(R.id.buttonLosuj);
        Button buttonRosnaco = findViewById(R.id.buttonRosnaco);
        Button buttonMalejaco = findViewById(R.id.buttonMalejaco);

        buttonLosuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                losujKostki();
            }
        });
        buttonRosnaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortujWyniki(true);
            }
        });
        buttonMalejaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortujWyniki(false);
            }
        });
    }

    private void losujKostki() {
        String liczbaKostekTekst = editTextLiczbaKostek.getText().toString().trim();

        if (liczbaKostekTekst.isEmpty()) {
            pokazKomunikat("Podaj liczbę kostek.");
            return;
        }

        final int liczbaKostek;
        try {
            liczbaKostek = Integer.parseInt(liczbaKostekTekst);
        } catch (NumberFormatException exception) {
            pokazKomunikat("Liczba kostek musi być liczbą całkowitą.");
            return;
        }

        if (liczbaKostek <= 0) {
            pokazKomunikat("Liczba kostek musi być większa od zera.");
            return;
        }

        wyniki = new int[liczbaKostek];
        for (int numerKostki = 0; numerKostki < liczbaKostek; numerKostki++) {
            wyniki[numerKostki] = random.nextInt(6) + 1;
        }

        odswiezWidok();
    }

    private void sortujWyniki(boolean rosnaco) {
        if (wyniki.length == 0) {
            pokazKomunikat("Najpierw wylosuj kostki.");
            return;
        }

        for (int i = 0; i < wyniki.length - 1; i++) {
            for (int j = 0; j < wyniki.length - 1 - i; j++) {
                boolean zamien = rosnaco
                        ? wyniki[j] > wyniki[j + 1]
                        : wyniki[j] < wyniki[j + 1];

                if (zamien) {
                    int tymczasowy = wyniki[j];
                    wyniki[j] = wyniki[j + 1];
                    wyniki[j + 1] = tymczasowy;
                }
            }
        }

        odswiezWidok();
    }

    private void odswiezWidok() {
        gridKostki.removeAllViews();
        gridKostki.setColumnCount(Math.min(3, wyniki.length));

        for (int i = 0; i < wyniki.length; i++) {
            dodajWidokKostki(i + 1, wyniki[i]);
        }

        pokazWyniki();
    }

    private void dodajWidokKostki(int numerKostki, int wynik) {
        TextView kostka = new TextView(this);
        kostka.setGravity(Gravity.CENTER);
        kostka.setText("Kostka " + numerKostki + "\nWynik: " + wynik);
        kostka.setTextColor(Color.BLACK);
        kostka.setTextSize(16);
        kostka.setPadding(16, 16, 16, 16);

        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.setGravity(Gravity.FILL);
        kostka.setLayoutParams(layoutParams);
        gridKostki.addView(kostka);
    }

    private void pokazWyniki() {
        StringBuilder tekstWynikow = new StringBuilder();
        for (int i = 0; i < wyniki.length; i++) {
            if (i > 0) {
                tekstWynikow.append(", ");
            }
            tekstWynikow.append(wyniki[i]);
        }
        textViewWyniki.setText(tekstWynikow.toString());
    }

    private void pokazKomunikat(String komunikat) {
        Toast.makeText(this, komunikat, Toast.LENGTH_SHORT).show();
    }
}
