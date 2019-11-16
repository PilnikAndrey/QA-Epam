package project.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.pageObject.ActionPage;
import project.pageObject.AgeGatePage;
import project.pageObject.GamePage;
import project.pageObject.MainPage;

public class LowestDiscount extends Base{

    private MainPage mainPage;
    private ActionPage actionPage;
    private AgeGatePage ageGatePage;
    private GamePage gamePage;

    @Test
    public void checkLowestDiscount() throws InterruptedException {
        mainPage = new MainPage();
        Assert.assertTrue(mainPage.checkMainPage(), "Main page didn't open");
        mainPage.chooseIndiCategory();
        Thread.sleep(3000);
        actionPage = new ActionPage();
        Assert.assertTrue(actionPage.checkIndiPage(), "Actions category didn't open");
        actionPage.clickTopSelling();
        Assert.assertTrue(actionPage.checkTopSelling(), "Top Selling didn't open");
        Thread.sleep(3000);
        actionPage.getGamesWithDiscount();
        actionPage.clickMin();
        Thread.sleep(3000);
        ageGatePage = new AgeGatePage();
        ageGatePage.check();
        gamePage = new GamePage();
        Thread.sleep(2000);
        Assert.assertTrue(gamePage.equalsName(), "errr");
        Assert.assertTrue(gamePage.equalsDiscountInitial(), "errr");
        Assert.assertTrue(gamePage.equalsDiscountPrice(), "errr");
        Assert.assertTrue(gamePage.equalsDiscountRate(), "errr");
    }
}
