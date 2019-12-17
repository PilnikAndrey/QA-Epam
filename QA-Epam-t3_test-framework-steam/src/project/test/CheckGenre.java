package project.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.pageObject.GamePage;
import project.pageObject.MainPage;

public class CheckGenre extends Base {

    @Test
    public void checkGenre() {
        MainPage mainPage = new MainPage();
        mainPage.searchGta();
        mainPage.clickGta();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isGtaGame(),"It is not a GTA page");
        Assert.assertTrue(gamePage.isActionGenre(),"This game is not a action");
    }
}
