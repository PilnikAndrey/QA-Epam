package project.pageObject;

import framework.elements.Block;
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

    private Block label = new Block(checkCategoryPage, "NameOfCategory block");
    private Button menuButton = new Button(topSellingActive, "TopSellers button");

    private GamesList gamesList = new GamesList();

    public boolean checkActionPage() {
        LogUtils.getLog().info("Check Action page.");
        return label.getText().contains(XmlReader.readXml(GetDictionary.getDictionary(), "actions"));
    }

    public boolean checkIndiPage() {
        LogUtils.getLog().info("Check Indie page.");
        return label.getText().contains(XmlReader.readXml(GetDictionary.getDictionary(), "indi"));
    }

    public void clickTopSelling() {
        Waiter.waitVisibilityOfElementLocated(topSelling);
        LogUtils.getLog().info("Click Top Selling");
        gamesList.getSortMenu().clickMenuItem(topSelling);
    }

    public boolean checkTopSelling() {
        Waiter.waitVisibilityOfElementLocated(topSellingActive);
        LogUtils.getLog().info(String.format("Check %s is displayed.",menuButton.getNameOfElement()));
        return menuButton.isDisplayed();
    }

    public void clickMin() {
        LogUtils.getLog().info("Click game with minimal discount");
        gamesList.clickMin();
    }

    public void clickMax() {
        LogUtils.getLog().info("Click game with maximize discount");
        gamesList.clickMax();
    }


}
