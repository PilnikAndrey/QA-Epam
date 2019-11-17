package project.pageObject;

import framework.elements.Button;
import framework.utils.LogUtils;
import framework.utils.MaxDiscountGame;
import org.openqa.selenium.By;

public class GamePage {

    private static final String STRING_FORMAT_DISCOUNT = "//div[contains(@class,'discount_block game_purchase_discount')]%s";
    private static final int ONE = 1;
    private By discount = By.xpath(String.format(STRING_FORMAT_DISCOUNT, "//div[contains(@class,'discount_pct')]"));
    private By discountPrice = By.xpath(String.format(STRING_FORMAT_DISCOUNT, "//div[@class='discount_prices']//div[@class='discount_final_price']"));
    private By initial = By.xpath(String.format(STRING_FORMAT_DISCOUNT, "//div[@class='discount_prices']//div[@class='discount_original_price']"));
    private By nameOfCollectionsGame = By.xpath("//h2[@class='pageheader']");
    private By nameOfGame = By.xpath("//div[@class='apphub_AppName']");

    private Button collectionsGameButton = new Button(nameOfCollectionsGame, "NameOfCollectionsGame button");
    private Button gameButton = new Button(nameOfGame, "NameOfGame button");
    private Button discountRateButton = new Button(discount, "DiscountRate button");
    private Button discountPriceButton = new Button(discountPrice, "DiscountPrice button");
    private Button initialButton = new Button(initial, "InitialPrice button");

    public boolean equalsDiscountPrice() {
        LogUtils.getLog().info("Compare discount prices.");
        return discountPriceButton.getText().contains(MaxDiscountGame.getDiscountedPrices());
    }

    public boolean equalsDiscountInitial() {
        LogUtils.getLog().info("Compare discount initial.");
        return MaxDiscountGame.getInitial().contains(initialButton.getText());
    }

    public boolean equalsName() {
        LogUtils.getLog().info("Check for collection or game.");
        if (collectionsGameButton.isDisplayed()) {
            LogUtils.getLog().info("Compare collections name.");
            return collectionsGameButton.getText().toUpperCase().equals(MaxDiscountGame.getName().toUpperCase());
        } else if (gameButton.isDisplayed()) {
            LogUtils.getLog().info("Compare game name.");
            return gameButton.getText().toUpperCase().equals(MaxDiscountGame.getName().toUpperCase());
        } else {
            return false;
        }
    }

    public boolean equalsDiscountRate() {
        LogUtils.getLog().info("Compare discount rates.");
        return Integer.parseInt(discountRateButton.getText().substring(ONE, discountRateButton.getText().length() - ONE)) == MaxDiscountGame.getDiscountRate();
    }

}
