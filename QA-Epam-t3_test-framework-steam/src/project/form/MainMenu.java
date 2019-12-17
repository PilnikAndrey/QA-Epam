package project.form;

import framework.elements.Button;
import framework.utils.LogUtils;
import org.openqa.selenium.By;

public class MainMenu {

    public void clickGames(String menu) {
        Button gamesList = new Button(By.xpath(String.format("//a[@class='pulldown_desktop'][contains(text(),'%s')]", menu)), "Games button");
        LogUtils.info(String.format("Hover %s.", gamesList.getNameOfElement()));
        gamesList.hoverElement();
    }

    public void clickCategory(String category) {
        Button actionsCategory = new Button(By.xpath(String
                .format("//a[@class='popup_menu_item'][contains(text(),'%s')]", category)), "Category button");
        actionsCategory.waitVisibilityOfElement();
        LogUtils.info(String.format("Click %s.", actionsCategory.getNameOfElement()));
        actionsCategory.click();
    }
}
