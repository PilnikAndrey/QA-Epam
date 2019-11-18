package project.pageObject;

import framework.elements.Button;
import framework.utils.LogUtils;
import framework.utils.MaxDiscountGame;
import org.openqa.selenium.By;

public class GamePage {

    private static final String STRING_FORMAT_DISCOUNT = "//div[contains(@class,'discount_block game_purchase_discount')]%s";
    private static final int ONE = 1;

    private Button collectionsGameButton = new Button(By.xpath("//h2[@class='pageheader']"), "NameOfCollectionsGame button");
    private Button gameButton = new Button(By.xpath("//div[@class='apphub_AppName']"), "NameOfGame button");
    private Button discountRateButton = new Button(By.xpath(String.format(STRING_FORMAT_DISCOUNT, "//div[contains(@class,'discount_pct')]")), "DiscountRate button");
    private Button discountPriceButton = new Button(By.xpath(String.format(STRING_FORMAT_DISCOUNT, "//div[@class='discount_prices']//div[@class='discount_final_price']")), "DiscountPrice button");
    private Button initialButton = new Button(By.xpath(String.format(STRING_FORMAT_DISCOUNT, "//div[@class='discount_prices']//div[@class='discount_original_price']")), "InitialPrice button");

    public boolean isEqualsDiscountPrice() {
        LogUtils.info("Compare discount prices.");
        return discountPriceButton.getText().contains(MaxDiscountGame.getDiscountedPrices());
    }

    public boolean isEqualsDiscountInitial() {
        LogUtils.info("Compare discount initial.");
        return MaxDiscountGame.getInitial().contains(initialButton.getText());
    }

    public boolean isEqualsName() {
        LogUtils.info("Check for collection or game.");
        if (collectionsGameButton.isDisplayed()) {
            LogUtils.info("Compare collections name.");
            return collectionsGameButton.getText().toUpperCase().equals(MaxDiscountGame.getName().toUpperCase());
        } else if (gameButton.isDisplayed()) {
            LogUtils.info("Compare game name.");
            return gameButton.getText().toUpperCase().equals(MaxDiscountGame.getName().toUpperCase());
        } else {
            return false;
        }
    }

    public boolean isEqualsDiscountRate() {
        LogUtils.info("Compare discount rates.");
        return Integer.parseInt(discountRateButton.getText().substring(ONE, discountRateButton.getText().length() - ONE)) == MaxDiscountGame.getDiscountRate();
    }

}
