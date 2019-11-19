package project.form;

import framework.elements.Button;
import framework.utils.LogUtils;
import org.openqa.selenium.By;

public class SortMenu {

    private Button menuButton = new Button(By.xpath("//div[@id='tab_select_TopSellers']//div[@class='tab_content']"), "TopSellers button");

    public void clickMenuItem() {
        LogUtils.info(String.format("Click %s .", menuButton.getNameOfElement()));
        menuButton.waitVisibilityOfElement();
        menuButton.click();
    }
}
