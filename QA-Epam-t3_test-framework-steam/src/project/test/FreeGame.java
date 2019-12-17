package project.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.pageObject.FreeCategory;
import project.pageObject.GamePage;
import project.pageObject.MainPage;

public class FreeGame extends Base {

    @Test
    public void checkFreeGame() {
        MainPage mainPage = new MainPage();
        mainPage.clickFreeCategory();
        FreeCategory freeCategory = new FreeCategory();
        freeCategory.isFreeCategory();
        freeCategory.clickFirstGame();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isFreeGame(),"Game is not a free");
    }
}
