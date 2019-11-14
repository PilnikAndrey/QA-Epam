package utils;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
    public static void explicitWait(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
