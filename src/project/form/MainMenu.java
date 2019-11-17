package project.form;

import framework.elements.Button;
import framework.elements.DropList;
import framework.utils.LogUtils;
import org.openqa.selenium.By;

public class MainMenu {

    private DropList gamesList;
    private Button actionsCategory;

    public void clickGames(By locator) {
        gamesList = new DropList(locator,"Games button");
        LogUtils.getLog().info(String.format("Hover %s.",gamesList.getNameOfElement()));
        gamesList.hoverElement();
    }

    public void clickCategory(By locator) {
        actionsCategory = new Button(locator,"Category button");
        LogUtils.getLog().info(String.format("Click %s.",actionsCategory.getNameOfElement()));
        actionsCategory.clickButton();
    }
}
