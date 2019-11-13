package framework.browser;

import framework.exception.DriverError;
import framework.utils.XmlReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;

public class BrowserFactory {

    public static WebDriver getBrowser(String browserName, String lang) {
        browserName = browserName.toLowerCase();
        if (!lang.equals("ru") && !lang.equals("en-US")) {
            throw new DriverError("Некорректно введено название языка. Допустимые названия 'ru' , 'en-US'");
        }
        if (browserName.equals("chrome")) {
            return getChromeInstance(lang);
        }
        if (browserName.equals("firefox")) {
            return getFfInstance(lang);
        } else {
            throw new DriverError("Некорректно введено название драйвера. Допустимые названия 'chrome' , 'firefox'");
        }
    }

    private static FirefoxDriver getFfInstance(String lang) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.dir", XmlReader.readXml("path"));
        options.addPreference("browser.download.useDownloadDir", true);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-debian-package");
        options.addPreference("pdfjs.disabled", true);
        options.addPreference("intl.accept_languages", lang);
        return new FirefoxDriver(options);
    }

    private static ChromeDriver getChromeInstance(String lang) {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", XmlReader.readXml("path"));
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("intl.accept_languages", lang);
        chromePrefs.put("browser.download.manager.closeWhenDone", false);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        return new ChromeDriver(options);
    }
}
