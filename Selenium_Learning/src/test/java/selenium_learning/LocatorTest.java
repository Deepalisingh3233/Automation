package selenium_learning;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.DriverFactory;

public class LocatorTest {

	private WebDriver driver;
	private static final String SITE = "https://www.demoblaze.com/";
	private static final String CART =  SITE + "cart.html";
	
	@BeforeTest
	public void setUp() {
		driver = DriverFactory.createDriver(DriverFactory.BrowserType.CHROME);
	}
	
	public static void delay() {
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void idLocatorTest() {
		driver.get(SITE);
		driver.get(CART);
		
		delay();

		
		WebElement logoEl = driver.findElement(By.id("nava"));
		System.out.println("Element Text: "+ logoEl.getText());
		
		Assert.assertTrue(logoEl.isDisplayed());
		Assert.assertTrue(logoEl.isEnabled());
		Assert.assertFalse(logoEl.isSelected());
		
		logoEl.click();
		
		delay();
		
		Assert.assertEquals(driver.getCurrentUrl(), SITE + "index.html");
		logoEl = driver.findElement(By.id("nava"));
		logoEl.click();
	}
	
	@Test
	public void idLoctorTest2() {
		driver.get(SITE);
		
		WebElement footerEl = driver.findElement(By.id("footc"));
		Assert.assertNotNull(footerEl);
		Assert.assertTrue(footerEl.isDisplayed());
		Assert.assertTrue(footerEl.isEnabled());
		
		WebElement cartEl = driver.findElement(By.id("cartur"));
		cartEl.click();
		Assert.assertEquals(driver.getCurrentUrl(), CART);
		
		footerEl = driver.findElement(By.id("footc"));
		
		Assert.assertNotNull(footerEl);
		Assert.assertTrue(footerEl.isDisplayed());
		Assert.assertTrue(footerEl.isEnabled());
		
		delay();
		
		WebElement logoEl = driver.findElement(By.id("nava"));
		
		logoEl.click();
		Assert.assertEquals(driver.getCurrentUrl(), SITE + "index.html");
		
	}
	
	@Test
	public void addItemToCart() {
		driver.get(SITE);
		
		WebElement samsungGallaxyEl = driver.findElement(By.className("hrefch"));
		
		Assert.assertTrue(samsungGallaxyEl.isDisplayed());
		Assert.assertTrue(samsungGallaxyEl.isEnabled());
		
		samsungGallaxyEl.click();
		
		WebElement addToCartBtnEl = driver.findElement(By.className("btn-success"));
		addToCartBtnEl.click();
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement cartEl = driver.findElement(By.id("cartur"));
		cartEl.click();
		
		WebElement cartItemEl = driver.findElement(By.className("success"));
		
		Assert.assertTrue(cartItemEl.isDisplayed());
		Assert.assertTrue(cartItemEl.isEnabled());
	}
	
	@AfterTest
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
