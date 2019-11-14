package project.test;

import framework.utils.ExistFile;
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
        Assert.assertTrue(mainPage.checkMainPage(), "Main page didn't open");
        mainPage.clickInstallButton();
        Assert.assertTrue(welcomeSteamPage.checkWelcomeSteamPage(), "Welcome Steam page didn't open");
        welcomeSteamPage.clickInstallButton();
        Assert.assertTrue(ExistFile.checkExistFile(), "File doesn't exist");
    }
}
