package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TourDetailsPage extends BasePage {

    // lokalizator przewijania strony
    private By searchBtnLocator = By.xpath("/html/body/div[5]/div[3]/div[2]/div[1]/span");
    // lokalizator select adults
    private By searchAdults = By.xpath("/html/body/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/table/tbody/tr[1]/td[1]/select");
// lokalizator select child
private By searchChild = By.xpath("/html/body/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/table/tbody/tr[2]/td[1]/select");
// lokalizator select infant
private By searchInfant = By.xpath("/html/body/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/table/tbody/tr[3]/td[1]/select");
// lokalizator book now
private By searchBook = By.xpath("/html/body/div[5]/div[3]/div[2]/div[2]/div/form/div[4]/button");

    public TourDetailsPage(WebDriver driver) {
        super(driver);
    }

    // Metoda przewijająca stronę do określonego elementu
    public TourDetailsPage scrollToSearchButton() {
        // 1. Czekamy na element
        WebElement searchBtn = wait.until(ExpectedConditions.presenceOfElementLocated(searchBtnLocator));

        // 2. Wykonujemy JavaScript scrollIntoView
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", searchBtn);

        // Zwracamy 'this', żeby utrzymać wzorzec Fluent Interface
        return this;
    }

    public void clicktsearchAdults(int index) {
        WebElement tourDetailsPage = wait.until(ExpectedConditions.elementToBeClickable(searchAdults));
        Select select = new Select(tourDetailsPage);
        select.selectByIndex(index);
    }
    public void clicktsearchChild(int index) {
        WebElement tourDetailsPage1 = wait.until(ExpectedConditions.elementToBeClickable(searchChild));
        Select select = new Select(tourDetailsPage1);
        select.selectByIndex(index);
    }
    public void clicktsearchInfant(int index) {
        WebElement tourDetailsPage2 = wait.until(ExpectedConditions.elementToBeClickable(searchInfant));
        Select select = new Select(tourDetailsPage2);
        select.selectByIndex(index);
    }
    public CheckoutPage clicktBookNow() {
        WebElement searchBtn1 = wait.until(ExpectedConditions.elementToBeClickable(searchBook));
        searchBtn1.click();
        return new CheckoutPage(driver);





}}
