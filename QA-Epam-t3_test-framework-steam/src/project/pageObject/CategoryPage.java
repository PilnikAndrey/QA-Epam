package project.pageObject;

import framework.elements.Label;
import framework.elements.Button;
import framework.utils.GetDictionary;
import framework.utils.LogUtils;
import framework.utils.XmlReader;
import org.openqa.selenium.By;
import project.form.GamesList;
import project.models.Games;


public class CategoryPage {

    private Label nameOfCategoryLabel = new Label(By.xpath("//h2[@class='pageheader']"), "NameOfCategory");
    private Button menuButton = new Button(By.xpath("//div[@id='tab_select_TopSellers' and contains(@class,'tab  tab_filler active')]"), "TopSellers button");

    private GamesList gamesList = new GamesList();

    public boolean isCategoryPageDisplayed(String category) {
        LogUtils.info(String.format("Check %s page.", category));
        return nameOfCategoryLabel.getText().contains(XmlReader.readXml(GetDictionary.getDictionary(), category));
    }

    public void clickTopSelling() {
        LogUtils.info("Click Top Selling");
        gamesList.getSortMenu().clickMenuItem();
    }

    public boolean isTopSellingMenuDisplayed() {
        menuButton.waitVisibilityOfElement();
        LogUtils.info(String.format("Check %s is displayed.", menuButton.getNameOfElement()));
        return menuButton.isDisplayed();
    }

    public void clickGameWithChosenDiscountRate(Games game, String rate) {
        LogUtils.info("Click game with minimal discount");
        gamesList.clickGameWithChosenRate(game, rate);
    }

}
