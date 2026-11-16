package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    // Zakładka TOURS w widżecie wyszukiwania na stronie głównej
    private By toursTabLocator = By.xpath("//a[@href='#tours']");

    // Pole daty w sekcji Tours
    private By dateInputLocator = By.name("date");

    // Lista rozwijana (Select) w sekcji Guests
    private By selectDropdownLocator = By.id("adults");

    // Lokalizator do rozwinięcia listy Select2 (rodzaj wycieczki)
    private By tourTypeDropdownLocator = By.xpath("//div[@id='s2id_tourtype']//a[@class='select2-choice']");

    // Przykładowy lokalizator do wyboru konkretnej opcji z listy
    private By tourTypeOptionLocator = By.xpath("//div[@id='select2-drop']//div[contains(text(), 'Private')]");

    // Przycisk wyszukiwania wycieczek (stabilny XPath oparty o formularz i typ)
    private By searchButtonLocator = By.xpath("//div[@id='tours']//button[@type='submit']");

    // Zakładka Cars
    private By carsTabLocator = By.xpath("//a[@href='#cars']");

    // Wybór lokalizacji odbioru aut (stabilny XPath oparty o strukturę kontenera samochodów)
    private By carsSelect = By.xpath("//div[@id='cars']//div[contains(@class, 'select2-container')]//a");
    private By carsOptionsListLocator = By.xpath("//div[@id='select2-drop']//ul[@class='select2-results']/li");

    // Pola dat i czasu dla samochodów
    private By carsSelectDate = By.name("pickupDate");
    private By pickupTimeDropdownLocator = By.name("pickupTime");
    private By carSelectDatereturn = By.name("dropoffDate");
    private By pickupTimeReturnDate = By.name("dropoffTime");

    // Przycisk wyszukiwania samochodów (stabilny XPath)
    private By CarSearchByton = By.xpath("//div[@id='cars']//button[@type='submit']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get("http://www.kurs-selenium.pl/demo/");
    }

    // 1. Kliknięcie zakładki Tours (uodpornione na timeouty w Chromium)
    public void clickToursTab() {
        WebElement toursTab = wait.until(ExpectedConditions.presenceOfElementLocated(toursTabLocator));
        try {
            toursTab.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toursTab);
        }
    }

    // 2. Wpisanie daty
    public void selectDate(String date) {
        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(dateInputLocator));
        dateInput.clear();
        dateInput.sendKeys(date);
    }

    // 3. Wybór opcji z elementu <select> liczba osob
    public void selectDropdownOption(int index) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(selectDropdownLocator));
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    public void selectTourType() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(tourTypeDropdownLocator));
        dropdown.click();

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(tourTypeOptionLocator));
        option.click();
    }

    // 5. Kliknięcie przycisku search dla wycieczek
    public ToursPage clickSearch() {
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchBtn.click();
        return new ToursPage(driver);
    }

    // Kliknięcie zakładki Cars (uodpornione na timeouty w Chromium)
    public ToursPage clickCars() {
        WebElement clickCarTab = wait.until(ExpectedConditions.presenceOfElementLocated(carsTabLocator));
        try {
            clickCarTab.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickCarTab);
        }
        return new ToursPage(driver);
    }

    // Metoda pobierająca wszystkie opcje z listy lokalizacji aut
    public List<String> getgetCarsLocationsTextList() { // zachowano oryginalną nazwę
        WebElement clickCarSelect = wait.until(ExpectedConditions.elementToBeClickable(carsSelect));
        clickCarSelect.click();

        List<WebElement> optionsElements = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(carsOptionsListLocator)
        );

        List<String> locationsNames = new ArrayList<>();
        for (WebElement option : optionsElements) {
            String text = option.getText();
            if (!text.isEmpty()) {
                locationsNames.add(text);
            }
        }

        return locationsNames;
    }

    // Wybór lokalizacji auta po indeksie
    public void selectCarLocationByIndex(int index) {
        WebElement clickCarSelect = wait.until(ExpectedConditions.elementToBeClickable(carsSelect));
        clickCarSelect.click();

        List<WebElement> options = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(carsOptionsListLocator)
        );

        if (options.size() > index) {
            WebElement selectedOption = options.get(index);
            System.out.println("Wybieram opcję nr " + (index + 1) + ": " + selectedOption.getText());
            selectedOption.click();
        } else {
            throw new IllegalArgumentException("Indeks " + index + " jest poza zakresem! Lista ma tylko " + options.size() + " elementów.");
        }
    }

    // Wpisanie daty odbioru auta
    public void selectCarDate(String date) {
        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(carsSelectDate));
        dateInput.clear();
        dateInput.sendKeys(date);
    }

    // Pobranie opcji godziny odbioru
    public List<String> getPickupTimeOptions() {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(pickupTimeDropdownLocator));
        Select select = new Select(dropdownElement);

        List<WebElement> optionsElements = select.getOptions();
        List<String> timeOptionsList = new ArrayList<>();

        for (WebElement option : optionsElements) {
            timeOptionsList.add(option.getText());
        }
        return timeOptionsList;
    }

    // Wybór godziny odbioru po wartości
    public void selectPickupTimeByValue(String timeValue) {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(pickupTimeDropdownLocator));
        Select select = new Select(dropdownElement);
        select.selectByValue(timeValue);
    }

    // Wpisanie daty zwrotu auta
    public void selectReturnDate(String date) {
        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(carSelectDatereturn));
        dateInput.clear();
        dateInput.sendKeys(date);
    }

    public List<String> getPickupTimeReturnOptions() {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(pickupTimeReturnDate));
        Select select = new Select(dropdownElement);

        List<WebElement> optionsElements = select.getOptions();
        List<String> timeOptionsList = new ArrayList<>();

        for (WebElement option : optionsElements) {
            timeOptionsList.add(option.getText());
        }
        return timeOptionsList;
    }

    // Wybór godziny zwrotu po wartości
    public void selectPickupReturnTimeByValue(String timeValue) {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(pickupTimeReturnDate));
        Select select = new Select(dropdownElement);
        select.selectByValue(timeValue);
    }

    // Kliknięcie przycisku wyszukiwania aut
    public void selectSearchButon() {
        WebElement ButonSearch = wait.until(ExpectedConditions.elementToBeClickable(CarSearchByton));
        try {
            ButonSearch.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ButonSearch);
        }
    }
}