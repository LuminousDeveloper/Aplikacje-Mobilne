# 🎲 Losowanie Kostek (Android)

Projekt z przedmiotu **Aplikacje Mobilne**.
Na tym etapie **tylko interfejs w XML** — logika (losowanie + sortowanie) powstanie na kolejnych zajęciach.

## Elementy interfejsu ([`activity_main.xml`](app/src/main/res/layout/activity_main.xml))

| # | Element | Kluczowe ustawienia |
|---|---------|---------------------|
| 1 | `ScrollView` | pełny ekran |
| 2 | `LinearLayout` | orientacja pionowa, `padding 24dp` |
| 3 | Tytuł „Losowanie kostek" | **28sp**, **bold**, wiek centr. w poziomie |
| 4 | „Liczba kostek:" | **18sp**, do lewej |
| 5 | `EditText` `@+id/editTextLiczbaKostek` | inputType `number`, wartość domyślna `5`, hint „Podaj liczbę kostek" |
| 6 | `Button` `@+id/buttonLosuj` | „LOSUJ" |
| 7 | „Wylosowane kostki:" | **20sp bold** |
| 8 | `GridLayout` `@+id/gridKostki` | pusty kontener — kostki docelowo z kodu (`columnCount=1`, `alignMargins`, `center`, default margins) |
| 9 | „Wyniki:" | **20sp bold** |
| 10 | `TextView` `@+id/textViewWyniki` | „Wyniki pojawią się tutaj", **20sp** |
| 11 | `Button` `@+id/buttonRosnaco` | „SORTUJ ROSNĄCO" |
| 12 | `Button` `@+id/buttonMalejaco` | „SORTUJ MALEJĄCO" |

## Struktura

```
LosowanieKostek/
├── app/src/main/java/com/example/losowaniekostek/MainActivity.java   ← łączy layout z ekranem (logika zadebiutuje na kolejnych zajęciach)
└── app/src/main/res/layout/activity_main.xml                          ← interfejs według specyfikacji zadania
```

Pakiet kodu: `com.example.losowaniekostek`.

## 🚀 Uruchomienie

W Android Studio **File → Open…** → katalog `LosowanieKostek` → Gradle sync → **Run ▶**.
