package pages;
import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage{
    // lokalizator firstname
   private By LocatorFirstName = By.name("firstname");
    // lokalizator lasttname
private By LocatorLastName = By.name("lastname");
    // lokalizator email
private By Locatoremail = By.name("email");
    //lokalizator potwierdz email
private By LocatorConfirmemail = By.name("confirmemail");
    // lokalizator mobile
private By LocatorMobile = By.name("phone");
    // lokalizator adres
private By LocatorAdres = By.name("address");
    // lokalizator country
private By LocatorCountry = By.xpath("/html/body/div[5]/div[1]/div/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[1]/form/div[6]/div[2]/div/div/a");
    // lokalizator confirm this booking
    private By LocatorConfirm = By.xpath("/html/body/div[5]/div[1]/div/div/div/div[1]/div[2]/div[4]/button");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void enterFirstName(String firstName) {

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(LocatorFirstName));
        input.clear();
        input.sendKeys(firstName); }

    public void enterLastName(String lastName) {

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(LocatorLastName));
        input.clear();
        input.sendKeys(lastName); }

    public void enterEmail(String email) {

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(Locatoremail));
        input.clear();
        input.sendKeys(email); }

    public void enterMobile(String mobile) {

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(LocatorMobile));
        input.clear();
        input.sendKeys(mobile); }
    public void confirmEmail(String email2) {

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(LocatorConfirmemail));
        input.clear();
        input.sendKeys(email2); }

    public void enterAdres(String adres) {

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(LocatorAdres));
        input.clear();
        input.sendKeys(adres); }

    // 1. Lokalizator głównego pola wyboru kraju
    private By countryDropdownLocator = By.xpath("//div[@id='s2id_autogen1']//a[@class='select2-choice']");

    // 2. Lokalizator pola tekstowego wyszukiwarki w rozwijanym menu Select2
    private By countrySearchInputLocator = By.xpath("//div[@id='select2-drop']//input[@type='text']");

    // Metoda obsługująca kliknięcie, wpisanie kraju i wybranie go
    public CheckoutPage selectCountry(String countryName) {
        // Krok 1: Klikamy w pole, aby otworzyć listę rozwijaną
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(countryDropdownLocator));
        dropdown.click();

        // Krok 2: Czekamy na pojawienie się pola input do wpisywania i wpisujemy nazwę kraju
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(countrySearchInputLocator));
        searchInput.sendKeys(countryName);
        searchInput.sendKeys(Keys.ENTER);


      return this; // Zwracamy 'this' dla zachowania wzorca Fluent
   }

    // Metoda przewijająca stronę do przycisku potwierdzenia
    public CheckoutPage scrollToConfirmButton() {
        // Czekamy, aż przycisk będzie widoczny
        WebElement confirmBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(LocatorConfirm));

        // 'false' sprawia, że element dosunie się do dolnej krawędzi widoku
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", confirmBtn);

        return this;
    }

    public CheckoutPage confirm() {
        // Krok 1: Klikamy w pole, aby otworzyć listę rozwijaną
        WebElement dropdown1 = wait.until(ExpectedConditions.elementToBeClickable(LocatorConfirm));
        dropdown1.click();
        return this;
}}
