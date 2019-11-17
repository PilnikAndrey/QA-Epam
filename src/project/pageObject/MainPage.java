package project.pageObject;

import framework.elements.Block;
import framework.elements.Button;
import framework.utils.GetDictionary;
import framework.utils.LogUtils;
import framework.utils.XmlReader;
import framework.waits.Waiter;
import org.openqa.selenium.By;
import project.form.MainMenu;

public class MainPage {

    private By checkMainPageLocator = By.xpath("//div[contains(@class,'home_cluster_ctn home_ctn')]");
    private By installLocator = By.xpath("//div[contains(@class,'header_installsteam_btn header_installsteam_btn_green')]");
    private By gamesCategory = By.xpath("//div[@id='genre_tab']");
    private By actionsCategory = By.xpath(String
            .format("//a[@class='popup_menu_item'][contains(text(),'%s')]", XmlReader
                    .readXml(GetDictionary.getDictionary(), "actions")));
    private By indieCategory = By.xpath(String
            .format("//a[@class='popup_menu_item'][contains(text(),'%s')]", XmlReader
                    .readXml(GetDictionary.getDictionary(), "indi")));
    private Block block = new Block(checkMainPageLocator, "Div block of the main page");
    private Button buttonInstall = new Button(installLocator, "'install' button on the Main page");

    private MainMenu mainMenu = new MainMenu();

    public boolean checkMainPage() {
        LogUtils.getLog().info(String.format("Check %s is displayed.",block.getNameOfElement()));
        block.waitVisibilityOfElement();
        return block.isDisplayed();
    }

    public void clickInstallButton() {
        LogUtils.getLog().info(String.format("Click %s .",buttonInstall.getNameOfElement()));
        buttonInstall.clickButton();
    }

    public void chooseActionCategory() {
        LogUtils.getLog().info("Click Games");
        mainMenu.clickGames(gamesCategory);
        LogUtils.getLog().info("Click Action category");
        Waiter.waitVisibilityOfElementLocated(actionsCategory);
        mainMenu.clickCategory(actionsCategory);
    }

    public void chooseIndieCategory() {
        LogUtils.getLog().info("Click Games");
        mainMenu.clickGames(gamesCategory);
        LogUtils.getLog().info("Click Indie category");
        Waiter.waitVisibilityOfElementLocated(indieCategory);
        mainMenu.clickCategory(indieCategory);
    }

}
