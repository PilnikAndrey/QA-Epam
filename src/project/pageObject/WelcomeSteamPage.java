package project.pageObject;

import framework.elements.Button;
import framework.utils.ConfigReader;
import framework.utils.ExistFile;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class WelcomeSteamPage {
    private By installLocator = By.xpath("//a[@class='about_install_steam_link']");
    private Button buttonInstall = new Button(installLocator);

    public boolean checkWelcomeSteamPage() {
        return buttonInstall.isDisplayed();
    }

    public void clickInstallButton() {
        buttonInstall.waitVisibilityOfElement();
        buttonInstall.clickButton();
        await().atMost(Integer.parseInt(ConfigReader.getProperty("explicitlyWait")), TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(ExistFile::checkExistFile);


    }

}
