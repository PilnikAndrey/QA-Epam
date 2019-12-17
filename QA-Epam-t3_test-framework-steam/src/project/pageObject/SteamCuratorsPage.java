package project.pageObject;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class SteamCuratorsPage {

    private Button follow = new Button(By.xpath("(//a[contains(@class,' follow_button btn_green_white_innerfade btn_medium ')])[1]"),"follow");
    private Label curatorsPage = new Label(By.xpath("//h2[@class='pageheader'][text()='Steam Curators']"),"curatorsPage");
    private Label login = new Label(By.xpath("//div[contains(text(),'You must be logged in to follow a curator')]"),"login");

    public boolean isCuratorsPage() {
        return curatorsPage.isDisplayed();
    }

    public void clickFollow() {
        follow.click();
    }

    public boolean isLoginPlease() {
        return login.isDisplayed();
    }
}
