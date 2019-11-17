package project.test;

import framework.utils.ExistFile;
import framework.utils.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.pageObject.MainPage;
import project.pageObject.WelcomeSteamPage;

public class SteamDownload extends Base {

    private MainPage mainPage;
    private WelcomeSteamPage welcomeSteamPage;

    @Test
    public void downloadSteamApp() {
        mainPage = new MainPage();
        welcomeSteamPage = new WelcomeSteamPage();
        LogUtils.getLog().info("Open Main Page");
        Assert.assertTrue(mainPage.checkMainPage(), "The Main page is not opened.");
        LogUtils.getLog().info("Click install button");
        mainPage.clickInstallButton();
        LogUtils.getLog().info("Check 'Welcome Steam Page'");
        Assert.assertTrue(welcomeSteamPage.checkWelcomeSteamPage(), "The Welcome Steam page is not opened.");
        LogUtils.getLog().info("Click download steam");
        welcomeSteamPage.clickInstallButton();
        LogUtils.getLog().info("Check exist steam file");
        Assert.assertTrue(ExistFile.checkExistFile(), "The steam app setup file isn't downloaded.");
    }
}
