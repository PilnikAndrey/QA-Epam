package project.test;

import framework.browser.Browser;
import framework.utils.ConfigReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {

    @BeforeTest
    public void setup() {
        Browser.getUrl(ConfigReader.getProperty("url"));
        Browser.setImplicitlyWait(Integer.parseInt(ConfigReader.getProperty("implicitlyWait")));
        Browser.maximizeWindow();
    }

    @AfterTest
    public void closeBrowser() {
        Browser.getDriver().close();
    }

}
