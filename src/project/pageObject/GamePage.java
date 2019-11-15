package project.pageObject;

import framework.elements.Button;
import org.openqa.selenium.By;

public class GamePage {
    private By discount = By.xpath("//div[@class='discount_block game_purchase_discount']//div[@class='discount_pct']");
    private By discountPrice = By.xpath("//div[@class='discount_block game_purchase_discount']//div[@class='discount_prices']//div[@class='discount_original_price']");
    private By initial = By.xpath("//div[@class='discount_block game_purchase_discount']//div[@class='discount_prices']//div[@class='discount_final_price']");
    private Button discountRateButton = new Button(discount);
    private Button discountPriceButton = new Button(discountPrice);
    private Button initialButton = new Button(initial);

    private int discountRate;
    private String price;
    private String basePrice;

    private void getRate() {
        discountRate = Integer.parseInt(discountRateButton.getText().substring(1, discountRateButton.getText().length() - 1));
        price = discountPriceButton.getText().substring(1, discountPriceButton.getText().length() - 1);
        basePrice = initialButton.getText().substring(1, initialButton.getText().length() - 1);


    }
}
