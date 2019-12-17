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
    private Button loginButton = new Button(By.xpath("//a[@class='global_action_link']"), "loginButton");
    private Button searchButton = new Button(By.xpath("//input[@id='store_nav_search_term']"),"searchButton");
    private Button gta = new Button(By.xpath("//div[contains(@class,'match_name')][contains(text(),'Grand Theft Auto V')]"),"gtaButton");
    private Button freeCategory = new Button(By.xpath("//a[@class='gutter_item'][contains(text(),'Free to Play')]"),"freeCategory");
    private Button community = new Button(By.xpath("//a[contains(text(),'COMMUNITY')]"),"community");
    private Button discussions = new Button(By.xpath("//div[@class='supernav_content']//a[@class='submenuitem'][contains(text(),'Discussions')]"),"discussion");
    private Button yourStore = new Button(By.xpath("//a[contains(text(),'Your Store')]"),"steamCurator");
    private Button steamCurators = new Button(By.xpath("//a[@class='popup_menu_item'][contains(text(),'Steam Curators')]"),"steamCurators");
    private MainMenu mainMenu = new MainMenu();

    public void clickLogin() {
        loginButton.click();
    }

    public void clickDiscussion() {
        community.hoverElement();
        discussions.click();
    }

    public boolean isMainPageDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.", labelOfTheMainPage.getNameOfElement()));
        labelOfTheMainPage.waitVisibilityOfElement();
        return labelOfTheMainPage.isDisplayed();
    }

    public void clickSteamCurator() {
        yourStore.hoverElement();
        steamCurators.click();
    }

    public void clickFreeCategory() {
        freeCategory.click();
    }

    public void clickInstallButton() {
        LogUtils.info(String.format("Click %s .", buttonInstall.getNameOfElement()));
        buttonInstall.click();
    }

    public void clickGta() {
        gta.click();
    }

    public void searchGta() {
        searchButton.sendKeys("gta");
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
