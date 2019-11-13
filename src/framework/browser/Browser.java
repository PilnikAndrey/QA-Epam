package framework.browser;

import framework.exception.DriverError;
import framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    private static WebDriver driver;

    private Browser() {
    }

    public static WebDriver getDriver() throws DriverError {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("lang"));
        }
        return driver;
    }

    public static void getUrl(String url) {
        Browser.getDriver().get(url);
    }

    public static void maximizeWindow() {
        Browser.getDriver().manage().window().maximize();
    }

    public static void setImplicitlyWait(int timeout) {
        Browser.getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }
}
