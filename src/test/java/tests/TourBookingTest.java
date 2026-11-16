package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TourBookingTest extends BaseTest {

    // --- PIERWSZY TEST ---
    @Test
    public void testNavigateAndSelectFirstTour() {
        HomePage homePage = new HomePage(BaseTest.getDriver());
        homePage.openHomePage();
        homePage.clickToursTab();


        homePage.selectDate("16/11/2026");
        homePage.selectDropdownOption(1);
        homePage.selectTourType();
       homePage.clickSearch();

       ToursPage toursPage = new ToursPage(BaseTest.getDriver());
       toursPage.clicktoursDetails();

       TourDetailsPage tourDetailsPage = new TourDetailsPage(BaseTest.getDriver());
       tourDetailsPage.scrollToSearchButton();
       tourDetailsPage.clicktsearchAdults(2);
       tourDetailsPage.clicktsearchChild(2);
       tourDetailsPage.clicktsearchInfant(2);
       tourDetailsPage.clicktBookNow();

        CheckoutPage checkoutPage = new CheckoutPage(BaseTest.getDriver());
        checkoutPage.enterFirstName("Zenek");
        checkoutPage.enterLastName("Nowak");
        checkoutPage.enterEmail("zenek@o2.pl");
        checkoutPage.confirmEmail("zenek@o2.pl");
        checkoutPage.enterMobile("555555111");
        checkoutPage.enterAdres("Orkana 33");
        checkoutPage.selectCountry("Poland");
        checkoutPage.scrollToConfirmButton();
        checkoutPage.confirm();


      String currentUrl = BaseTest.getDriver().getCurrentUrl();
      Assert.assertTrue(currentUrl.contains("demo"), "Nie udało się przejść do szczegółów wycieczki!");



    }

    // --- DRUGI TEST (Inna wycieczka, inne dane) ---
    @Test
   
    public void testSelectThirdCarLocation() {
        HomePage homePage = new HomePage(BaseTest.getDriver());
        homePage.openHomePage();

        // Przechodzimy do zakładki Cars
        homePage.clickCars();
        // Wybieramy 3. element z listy (indeks 2, ponieważ liczymy od zera: 0, 1, 2)
        homePage.selectCarLocationByIndex(2);
        homePage.selectCarDate("18/11/2026");
        // 3. Wybieramy konkretną godzinę (np. "01:00" na podstawie value lub tekstu)
        homePage.selectPickupTimeByValue("01:00");
        homePage.selectReturnDate("25/11/2026");
        homePage.selectPickupReturnTimeByValue("13:00");
        homePage.selectSearchButon();

        CarPage carPage = new CarPage(BaseTest.getDriver());
        carPage.carDetailClick();

        CarDetailsPage carDetailsPage = new CarDetailsPage(BaseTest.getDriver());
       carDetailsPage.scrollToSearchButtonCar();
        carDetailsPage.bookNowClick();

        CheckoutPage checkoutPage = new CheckoutPage(BaseTest.getDriver());
        checkoutPage.enterFirstName("Maciek");
        checkoutPage.enterLastName("Kowalski");
        checkoutPage.enterEmail("maciek@o2.pl");
        checkoutPage.confirmEmail("maciek@o2.pl");
        checkoutPage.enterMobile("666555111");
        checkoutPage.enterAdres("Jana Pawla33");
        checkoutPage.selectCountry("Poland");
        checkoutPage.scrollToConfirmButton();
        checkoutPage.confirm();


        String currentUrl = BaseTest.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("demo"), "Nie udało się przejść do szczegółów wycieczki!");



    }

}