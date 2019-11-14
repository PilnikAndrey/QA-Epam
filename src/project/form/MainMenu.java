package project.form;

import framework.base.BaseForm;
import framework.elements.Button;
import framework.elements.DropList;
import org.openqa.selenium.By;

public class MainMenu extends BaseForm {

    private DropList gamesList;
    private Button actionsCategory;

    public void clickGames(By locator) {
        gamesList = new DropList(locator);
        gamesList.clickButton();
    }

    public void clickActions(By locator) {
        actionsCategory = new Button(locator);
        actionsCategory.clickButton();
    }
}
