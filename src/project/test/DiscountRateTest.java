package project.test;

import framework.utils.GetDictionary;
import framework.utils.LogUtils;
import framework.utils.XmlReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.models.Games;
import project.pageObject.CategoryPage;
import project.pageObject.AgeGatePage;
import project.pageObject.GamePage;
import project.pageObject.MainPage;
import project.test.dataProvider.TestProvider;

public class DiscountRateTest extends Base {

    private MainPage mainPage;
    private CategoryPage categoryPage;
    private AgeGatePage ageGatePage;
    private GamePage gamePage;
    private Games games;

    @Test(dataProvider = "dataProviderForSteamTest", dataProviderClass = TestProvider.class)
    public void discountRateTest(String category, String rate) {
        mainPage = new MainPage();
        mainPage.navigateToMainPage();
        LogUtils.info("Open Main Page");
        Assert.assertTrue(mainPage.isMainPageDisplayed(), "The Main page is not opened.");
        LogUtils.info("Choose Action Category");
        mainPage.chooseCategory(XmlReader.readXml(GetDictionary.getDictionary(), "menu"),XmlReader.readXml(GetDictionary.getDictionary(), category));
        categoryPage = new CategoryPage();
        LogUtils.info("Check 'Browsing Action' page");
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed(category), "'Browsing Action' page is not opened.");
        LogUtils.info("Click Top Selling");
        categoryPage.clickTopSelling();
        LogUtils.info("Check Top Selling category");
        Assert.assertTrue(categoryPage.isTopSellingMenuDisplayed(), "'Top Selling' tab is not opened.");
        LogUtils.info("Click on the game with the maximum discount");
        games = new Games();
        categoryPage.clickGameWithChosenDiscountRate(games, rate);
        ageGatePage = new AgeGatePage();
        LogUtils.info("Check Age Gate page");
        ageGatePage.checkAgeGatePage();
        gamePage = new GamePage();
        LogUtils.info("Check selected game page" + games.getName());
        Assert.assertTrue(gamePage.isEqualsName(games), "Selected game page is not opened.");
        LogUtils.info("Check equal initial price");
        Assert.assertTrue(gamePage.isEqualsDiscountInitial(games), "Initial prices don't match.");
        LogUtils.info("Check equal discount price");
        Assert.assertTrue(gamePage.isEqualsDiscountPrice(games), "Discount prices don't match.");
        LogUtils.info("Check equal discount rate");
        Assert.assertTrue(gamePage.isEqualsDiscountRate(games), "Discount rates don't match.");
    }
}

