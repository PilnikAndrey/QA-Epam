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
        LogUtils.getLog().info("Open Main Page");
        Assert.assertTrue(mainPage.checkMainPage(), "The Main page is not opened.");
        LogUtils.getLog().info("Choose Indie Category");
        mainPage.chooseIndieCategory();
        categoryPage = new CategoryPage();
        LogUtils.getLog().info("Check 'Browsing Indie' page");
        Assert.assertTrue(categoryPage.checkIndiPage(), "'Browsing Indie' page is not opened.");
        LogUtils.getLog().info("Click Top Selling");
        categoryPage.clickTopSelling();
        LogUtils.getLog().info("Check Top Selling category");
        Assert.assertTrue(categoryPage.checkTopSelling(), "'Top Selling' tab is not opened.");
        LogUtils.getLog().info("Click on the game with the minimum discount");
        categoryPage.clickMin();
        ageGatePage = new AgeGatePage();
        LogUtils.getLog().info("Check Age Gate page");
        ageGatePage.check();
        gamePage = new GamePage();
        LogUtils.getLog().info("Check selected game page");
        Assert.assertTrue(gamePage.equalsName(), "Selected game page is not opened.");
        LogUtils.getLog().info("Check equal initial price");
        Assert.assertTrue(gamePage.equalsDiscountInitial(), "Initial prices don't match.");
        LogUtils.getLog().info("Check equal discount price");
        Assert.assertTrue(gamePage.equalsDiscountPrice(), "Discount prices don't match.");
        LogUtils.getLog().info("Check equal discount rate");
        Assert.assertTrue(gamePage.equalsDiscountRate(), "Discount rates don't match.");
    }
}
