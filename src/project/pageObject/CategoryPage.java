package project.pageObject;

import framework.elements.Label;
import framework.elements.Button;
import framework.utils.GetDictionary;
import framework.utils.LogUtils;
import framework.utils.XmlReader;
import framework.waits.Waiter;
import org.openqa.selenium.By;
import project.form.GamesList;


public class CategoryPage {

    private By checkCategoryPage = By.xpath("//h2[@class='pageheader']");
    private By topSelling = By.xpath("//div[@id='tab_select_TopSellers']//div[@class='tab_content']");
    private By topSellingActive = By.xpath("//div[@id='tab_select_TopSellers' and contains(@class,'tab  tab_filler active')]");

    private Label nameOfCategoryLabel = new Label(By.xpath("//h2[@class='pageheader']"), "NameOfCategory");
    private Button menuButton = new Button(By.xpath("//div[@id='tab_select_TopSellers' and contains(@class,'tab  tab_filler active')]"), "TopSellers button");

    private GamesList gamesList = new GamesList();

    public boolean isCheckActionPage() {
        LogUtils.info("Check Action page.");
        return nameOfCategoryLabel.getText().contains(XmlReader.readXml(GetDictionary.getDictionary(), "actions"));
    }

    public boolean isCheckIndiPage() {
        LogUtils.info("Check Indie page.");
        return nameOfCategoryLabel.getText().contains(XmlReader.readXml(GetDictionary.getDictionary(), "indi"));
    }

    public void clickTopSelling() {
        Waiter.waitVisibilityOfElementLocated(topSelling);
        LogUtils.info("Click Top Selling");
        gamesList.getSortMenu().clickMenuItem(topSelling);
    }

    public boolean isCheckTopSelling() {
        Waiter.waitVisibilityOfElementLocated(topSellingActive);
        LogUtils.info(String.format("Check %s is displayed.",menuButton.getNameOfElement()));
        return menuButton.isDisplayed();
    }

    public void clickMin() {
        LogUtils.info("Click game with minimal discount");
        gamesList.clickMin();
    }

    public void clickMax() {
        LogUtils.info("Click game with maximize discount");
        gamesList.clickMax();
    }


}
