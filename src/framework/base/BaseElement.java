package framework.base;

import framework.browser.Browser;
import framework.waits.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public abstract class BaseElement {

    private By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public void clickButton() {
        Browser.getDriver().findElement(locator).click();
    }

    public boolean isDisplayed() {
        return Browser.getDriver().findElement(locator).isDisplayed();
    }

    public void waitVisibilityOfElement() {
        Waiter.waitVisibilityOfElementLocated(locator);
    }

    public String getText() {
        return Browser.getDriver().findElement(locator).getText();
    }

    public ArrayList<WebElement> findElements() {
        return (ArrayList<WebElement>) Browser.getDriver().findElements(locator);
    }
}
