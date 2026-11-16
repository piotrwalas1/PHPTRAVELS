# ✈️ PHPTRAVELS – Multi-Browser Test Automation Framework - w trakcie budowy

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Selenium](https://img.shields.io/badge/Selenium-4.18.1-43B02A?style=for-the-badge&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.9.0-FF6C37?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven)
![Allure Report](https://img.shields.io/badge/Allure-Report-FFCC00?style=for-the-badge)

Kompleksowy framework do automatyzacji testów End-to-End (E2E) dla aplikacji webowej **PHPTRAVELS**, zbudowany w oparciu o wzorzec projektowy **Page Object Model (POM)**. Projekt wspiera równoległe uruchamianie testów na wielu przeglądarkach jednocześnie oraz generuje czytelne, interaktywne raporty za pomocą **Allure**.

---

## 🚀 Kluczowe funkcjonalności

* **Wsparcie Multi-Browser & Parallel Execution:** Równoległe wykonywanie testów jednocześnie na przeglądarkach **Google Chrome**, **Mozilla Firefox** oraz **Opera** dzięki konfiguracji TestNG (`parallel="tests"`).
* **Page Object Model (POM):** Czysty podział na klasy stron (`HomePage`, `ToursPage`, `TourDetailsPage`, `CarPage`, `CarDetailsPage`, `CheckoutPage`) oraz logikę testową, co gwarantuje łatwą utrzymywalność kodu.
* **Raportowanie Allure:** Szczegółowe raporty z wykonania testów zawierające kroki testowe, czasy wykonania oraz statusy w podziale na przeglądarki.
* **Stabilne mechanizmy synchronizacji:** Wykorzystanie `WebDriverWait`, `ExpectedConditions` oraz bezpiecznego fallbacku z użyciem `JavascriptExecutor` eliminującego problemy z dynamicznym renderowaniem elementów w silnikach Chromium.
* **Zarządzanie zależnościami Maven:** Pełna automatyzacja pobierania bibliotek i uruchamiania pakietów testowych z poziomu linii poleceń lub CI/CD.

---

## 🛠️ Stack technologiczny

| Technologia | Wersja / Rola |
| :--- | :--- |
| **Java** | `17` – język programowania |
| **Selenium WebDriver** | `4.18.1` – automatyzacja przeglądarki |
| **TestNG** | `7.9.0` – silnik testowy, asercje i zrównoleglenie |
| **Allure TestNG** | `2.25.0` – generowanie raportów z testów |
| **Apache Maven** | Zarządzanie projektem i budowanie |

---

## 📁 Struktura projektu

```text
PHPTRAVELS/
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── BasePage.java           # Bazowa klasa dla wszystkich obiektów stron (inicjalizacja WebDrivera i Waitów)
│   │   └── pages/
│   │       ├── HomePage.java           # Strona główna (wyszukiwarka wycieczek i samochodów)
│   │       ├── ToursPage.java          # Wyniki wyszukiwania wycieczek
│   │       ├── TourDetailsPage.java    # Szczegóły wybranej wycieczki
│   │       ├── CarPage.java            # Wyniki wyszukiwania samochodów
│   │       ├── CarDetailsPage.java     # Szczegóły wybranego samochodu
│   │       └── CheckoutPage.java       # Finalizacja rezerwacji
│   └── test/java/
│       ├── base/
│       │   └── BaseTest.java           # Konfiguracja przeglądarek (Chrome, Firefox, Opera), @BeforeMethod / @AfterMethod
│       └── tests/
│           └── TourBookingTest.java    # Scenariusze testowe rezerwacji wycieczek i aut
├── pom.xml                             # Konfiguracja zależności Maven i wtyczek
└── testng.xml                          # Konfiguracja suity testowej i parametrów równoległego uruchamiania

```
▶️ Uruchamianie testów
1. Uruchomienie pełnej suity Multi-Browser (Maven)
Aby uruchomić wszystkie testy równolegle na przeglądarkach zdefiniowanych w testng.xml:
bash - mvn clean test
2. Uruchomienie z poziomu IDE (IntelliJ IDEA)
Kliknij prawym przyciskiem myszy plik testng.xml i wybierz opcję Run '.../testng.xml'.
📊 Generowanie raportu Allure
Po zakończeniu wykonania testów wyniki zapisywane są w folderze allure-results. Aby wygenerować i otworzyć interaktywny raport w przeglądarce, wpisz w terminalu:

Bash - allure serve allure-results
📝 Pokrycie testowe (Przykładowe scenariusze)
Wyszukiwanie i rezerwacja wycieczek (Tours): Wybór daty, liczby dorosłych gości, rodzaju wycieczki (Select2) oraz nawigacja do szczegółów oferty.

Wyszukiwanie wynajmu samochodów (Cars): Przełączanie zakładek wyszukiwarki, pobieranie i wybór lokalizacji odbioru pojazdu, konfiguracja dat oraz godzin odbioru i zwrotu.
