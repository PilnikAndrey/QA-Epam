package framework.browser;

import framework.exception.DriverError;
import framework.utils.ConfigReader;
import framework.utils.LogUtils;
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
        LogUtils.info(String.format("Go to %s .", url));
        Browser.getDriver().get(url);
    }

    public static void maximizeWindow() {
        LogUtils.info("Maximize window");
        Browser.getDriver().manage().window().maximize();
    }

    public static void setImplicitlyWait() {
        LogUtils.info("Set implicitly wait");
        Browser.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(ConfigReader.getProperty("implicitlyWait")), TimeUnit.SECONDS);
    }
}
