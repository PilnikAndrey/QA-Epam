package project.test;

import framework.utils.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.pageObject.CategoryPage;
import project.pageObject.AgeGatePage;
import project.pageObject.GamePage;
import project.pageObject.MainPage;

public class LowestDiscount extends Base {

    private MainPage mainPage;
    private CategoryPage categoryPage;
    private AgeGatePage ageGatePage;
    private GamePage gamePage;

    @Test
    public void checkLowestDiscount() {
        mainPage = new MainPage();
        LogUtils.info("Open Main Page");
        Assert.assertTrue(mainPage.isCheckMainPage(), "The Main page is not opened.");
        LogUtils.info("Choose Indie Category");
        mainPage.chooseIndieCategory();
        categoryPage = new CategoryPage();
        LogUtils.info("Check 'Browsing Indie' page");
        Assert.assertTrue(categoryPage.isCheckIndiPage(), "'Browsing Indie' page is not opened.");
        LogUtils.info("Click Top Selling");
        categoryPage.clickTopSelling();
        LogUtils.info("Check Top Selling category");
        Assert.assertTrue(categoryPage.isCheckTopSelling(), "'Top Selling' tab is not opened.");
        LogUtils.info("Click on the game with the minimum discount");
        categoryPage.clickMin();
        ageGatePage = new AgeGatePage();
        LogUtils.info("Check Age Gate page");
        ageGatePage.check();
        gamePage = new GamePage();
        LogUtils.info("Check selected game page");
        Assert.assertTrue(gamePage.isEqualsName(), "Selected game page is not opened.");
        LogUtils.info("Check equal initial price");
        Assert.assertTrue(gamePage.isEqualsDiscountInitial(), "Initial prices don't match.");
        LogUtils.info("Check equal discount price");
        Assert.assertTrue(gamePage.isEqualsDiscountPrice(), "Discount prices don't match.");
        LogUtils.info("Check equal discount rate");
        Assert.assertTrue(gamePage.isEqualsDiscountRate(), "Discount rates don't match.");
    }
}
