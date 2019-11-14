
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AgodaTest {

	private static final int WAIT_SECONDS_TO_LOAD = 10;

	private WebDriver driver;

	@BeforeTest
	public void before() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void after() {
		driver.close();
	}

	@Test
	public void checkingMaxPersonInOneRoom() throws InterruptedException {
		driver.get("https://www.agoda.com");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		driver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[1]/section[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("МОСКВА");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[4]//ul[1]//li[1]")).click();
		Thread.sleep(100);

		driver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[1]/section[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[5]/span[1]")).click();
		Thread.sleep(100);
		//driver.findElement(By.xpath("//div[@class='IconBox IconBox--checkOut']//div[@class='IconBox__wrapper']")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[1]/section[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[5]/div[6]/span[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='Popup__container Popup__container--garage-door']//div[3]")).click();
		//driver.findElement(By.xpath("//div[@class='IconBox IconBox--occupancy']//div[@class='IconBox__wrapper']")).click();
		Thread.sleep(10000);
		for (int i = 0; i < 35; i++) {
			driver.findElement(By.xpath("//div[@class='SegmentOccupancy__occupancy']//div[2]//span[4]")).click();
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='btn Searchbox__searchButton Searchbox__searchButton--active']")).click();
		Thread.sleep(6000);
		try {
			WebElement element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='zero-page']")));
			//driver.findElement(By.xpath("//p[contains(text(),'We couldn't find any results that match your searc')]"));
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void checkingHotels() throws InterruptedException {
		driver.get("https://www.agoda.com");
		Thread.sleep(3000);//ul[@class="AutocompleteList"]/li[1]
		WebDriverWait wait = new WebDriverWait(driver, 100);
		driver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[1]/section[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("МОСКВА");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class='AutocompleteList']/li[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@class,'DayPicker-wrapper')]//div[1]//div[3]//div[3]//div[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='DayPicker-Day__label'][contains(text(),'30')]")).click();
		Thread.sleep(3000);//
		driver.findElement(By.xpath("//button[@class='btn Searchbox__searchButton Searchbox__searchButton--active']")).click();
		Thread.sleep(6000);
		try {
			/*WebElement element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//ol[@class='hotel-list-container']/li[20]")));

			 */
			driver.findElement(By.xpath("//ol[@class='hotel-list-container']/li[2]")).click();
		}
		catch (Exception e) {
			System.out.println(e);
		}


		/*new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.id("Submit")));
		driver.findElement(By.id("Submit")).click();

		new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.visibilityOfElementLocated(By.className("j-trains-box")));
		Assert.assertTrue(driver.findElements(By.className("route-item")).isEmpty());

		 */
	}



}
