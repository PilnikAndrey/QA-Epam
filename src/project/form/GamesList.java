package project.form;

import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class GamesList {
    private SortMenu sortMenu = new SortMenu();


    public SortMenu getSortMenu() {
        return sortMenu;
    }

    public ArrayList<WebElement> getDiscountGames(By locator) {
        Button button = new Button(locator);
        return button.findElements();
    }


}
