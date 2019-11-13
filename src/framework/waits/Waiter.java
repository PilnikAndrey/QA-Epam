package framework.waits;

import framework.browser.Browser;
import framework.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    private static WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Integer.parseInt(ConfigReader.getProperty("explicitlyWait")));

    private static Wait<WebDriver> waitFluent = new FluentWait<>(Browser.getDriver());

    public static void waitVisibilityOfElementLocated(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void fluentWait(By locator) {
        waitFluent.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
