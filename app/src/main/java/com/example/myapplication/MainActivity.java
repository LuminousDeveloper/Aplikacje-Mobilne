package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
                }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}