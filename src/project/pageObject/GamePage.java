package project.pageObject;

import framework.elements.Button;
import framework.utils.MaxDiscountGame;
import org.openqa.selenium.By;
import project.test.Base;

public class GamePage {
    private By discount = By.xpath("//*[@class='discount_block game_purchase_discount']//*[@class='discount_pct']");
    private By discountPrice = By.xpath("//div[@class='discount_block game_purchase_discount']//div[@class='discount_prices']//div[@class='discount_final_price']");
    private By initial = By.xpath("//div[@class='discount_block game_purchase_discount']//div[@class='discount_prices']//div[@class='discount_original_price']");
    private By name = By.xpath("//h2[@class='pageheader']");
    private By name2 = By.xpath("//div[@class='apphub_AppName']");
    private Button nameButton = new Button(name);
    private Button nameButton2 = new Button(name2);

    private Button discountRateButton = new Button(discount);
    private Button discountPriceButton = new Button(discountPrice);
    private Button initialButton = new Button(initial);


    public boolean equalsDiscountPrice() {
        return discountPriceButton.getText().contains(MaxDiscountGame.getDiscountedPrices());
    }

    public boolean equalsDiscountInitial() {
        return MaxDiscountGame.getInitial().contains(initialButton.getText());
    }

    public boolean equalsName() {
        try {
            if (nameButton.isDisplayed()) {
                return nameButton.getText().toUpperCase().equals(MaxDiscountGame.getName().toUpperCase());
            }
        }
        catch (Exception e) {
            System.out.println("Element don't exist");

        }

        return nameButton2.getText().toUpperCase().equals(MaxDiscountGame.getName().toUpperCase());
    }

    public boolean equalsDiscountRate() {
        return Integer.parseInt(discountRateButton.getText().substring(1, discountRateButton.getText().length() - 1)) == MaxDiscountGame.getDiscountRate();
    }


}
