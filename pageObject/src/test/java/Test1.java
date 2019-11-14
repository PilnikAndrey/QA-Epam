import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Test1 {
    MainPage mainPage;
    @BeforeTest
    private void setup() {
        mainPage = new MainPage();
        Driver.maximizeWindow();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void equalsStartsAndHotels() throws InterruptedException {
        Driver.getDriver().get("https://www.agoda.com/");
        mainPage.enterCity();
        mainPage.enterStartDate();
      //  mainPage.enterEndDate();
        mainPage.searchHotel();
        mainPage.setStarts();
    }
    @AfterTest
    public void closeDriver() {
        Driver.getDriver().close();
    }
}
