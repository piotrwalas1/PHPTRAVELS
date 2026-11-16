package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        WebDriver driver;

        if (browser != null && browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.setAcceptInsecureCerts(true);
            options.addArguments("--disable-features=HttpsUpgrades");
            options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://www.kurs-selenium.pl");

            driver = new ChromeDriver(options);
        } else if (browser != null && browser.equalsIgnoreCase("opera")) {
            ChromeOptions options = new ChromeOptions();

            // Twoja ścieżka do opera.exe
            options.setBinary("C:\\Users\\radek\\AppData\\Local\\Programs\\Opera\\opera.exe");

            options.addArguments("--remote-allow-origins=*");
            options.setAcceptInsecureCerts(true);

            // Flagi blokujące ekrany powitalne i data:, w Chromium/Opera
            options.addArguments("--no-first-run");
            options.addArguments("--no-default-browser-check");
            options.addArguments("--disable-search-engine-choice-screen"); // Kluczowe dla nowszych wersji

            options.addArguments("--disable-features=HttpsUpgrades");
            options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://www.kurs-selenium.pl");

            driver = new ChromeDriver(options);
        } else {
            // Konfiguracja dla Firefoxa
            FirefoxOptions options = new FirefoxOptions();
            options.setAcceptInsecureCerts(true);

            driver = new FirefoxDriver(options);
        }

        driver.manage().window().maximize();
        driverThread.set(driver);
    }

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driverThread.remove();
        }
    }
}