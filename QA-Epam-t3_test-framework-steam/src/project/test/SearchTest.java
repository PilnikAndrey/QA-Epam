package project.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.pageObject.GamePage;
import project.pageObject.MainPage;

public class SearchTest extends Base {

    @Test
    public void searchTest() {
        MainPage mainPage = new MainPage();
        mainPage.searchGta();
        mainPage.clickGta();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isGtaGame(),"It is not gta");
    }
}
