package project.test;

import framework.utils.ConfigReader;
import framework.utils.FileUtils;
import framework.utils.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.pageObject.MainPage;
import project.pageObject.WelcomeSteamPage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SteamDownload extends Base {

    private MainPage mainPage;
    private WelcomeSteamPage welcomeSteamPage;
    private Path filePath = Paths.get(String.format(System.getProperty("user.dir"), ConfigReader.getTestData("download_folder"), ConfigReader.getTestData("file_name")));

    @Test
    public void downloadSteamApp() {
        mainPage = new MainPage();
        welcomeSteamPage = new WelcomeSteamPage();
        LogUtils.info("Open Main Page");
        Assert.assertTrue(mainPage.isMainPageDisplayed(), "The Main page is not opened.");
        LogUtils.info("Click install button");
        mainPage.clickInstallButton();
        LogUtils.info("Check 'Welcome Steam Page'");
        Assert.assertTrue(welcomeSteamPage.isWelcomeSteamPageDisplayed(), "The Welcome Steam page is not opened.");
        LogUtils.info("Click download steam");
        welcomeSteamPage.clickInstallButton(filePath);
        LogUtils.info("Check exist steam file");
        Assert.assertTrue(FileUtils.isExistFile(filePath.toString()), "The steam app setup file isn't downloaded.");
    }
}
