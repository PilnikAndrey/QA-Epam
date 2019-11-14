package project.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.pageObject.MainPage;

public class HighestDiscount extends Base {

    private MainPage mainPage;

    @Test
    public void checkHighestDiscount() throws InterruptedException {
        mainPage = new MainPage();
        Assert.assertTrue(mainPage.checkMainPage(), "Main page didn't open");
        mainPage.chooseActionCategory();
        Thread.sleep(3000);
    }
}
