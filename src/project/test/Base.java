package project.test;

import framework.browser.Browser;
import framework.utils.ConfigReader;
import framework.utils.LogUtils;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;


public class Base {


    @BeforeClass
    public void getUrl() {
        LogUtils.info("Go to" + ConfigReader.getProperty("url"));
        Browser.getUrl(ConfigReader.getProperty("url"));
    }

    @BeforeSuite
    public void setup() {
        PropertyConfigurator.configure(ConfigReader.getProperty("log_config"));
        LogUtils.info("Set implicitly Wait");
        Browser.setImplicitlyWait();
        LogUtils.info("Maximize window");
        Browser.maximizeWindow();
    }

    @AfterSuite
    public void closeBrowser() {
        LogUtils.info("Close browser");
        Browser.getDriver().close();
    }

}
