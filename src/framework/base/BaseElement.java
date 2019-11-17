package framework.base;

import framework.browser.Browser;
import framework.waits.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public abstract class BaseElement {

    private By locator;
    private String nameOfElement;

    public BaseElement(By locator, String nameOfElement) {
        this.locator = locator;
        this.nameOfElement = nameOfElement;
    }

    public void clickButton() {
        Browser.getDriver().findElement(locator).click();
    }

    public String getNameOfElement() {
        return nameOfElement;
    }

    public boolean isDisplayed() {
        return Browser.getDriver().findElements(locator).size() > 0;
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

    public void hoverElement() {
        Actions actions = new Actions(Browser.getDriver());
        WebElement elementMenu = Browser.getDriver().findElement(locator);
        actions.moveToElement(elementMenu).perform();
    }
}
