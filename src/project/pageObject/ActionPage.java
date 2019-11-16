package project.pageObject;

import framework.elements.Block;
import framework.elements.Button;
import framework.utils.GetDictionary;
import framework.utils.MaxDiscountGame;
import framework.utils.XmlReader;
import framework.waits.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.form.GamesList;
import project.models.Games;

import java.util.ArrayList;

public class ActionPage {

    private By checkActionPage = By.xpath("//h2[@class='pageheader']");
    private By topSelling = By.xpath("//div[@id='tab_select_TopSellers']//div[@class='tab_content']");
    private By topSellingActive = By.xpath("//div[@id='tab_select_TopSellers' and contains(@class,'tab  tab_filler active')]");
    private By listDiscountGames = By.xpath("//div[@id='tab_content_TopSellers']//div[@class='discount_block tab_item_discount']");
    private String discountRatelocator = "(//div[@id='tab_content_TopSellers']//div[@class='discount_block tab_item_discount']//div[@class='discount_pct'])";
    private String discountPrices = "(//div[@id='tab_content_TopSellers']//div[@class='discount_block tab_item_discount']//div[@class='discount_prices']//div[@class='discount_final_price'])";
    private String initialPrice = "(//div[@id='tab_content_TopSellers']//div[@class='discount_block tab_item_discount']//div[@class='discount_prices']//div[@class='discount_original_price'])";
    private final String STRING_FORMAT_NAME_OF_GAME = "(//div[@id='tab_content_TopSellers']//div[@class='discount_block tab_item_discount']//div[@class='discount_pct'])[%d]//ancestor::a//div[@class='tab_item_name']";
    private final String STRING_FORMAT_ELEMENT_OF_GAMES = "%s[%d]";
    private Block lable = new Block(checkActionPage);
    private Button menuButton = new Button(topSellingActive);


    private GamesList gamesList = new GamesList();
    private ArrayList<Games> gamesArrayList = new ArrayList<>();

    public boolean checkActionPage() {
        return lable.getText().contains(XmlReader.readXml(GetDictionary.getDictionary(), "actions"));
    }

    public boolean checkIndiPage() {
        return lable.getText().contains(XmlReader.readXml(GetDictionary.getDictionary(), "indi"));
    }

    public void clickTopSelling() {
        Waiter.waitVisibilityOfElementLocated(topSelling);
        gamesList.getSortMenu().clickMenuItem(topSelling);
    }

    public boolean checkTopSelling() {
        Waiter.waitVisibilityOfElementLocated(topSellingActive);
        return menuButton.isDisplayed();
    }

    private Button getElementOfGames(String locator, int index) {
        return new Button(By.xpath(String.format(STRING_FORMAT_ELEMENT_OF_GAMES, locator, index)));
    }

    private Button getNameOfGameWithHighestDiscount(int index) {
        return new Button(By.xpath(String.format(STRING_FORMAT_NAME_OF_GAME, index)));
    }

    public void getGamesWithDiscount() {
        int index = 1;
        for (WebElement element : gamesList.getDiscountGames(listDiscountGames)) {
            Games games = new Games();
            games.setDiscountedPrices(getElementOfGames(discountPrices, index).getText());
            games.setDiscountRate(parseToInt(getElementOfGames(discountRatelocator, index).getText()));
            games.setInitial(getElementOfGames(initialPrice, index).getText());
            games.setName(getNameOfGameWithHighestDiscount(index).getText());
            gamesArrayList.add(games);
            index++;
        }
    }

    private int getMinimal() {
        int min = 100;
        int index = 0;
        int count = 1;
        for (Games element : gamesArrayList) {
            if (element.getDiscountRate() < min) {
                min = element.getDiscountRate();
                index = count;
            }
            count++;
        }
        return index;
    }

    private int getMaximize() {
        int max = 0;
        int index = 0;
        int count = 1;
        for (Games element : gamesArrayList) {
            if (element.getDiscountRate() > max) {
                max = element.getDiscountRate();
                index = count;
            }
            count++;
        }
        return index;
    }

    public void clickMin() {
        setInfoMaxDiscountGame(getMinimal());
        getElementOfGames(discountRatelocator, getMinimal()).clickButton();
    }

    public void clickMax() {
        setInfoMaxDiscountGame(getMaximize());
        getElementOfGames(discountRatelocator, getMaximize()).clickButton();
    }


    private int parseToInt(String price) {
        return Integer.parseInt(price.substring(1, price.length() - 1));
    }

    private void setInfoMaxDiscountGame(int index) {
        Games games = new Games();
        games = gamesArrayList.get(index - 1);
        MaxDiscountGame.setDiscountedPrices(games.getDiscountedPrices());
        MaxDiscountGame.setDiscountRate(games.getDiscountRate());
        MaxDiscountGame.setInitial(games.getInitial());
        MaxDiscountGame.setName(games.getName());
    }


}
