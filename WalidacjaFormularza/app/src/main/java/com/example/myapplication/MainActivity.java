package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText Imie;
    private EditText Nazwisko;
    private EditText Email;
    private EditText Password;
    private Button btnRejestracja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Imie = findViewById(R.id.Imie);
        Nazwisko = findViewById(R.id.Nazwisko);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        btnRejestracja = findViewById(R.id.btnRejestracja);

        btnRejestracja.setOnClickListener(v -> {
            if (!checkValues()) {
                return;
            }
            Toast.makeText(this, "Rejestracja OK", Toast.LENGTH_SHORT).show();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private boolean checkValues() {
        String imie = Imie.getText().toString().trim();
        String nazwisko = Nazwisko.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String haslo = Password.getText().toString().trim();

        if (imie.isEmpty()) {
            Imie.setError("Wpisz imię");
            return false;
        }

        if (nazwisko.isEmpty()) {
            Nazwisko.setError("Wpisz nazwisko");
            return false;
        }

        if (email.isEmpty()) {
            Email.setError("Wpisz email");
            return false;
        }

        if (!email.contains("@")) {
            Email.setError("Email musi mieć @");
            return false;
        }

        if (haslo.isEmpty()) {
            Password.setError("Wpisz hasło");
            return false;
        }

        if (haslo.length() < 8) {
            Password.setError("Hasło min. 8 znaków");
            return false;
        }

        return true;
    }
}