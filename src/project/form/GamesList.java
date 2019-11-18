package project.form;

import framework.elements.Button;
import framework.utils.LogUtils;
import framework.utils.MaxDiscountGame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.models.Games;

import java.util.ArrayList;

public class GamesList {
    private static final String STRING_FORMAT_NAME_OF_GAME = "(%s)[%d]//ancestor::a//div[@class='tab_item_name']";
    private static final String STRING_FORMAT_ELEMENT_OF_GAMES = "%s[%d]";
    private static final String STRING_FORMAT_TOPSELLERS_LOCATOR = "(%s%s";
    private static final int ONE = 1;

    private String listDiscountGamesLocator = "//div[@id='tab_content_TopSellers']//div[contains(@class,'discount_block tab_item_discount') and not(contains(@class,'no_discount'))]";
    private String discountRateLocator = String.format(STRING_FORMAT_TOPSELLERS_LOCATOR,listDiscountGamesLocator,"//div[@class='discount_pct'])");
    private String discountPrices = String.format(STRING_FORMAT_TOPSELLERS_LOCATOR,listDiscountGamesLocator,"//div[@class='discount_prices']//div[@class='discount_final_price'])");
    private String initialPrice = String.format(STRING_FORMAT_TOPSELLERS_LOCATOR,listDiscountGamesLocator,"//div[@class='discount_prices']//div[@class='discount_original_price'])");

    private By listDiscountGames = By.xpath(listDiscountGamesLocator);

    private SortMenu sortMenu = new SortMenu();
    private ArrayList<Games> gamesArrayList = new ArrayList<>();

    public SortMenu getSortMenu() {
        return sortMenu;
    }

    public ArrayList<WebElement> getDiscountGames(By locator) {
        Button button = new Button(locator,"DiscountGames button");
        LogUtils.info(String.format("Find elements %s.",button.getNameOfElement()));
        return button.findElements();
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
        LogUtils.info("Get info about games with discount.");
        getGamesWithDiscount();
        LogUtils.info("Recording information about the selected game");
        setInfoDiscountGame(getMinimal());
        LogUtils.info(String.format("Click %s.",getElementOfGames(discountRateLocator, getMaximize()).getNameOfElement()));
        getElementOfGames(discountRateLocator, getMinimal()).click();
    }

    public void clickMax() {
        LogUtils.info("Get info about games with discount.");
        getGamesWithDiscount();
        LogUtils.info("Recording information about the selected game");
        setInfoDiscountGame(getMaximize());
        LogUtils.info(String.format("Click %s.",getElementOfGames(discountRateLocator, getMaximize()).getNameOfElement()));
        getElementOfGames(discountRateLocator, getMaximize()).click();
    }

    private Button getElementOfGames(String locator, int index) {
        return new Button(By.xpath(String.format(STRING_FORMAT_ELEMENT_OF_GAMES, locator, index)),"Element of games");
    }

    private Button getNameOfGameWithHighestDiscount(int index) {
        return new Button(By.xpath(String.format(STRING_FORMAT_NAME_OF_GAME,listDiscountGamesLocator, index)),"Name game with highest discount");
    }

    private void getGamesWithDiscount() {
        int index = 1;
        for (WebElement element : getDiscountGames(listDiscountGames)) {
            Games games = new Games();
            games.setDiscountedPrices(getElementOfGames(discountPrices, index).getText());
            games.setDiscountRate(parseToInt(getElementOfGames(discountRateLocator, index).getText()));
            games.setInitial(getElementOfGames(initialPrice, index).getText());
            games.setName(getNameOfGameWithHighestDiscount(index).getText());
            gamesArrayList.add(games);
            index++;
        }
    }

    private int parseToInt(String price) {
        return Integer.parseInt(price.substring(ONE, price.length() - ONE));
    }

    private void setInfoDiscountGame(int index) {
        Games games = gamesArrayList.get(index - ONE);
        MaxDiscountGame.setDiscountedPrices(games.getDiscountedPrices());
        MaxDiscountGame.setDiscountRate(games.getDiscountRate());
        MaxDiscountGame.setInitial(games.getInitial());
        MaxDiscountGame.setName(games.getName());
    }

}
