package pages;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class ToursPage extends BasePage{

    private By toursDetails = By.xpath("/html/body/div[5]/div[6]/div/div[3]/div/table/tbody/tr[1]/td/div[3]/a/button");

    public ToursPage(WebDriver driver) {
        super(driver);
    }
    public void clicktoursDetails() {
        WebElement toursTab = wait.until(ExpectedConditions.elementToBeClickable(toursDetails));
        toursTab.click();
    }

    }



