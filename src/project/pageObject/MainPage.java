package project.pageObject;

import framework.elements.Block;
import framework.elements.Button;
import org.openqa.selenium.By;

public class MainPage {

    private By checkMainPageLocator = By.xpath("//div[contains(@class,'home_cluster_ctn home_ctn')]");
    private By installLocator = By.xpath("//div[contains(@class,'header_installsteam_btn header_installsteam_btn_green')]");

    private Block block = new Block(checkMainPageLocator);
    private Button buttonInstall = new Button(installLocator);

    public boolean checkMainPage() {
        block.waitVisibilityOfElement();
        return block.isDisplayed();
    }

    public void clickInstallButton() {
        buttonInstall.clickButton();
    }


}
