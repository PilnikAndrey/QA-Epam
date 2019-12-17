package framework.waits;

import framework.browser.Browser;
import framework.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    private static WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Integer.parseInt(ConfigReader.getProperty("explicitlyWait")));

    public static void waitVisibilityOfElementLocated(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
