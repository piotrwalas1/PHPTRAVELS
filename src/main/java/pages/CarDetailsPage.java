package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarDetailsPage extends BasePage {

    private By bookNowLocator = By.xpath("//button[text()='Book Now' and contains(@class, 'btn-action')]");


    public CarDetailsPage(WebDriver driver) {super(driver);}


    // Metoda przewijająca stronę do określonego elementu
    public CarDetailsPage scrollToSearchButtonCar() {
        // 1. Czekamy na element
        WebElement searchBtn = wait.until(ExpectedConditions.presenceOfElementLocated(bookNowLocator));

        // 2. Wykonujemy JavaScript scrollIntoView
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", searchBtn);

        // Zwracamy 'this', żeby utrzymać wzorzec Fluent Interface
        return this;
    }

    public void bookNowClick(){
        WebElement butonClick = wait.until(ExpectedConditions.elementToBeClickable(bookNowLocator));
        butonClick.click();
    }

}
