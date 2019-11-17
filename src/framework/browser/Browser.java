package framework.browser;

import framework.exception.DriverError;
import framework.utils.ConfigReader;
import framework.waits.Waiter;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    private static WebDriver driver;

    private Browser() {
    }

    public static WebDriver getDriver() throws DriverError {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(ConfigReader.getProperty("browser"));
        }
        return driver;
    }

    public static void getUrl(String url) {
        Browser.getDriver().get(url);
    }

    public static void maximizeWindow() {
        Browser.getDriver().manage().window().maximize();
    }

    public static void setImplicitlyWait() {
        Waiter.implicitlyWait();
    }
}
