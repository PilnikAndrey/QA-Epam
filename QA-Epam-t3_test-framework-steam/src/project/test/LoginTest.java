package project.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.pageObject.LoginPage;
import project.pageObject.MainPage;

public class LoginTest extends Base {

    @Test
    public void loginTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.checkLoginPage(),"Login page is not opened.");
        loginPage.fillInTheFields();
        Thread.sleep(4000);
    }
}
