package project.pageObject;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class FreeCategory {
    private Label freeCategory = new Label(By.xpath("//*[text()='Free To Play Games on Steam']"),"freeCategory");
    private Button firstGame = new Button(By.xpath("//div[@id='NewReleasesRows']//a[1]"),"firstGame");

    public boolean isFreeCategory() {
        return freeCategory.isDisplayed();
    }

    public void clickFirstGame() {
        firstGame.click();
    }
}
