package project.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.pageObject.MainPage;
import project.pageObject.SteamCuratorsPage;

public class SteamCurator extends Base {

    @Test
    public void steamCurator() {
        MainPage mainPage = new MainPage();
        mainPage.clickSteamCurator();
        SteamCuratorsPage steamCurator = new SteamCuratorsPage();
        Assert.assertTrue(steamCurator.isCuratorsPage());
        steamCurator.clickFollow();
        Assert.assertTrue(steamCurator.isLoginPlease());
    }
}
