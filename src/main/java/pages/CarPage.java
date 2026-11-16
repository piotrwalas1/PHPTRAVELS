package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarPage extends BasePage {
    private By carDetails = By.xpath("//button[contains(@class, 'btn-action') and text()='Details']");

public CarPage(WebDriver driver) {super(driver);}

    public void carDetailClick(){
    WebElement carTab = wait.until(ExpectedConditions.elementToBeClickable(carDetails));
    carTab.click();
    }
}

