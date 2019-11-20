package project.pageObject;

import framework.elements.Label;
import framework.elements.Button;
import framework.elements.DropList;
import framework.utils.ConfigReader;
import framework.utils.LogUtils;
import org.openqa.selenium.By;

public class AgeGatePage {

    private Label ageGateButton = new Label(By.xpath("//div[@class='agegate_birthday_selector']"), "Div block on the AgeGate page.");
    private DropList yearList = new DropList(By.xpath("//*[@id='ageYear']"), "DropList of year");
    private Button viewPageButton = new Button(By.xpath("//a[@onclick='ViewProductPage()']"), "Button 'Open Page'");

    private boolean isAgeGatePageDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.",ageGateButton.getNameOfElement()));
        return ageGateButton.isDisplayed();
    }

    public void checkAgeGatePage() {
        if (isAgeGatePageDisplayed()) {
            LogUtils.info(String.format("Click %s.",yearList.getNameOfElement()));
            yearList.click();
            yearList.selectFromList(ConfigReader.getTestData("year"));
            LogUtils.info(String.format("Click %s.",viewPageButton.getNameOfElement()));
            viewPageButton.click();
        }
    }
}
