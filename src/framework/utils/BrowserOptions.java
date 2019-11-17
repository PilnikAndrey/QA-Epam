package framework.utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;

public class BrowserOptions {
    public static ChromeOptions chromeOptions() {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", XmlReader.readXml(ConfigReader.getProperty("datafile"),"path"));
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("intl.accept_languages", ConfigReader.getProperty("lang"));
        chromePrefs.put("browser.download.manager.closeWhenDone", false);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        return options;
    }

    public static FirefoxOptions firefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.dir", XmlReader.readXml(ConfigReader.getProperty("datafile"),"path"));
        options.addPreference("browser.download.useDownloadDir", true);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-debian-package");
        options.addPreference("pdfjs.disabled", true);
        options.addPreference("intl.accept_languages", ConfigReader.getProperty("lang"));
        return options;
    }
}
