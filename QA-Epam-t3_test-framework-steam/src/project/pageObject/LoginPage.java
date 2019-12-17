package project.pageObject;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class LoginPage {

    private Label signIn = new Label(By.xpath("//h2[contains(text(),'Sign in')]"),"signIn");
    private Button login = new Button(By.xpath("//input[@id='input_username']"),"loginButton");
    private Button password = new Button(By.xpath("//input[@id='input_password']"),"passwordButton");
    private Button submit = new Button(By.xpath("//button[contains(@class,'btn_medium')]"),"submitButton");

    public boolean checkLoginPage() {
        return submit.isDisplayed();
    }

    public void fillInTheFields() {
        login.sendKeys("andryxa1111");
        password.sendKeys("supermacho1337");
        submit.click();
    }
}
