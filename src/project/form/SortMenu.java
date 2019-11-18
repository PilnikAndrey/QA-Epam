package project.form;

import framework.elements.Button;
import framework.utils.LogUtils;
import org.openqa.selenium.By;

public class SortMenu {

    private Button menuButton;

    public void clickMenuItem(By locator) {
        menuButton = new Button(locator,"TopSellers button");
        LogUtils.info(String.format("Click %s .",menuButton.getNameOfElement()));
        menuButton.click();
    }
}
