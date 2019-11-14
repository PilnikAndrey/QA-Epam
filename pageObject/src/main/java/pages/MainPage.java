package pages;

import driver.Driver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import utils.Waiter;

public class MainPage {
    private By city = By.xpath("//div[@class='IconBox IconBox--autocomplete']//div[@class='IconBox__wrapper']");//"//*[contains(@class,'IconBox IconBox--autocomplete')]"
    private By search = By.xpath("//button[contains(@class,'btn Searchbox__searchButton Searchbox__searchButton--active')]");
    private By inputCity = By.xpath("//ul[@class='AutocompleteList']//li[3]");
    private By setDate = By.xpath("//div[@class='SearchBoxTextDescription SearchBoxTextDescription--checkIn SearchBoxTextDescription--focused']");
    private By chooseStars = By.xpath("//div[@data-element-value='StarRating']");
    private By setStars = By.xpath("//div[contains(@class,'TopBarContainer')]//li[5]");
    private By listHotels = By.xpath("//*[@class='hotel-list-container']//*[@data-selenium='hotel-item']");
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

    public void getCountHotels() {
          WebElement element = (WebElement) Driver.getDriver().findElements(listHotels);
          
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
}
