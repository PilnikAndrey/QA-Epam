package project.pageObject;

import framework.elements.Button;
import org.openqa.selenium.By;

public class AgeGatePage {
    private By ageGate = By.xpath("//div[@class='agegate_birthday_selector']");
    private By setAgeLocator = By.xpath("//option[@value='1999']");
    private By viewPageLocator = By.xpath("//a[@onclick='ViewProductPage()']");
    private Button ageGateButton = new Button(ageGate);
    private Button ageList = new Button(setAgeLocator);
    private Button viewPageButton = new Button(viewPageLocator);

    private boolean checkAgeGate() {
        try {
            if (ageGateButton.isDisplayed()) {
                return true;
            }
        }
        catch (Exception e) {
            System.out.println("Element don't exist");
            return false;
        }
        return false;
    }

    public void check() {
        if (checkAgeGate()) {
            ageList.clickButton();
            viewPageButton.clickButton();
        }
    }
}
