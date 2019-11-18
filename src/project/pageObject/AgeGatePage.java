package project.pageObject;

import framework.elements.Label;
import framework.elements.Button;
import framework.elements.DropList;
import framework.utils.LogUtils;
import org.openqa.selenium.By;

public class AgeGatePage {
    private By ageGate = By.xpath("//div[@class='agegate_birthday_selector']");
    private By setAgeLocator = By.xpath("//option[@value='1999']");
    private By viewPageLocator = By.xpath("//a[@onclick='ViewProductPage()']");
    private Label ageGateButton = new Label(ageGate, "Div block on the AgeGate page.");
    private DropList yearList = new DropList(setAgeLocator, "DropList of year");
    private Button viewPageButton = new Button(viewPageLocator, "Button 'Open Page'");

    private boolean isCheckAgeGate() {
        LogUtils.info(String.format("Check %s is displayed.",ageGateButton.getNameOfElement()));
        return ageGateButton.isDisplayed();
    }

    public void check() {
        if (isCheckAgeGate()) {
            LogUtils.info(String.format("Click %s.",yearList.getNameOfElement()));
            yearList.click();
            LogUtils.info(String.format("Click %s.",viewPageButton.getNameOfElement()));
            viewPageButton.click();
        }
    }
}
