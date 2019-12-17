package framework.elements;

import framework.base.BaseElement;
import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropList extends BaseElement {

    public DropList(By locator, String nameOfElement) {
        super(locator, nameOfElement);
    }

    public void selectFromList(String selected) {
        Select elem = new Select(Browser.getDriver().findElement(locator));
        elem.selectByVisibleText(selected);
    }
}
