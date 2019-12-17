package project.pageObject;

import framework.elements.Button;
import framework.utils.ConfigReader;
import framework.utils.LogUtils;
import org.openqa.selenium.By;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class WelcomeSteamPage {
    private Button buttonInstall = new Button(By.xpath("//a[@class='about_install_steam_link']"), "'install' button on the 'Welcome Steam' page");


    public boolean isWelcomeSteamPageDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.", buttonInstall.getNameOfElement()));
        return buttonInstall.isDisplayed();
    }

    public void clickInstallButton(Path filePath) {
        buttonInstall.waitVisibilityOfElement();
        LogUtils.info(String.format("Click %s .", buttonInstall.getNameOfElement()));
        buttonInstall.click();
        LogUtils.info("Waiting for file upload");
        await().atMost(Integer.parseInt(ConfigReader.getProperty("explicitlyWait")), TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(() -> filePath.toFile().exists());
    }
}
