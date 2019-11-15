package project.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.pageObject.ActionPage;
import project.pageObject.AgeGatePage;
import project.pageObject.GamePage;
import project.pageObject.MainPage;

public class HighestDiscount extends Base {

    private MainPage mainPage;
    private ActionPage actionPage;
    private AgeGatePage ageGatePage;
    private GamePage gamePage;

    @Test
    public void checkHighestDiscount() throws InterruptedException {
        mainPage = new MainPage();
        Assert.assertTrue(mainPage.checkMainPage(), "Main page didn't open");
        mainPage.chooseActionCategory();
        Thread.sleep(3000);
        actionPage = new ActionPage();
        Assert.assertTrue(actionPage.checkActionPage(),"Actions category didn't open");
        actionPage.clickTopSelling();
        Assert.assertTrue(actionPage.checkTopSelling(),"Top Selling didn't open");
        Thread.sleep(3000);
        actionPage.getGamesWithDiscount();
        actionPage.clickMax();
        Thread.sleep(3000);
        ageGatePage = new AgeGatePage();
        ageGatePage.check();
        gamePage = new GamePage();

        Thread.sleep(3000);
    }
}
