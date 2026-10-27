# ✅ Walidacja Formularza (Android)

Projekt z przedmiotu **Aplikacje Mobilne** (Android Studio, Java).
Aplikacja z formularzem i podstawową walidacją danych wprowadzanych przez użytkownika.

## Co robi aplikacja

- Formularz z polami tekstowymi (`TextView`/`EditText`) i przyciskiem zatwierdzania formularza.
- Walidacja pól odbywa się w metodzie `checkValues()` w klasie [`MainActivity`](app/src/main/java/com/example/walidacjaformularza/MainActivity.java) — m.in. **hasło musi mieć min. 8 znaków** (błąd wyświetlany funkcją `setError` na polu).
- Przy poprawnych danych formularz przechodzi dalej; przy błędach wyświetla komunikaty przy polach.

## Struktura

```
WalidacjaFormularza/
├── app/src/main/java/com/example/walidacjaformularza/MainActivity.java   ← logika + walidacja
├── app/src/main/res/layout/activity_main.xml                             ← interfejs (layout)
└── app/src/main/res/values/strings.xml                                   ← nazwa aplikacji
```

Pakiet kodu: `com.example.walidacjaformularza`.

## 🚀 Uruchomienie

W Android Studio **File → Open…** → katalog `WalidacjaFormularza` → zgrabka Gradle sync → **Run ▶** na simulatorze lub na telefonie.
