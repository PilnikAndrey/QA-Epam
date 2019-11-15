package project.form;

import framework.elements.Button;
import org.openqa.selenium.By;

public class SortMenu {

    private Button menuButton;

    public void clickMenuItem(By locator) {
        menuButton = new Button(locator);
        menuButton.clickButton();
    }
}
