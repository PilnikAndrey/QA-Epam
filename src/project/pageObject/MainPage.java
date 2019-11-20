package project.pageObject;

import framework.elements.Label;
import framework.elements.Button;
import framework.utils.LogUtils;
import org.openqa.selenium.By;
import project.form.MainMenu;

public class MainPage {

    private Label labelOfTheMainPage = new Label(By.xpath("//div[contains(@class,'home_cluster_ctn home_ctn')]"), "Label of the main page");
    private Button buttonInstall = new Button(By.xpath("//div[contains(@class,'header_installsteam_btn header_installsteam_btn_green')]"), "'install' button on the Main page");
    private Button homeButton = new Button(By.xpath("//div[@class='logo']"), "logo steam");
    private MainMenu mainMenu = new MainMenu();

    public boolean isMainPageDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.", labelOfTheMainPage.getNameOfElement()));
        labelOfTheMainPage.waitVisibilityOfElement();
        return labelOfTheMainPage.isDisplayed();
    }

    public void clickInstallButton() {
        LogUtils.info(String.format("Click %s .", buttonInstall.getNameOfElement()));
        buttonInstall.click();
    }

    public void chooseCategory(String menu, String category) {
        LogUtils.info("Click Games");
        mainMenu.clickGames(menu);
        LogUtils.info("Click Action category");
        mainMenu.clickCategory(category);
    }

    public void navigateToMainPage() {
        homeButton.click();
    }

}
