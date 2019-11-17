package project.pageObject;

import framework.elements.Button;
import framework.utils.ConfigReader;
import framework.utils.ExistFile;
import framework.utils.LogUtils;
import org.openqa.selenium.By;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class WelcomeSteamPage {
    private By installLocator = By.xpath("//a[@class='about_install_steam_link']");
    private Button buttonInstall = new Button(installLocator, "'install' button on the 'Welcome Steam' page");
    private Path filePath = Paths.get(ConfigReader.getProperty("download_folder") + ConfigReader.getProperty("file_name"));


    public boolean checkWelcomeSteamPage() {
        LogUtils.getLog().info(String.format("Check %s is displayed.",buttonInstall.getNameOfElement()));
        return buttonInstall.isDisplayed();
    }

    public void clickInstallButton() {
        buttonInstall.waitVisibilityOfElement();
        LogUtils.getLog().info(String.format("Click %s .",buttonInstall.getNameOfElement()));
        buttonInstall.clickButton();
        LogUtils.getLog().info("Waiting for file upload");
        await().atMost(Integer.parseInt(ConfigReader.getProperty("explicitlyWait")), TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(() -> filePath.toFile().exists());

    }
}
