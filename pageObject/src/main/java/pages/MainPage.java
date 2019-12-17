package pages;

import browserFactory.BrowserFactory;
import driver.Driver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import utils.Waiter;

import java.util.List;

public class MainPage {
    private By city = By.xpath("//div[@class='IconBox IconBox--autocomplete']//div[@class='IconBox__wrapper']");//"//*[contains(@class,'IconBox IconBox--autocomplete')]"
    private By search = By.xpath("//button[contains(@class,'btn Searchbox__searchButton Searchbox__searchButton--active')]");
    private By inputCity = By.xpath("//ul[@class='AutocompleteList']//li[3]");
    private By setDate = By.xpath("//div[@class='SearchBoxTextDescription SearchBoxTextDescription--checkIn SearchBoxTextDescription--focused']");
    private By chooseStars = By.xpath("//div[@data-element-value='StarRating']");
    private By setStars = By.xpath("//div[contains(@class,'TopBarContainer')]//li[5]");
    private By listHotels = By.xpath("//*[@class='hotel-list-container']//*[@data-selenium='hotel-item']");
    private By getCount = By.xpath("//*[contains(@class,'SearchBoxTextDescription SearchBoxTextDescription--searchText')]//*[@class='SearchBoxTextDescription__desc']");
    private By chooseDate = By.xpath("//div[contains(@class,'IconBox IconBox--checkIn')]//div[contains(@class,'IconBox__child')]");
    private By chooseYesterday = By.xpath("//div[contains(@class,'DayPicker-wrapper')]//div[1]//div[3]//div[3]//div[3]");
    private By yesterday = By.xpath("//div[contains(@class,'DayPicker-Day DayPicker-Day--disabled DayPicker-Day--selected DayPicker-Day--checkIn')]");

    public void enterCity() {
        Waiter.explicitWait(city);
        Driver.getDriver().findElement(city).click();
        //Driver.getDriver().findElement(city).sendKeys("Moscow");
        Driver.getDriver().findElement(inputCity).click();
        //Driver.getDriver().findElement(city).submit();
    }

    public void enterStartDate() {
        Waiter.explicitWait(setDate);
        Driver.getDriver().findElement(setDate).click();
    }

    public void searchHotel() {
        Driver.getDriver().findElement(search).click();
    }

    public int getCountHotelsList() {
        List<WebElement> element = Driver.getDriver().findElements(listHotels);
        return element.size();
    }

    private int getCountHotels() {
        String string = Driver.getDriver().findElement(getCount).getText();
        string = string.replaceAll("\\D+","");
        return Integer.parseInt(string);
    }

    public boolean equalsCountHotels() {
        return getCountHotels() == getCountHotelsList();
    }

    private void chooseStars() {
        Waiter.explicitWait(chooseStars);
        Driver.getDriver().findElement(chooseStars).click();
    }

    public void setStarts() {
        chooseStars();
        Waiter.explicitWait(setStars);
        Driver.getDriver().findElement(setStars).click();
    }

    public void clickCalendar() {
        Driver.getDriver().findElement(chooseDate).click();
    }

    public boolean checkYesterday() {
        Waiter.explicitWait(chooseYesterday);
        Driver.getDriver().findElement(chooseYesterday).click();
        Waiter.explicitWait(yesterday);
        return Driver.getDriver().findElement(yesterday).isDisplayed();
    }
}
