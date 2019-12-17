package framework.browser;

import framework.exception.DriverError;
import framework.utils.BrowserOptions;
import framework.utils.ConfigReader;
import framework.utils.LogUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {

    public static WebDriver getBrowser(String browserName) {
        browserName = browserName.toLowerCase();
        String lang = ConfigReader.getProperty("lang");
        if (!lang.equals("ru") && !lang.equals("en-US")) {
            throw new DriverError("Некорректно введено название языка. Допустимые названия 'ru' , 'en-US'");
        }
        if (browserName.equals("chrome")) {
            return getChromeInstance();
        }
        if (browserName.equals("firefox")) {
            return getFfInstance();
        } else {
            throw new DriverError("Некорректно введено название драйвера. Допустимые названия 'chrome' , 'firefox'");
        }
    }

    private static FirefoxDriver getFfInstance() {
        LogUtils.info(String.format("Get firefox driver"));
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(BrowserOptions.firefoxOptions());
    }

    private static ChromeDriver getChromeInstance() {
        LogUtils.info(String.format("Get chrome driver"));
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(BrowserOptions.chromeOptions());
    }
}
