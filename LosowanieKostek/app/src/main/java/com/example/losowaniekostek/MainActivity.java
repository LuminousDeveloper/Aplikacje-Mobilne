package com.example.losowaniekostek;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final Random random = new Random();
    private final List<Integer> wyniki = new ArrayList<>();

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

        buttonLosuj.setOnClickListener(view -> losujKostki());
        buttonRosnaco.setOnClickListener(view -> sortujWyniki(true));
        buttonMalejaco.setOnClickListener(view -> sortujWyniki(false));
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

        wyniki.clear();
        for (int numerKostki = 1; numerKostki <= liczbaKostek; numerKostki++) {
            wyniki.add(random.nextInt(6) + 1);
        }

        odswiezWidok();
    }

    private void sortujWyniki(boolean rosnaco) {
        if (wyniki.isEmpty()) {
            pokazKomunikat("Najpierw wylosuj kostki.");
            return;
        }

        if (rosnaco) {
            Collections.sort(wyniki);
        } else {
            wyniki.sort(Collections.reverseOrder());
        }

        odswiezWidok();
    }

    private void odswiezWidok() {
        gridKostki.removeAllViews();
        gridKostki.setColumnCount(Math.min(3, wyniki.size()));

        for (int i = 0; i < wyniki.size(); i++) {
            dodajWidokKostki(i + 1, wyniki.get(i));
        }

        pokazWyniki();
    }

    private void dodajWidokKostki(int numerKostki, int wynik) {
        TextView kostka = new TextView(this);
        kostka.setGravity(Gravity.CENTER);
        kostka.setText(String.format(Locale.getDefault(), "Kostka %d\nWynik: %d", numerKostki, wynik));
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
        for (int i = 0; i < wyniki.size(); i++) {
            if (i > 0) {
                tekstWynikow.append(", ");
            }
            tekstWynikow.append(wyniki.get(i));
        }
        textViewWyniki.setText(tekstWynikow.toString());
    }

    private void pokazKomunikat(String komunikat) {
        Toast.makeText(this, komunikat, Toast.LENGTH_SHORT).show();
    }
}
