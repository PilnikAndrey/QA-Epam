package framework.elements;

import framework.base.BaseElement;
import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DropList extends BaseElement {

    private By elementOfList;

    public DropList(By locator) {
        super(locator);
        elementOfList = locator;
    }

    public void hoverElement() {
        Actions actions = new Actions(Browser.getDriver());
        WebElement elementMenu = Browser.getDriver().findElement(elementOfList);
        actions.moveToElement(elementMenu).perform();
    }

}
