# 📚 Aplikacje Mobilne — projekty z zajęć

Repozytorium zbiera **projekty z kolejnych zajęć** (Android Studio / XML / Kotlin-Java).
Zasada porządkowa: **jeden projekt = jeden katalog** w głównym katalogu repo.

## 🗂️ Projekty

| # | Projekt | Temat | Dokumentacja |
|---|---------|-------|--------------|
| 1 | [`WalidacjaFormularza/`](WalidacjaFormularza) | Podstawowa aplikacja z walidacją formularza (Java) | [README](WalidacjaFormularza/README.md) · [layout](WalidacjaFormularza/app/src/main/res/layout/activity_main.xml) |
| 2 | [`LosowanieKostek/`](LosowanieKostek) | Interfejs „Losowanie kostek" — czysty XML (logika dopiero na kolejnych zajęciach) | [README](LosowanieKostek/README.md) · [layout](LosowanieKostek/app/src/main/res/layout/activity_main.xml) |

## 🏗️ Struktura repozytorium

```
Aplikacje-Mobilne/
├── README.md                ← ten plik (spis projektów)
├── WalidacjaFormularza/     ← projekt 1: walidacja formularza
└── LosowanieKostek/         ← projekt 2: losowanie kostek
```

## 🚀 Jak uruchomić wybrany projekt

1. Sklonuj repo:
   ```bash
   git clone https://github.com/LuminousDeveloper/Aplikacje-Mobilne.git
   ```
2. W Android Studio: **File → Open…** i wybierz katalog *konkretnego projektu*, np. `LosowanieKostek`.
3. Projekt Gradle zsynchronizuje się automatycznie (w paczce jest własny wrapper Gradle).
