package project.pageObject;

import framework.elements.Label;
import framework.elements.Button;
import framework.utils.GetDictionary;
import framework.utils.LogUtils;
import framework.utils.XmlReader;
import framework.waits.Waiter;
import org.openqa.selenium.By;
import project.form.MainMenu;

public class MainPage {

    private By gamesCategory = By.xpath("//div[@id='genre_tab']");
    private By actionsCategory = By.xpath(String
            .format("//a[@class='popup_menu_item'][contains(text(),'%s')]", XmlReader
                    .readXml(GetDictionary.getDictionary(), "actions")));
    private By indieCategory = By.xpath(String
            .format("//a[@class='popup_menu_item'][contains(text(),'%s')]", XmlReader
                    .readXml(GetDictionary.getDictionary(), "indi")));
    private Label label = new Label(By.xpath("//div[contains(@class,'home_cluster_ctn home_ctn')]"), "Div block of the main page");
    private Button buttonInstall = new Button(By.xpath("//div[contains(@class,'header_installsteam_btn header_installsteam_btn_green')]"), "'install' button on the Main page");

    private MainMenu mainMenu = new MainMenu();

    public boolean isCheckMainPage() {
        LogUtils.info(String.format("Check %s is displayed.", label.getNameOfElement()));
        label.waitVisibilityOfElement();
        return label.isDisplayed();
    }

    public void clickInstallButton() {
        LogUtils.info(String.format("Click %s .",buttonInstall.getNameOfElement()));
        buttonInstall.click();
    }

    public void chooseActionCategory() {
        LogUtils.info("Click Games");
        mainMenu.clickGames(gamesCategory);
        LogUtils.info("Click Action category");
        Waiter.waitVisibilityOfElementLocated(actionsCategory);
        mainMenu.clickCategory(actionsCategory);
    }

    public void chooseIndieCategory() {
        LogUtils.info("Click Games");
        mainMenu.clickGames(gamesCategory);
        LogUtils.info("Click Indie category");
        Waiter.waitVisibilityOfElementLocated(indieCategory);
        mainMenu.clickCategory(indieCategory);
    }

}
