package framework.utils;

import framework.browser.Browser;
import framework.exception.DriverError;
import org.openqa.selenium.JavascriptExecutor;

public class GetFilename {

    private static JavascriptExecutor js1 = (JavascriptExecutor) Browser.getDriver();
    private static String browser = ConfigReader.getProperty("browser");

    public static String getFilename() {
        if (browser.equals("chrome")) {
            Browser.getDriver().get("chrome://downloads");
            return (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
        }
        if (browser.equals("firefox")) {
            Browser.getDriver().get("about:downloads");
            return (String) js1.executeScript("return document.querySelector('#contentAreaDownloadsView .downloadMainArea .downloadContainer description:nth-of-type(1)').value");

        } else {
            throw new DriverError("Некорректно введено название драйвера. Допустимые названия 'chrome' , 'firefox'");
        }
    }
}
