package project.pageObject;

import framework.elements.Block;
import framework.elements.Button;
import framework.utils.ConfigReader;
import framework.waits.Waiter;
import org.openqa.selenium.By;
import project.form.MainMenu;

public class MainPage {

    private By checkMainPageLocator = By.xpath("//div[contains(@class,'home_cluster_ctn home_ctn')]");
    private By installLocator = By.xpath("//div[contains(@class,'header_installsteam_btn header_installsteam_btn_green')]");
    private By gamesCategory = By.xpath("//div[@id='genre_tab']");

    private Block block = new Block(checkMainPageLocator);
    private Button buttonInstall = new Button(installLocator);

    private MainMenu mainMenu = new MainMenu();

    public boolean checkMainPage() {
        block.waitVisibilityOfElement();
        return block.isDisplayed();
    }

    public void clickInstallButton() {
        buttonInstall.clickButton();
    }

    public void chooseActionCategory() {
        mainMenu.clickGames(gamesCategory);
        Waiter.waitVisibilityOfElementLocated(actionsCategory());
        mainMenu.clickActions(actionsCategory());
    }




    private By actionsCategory() {
        String action = null;
        if (ConfigReader.getProperty("lang").equals("ru")) {
            action = "Экшен";
        }
        if (ConfigReader.getProperty("lang").equals("en-US")) {
            action = "Action";
        }
        return By.xpath("//a[@class='popup_menu_item'][contains(text(),'" + action + "')]");
    }


}
