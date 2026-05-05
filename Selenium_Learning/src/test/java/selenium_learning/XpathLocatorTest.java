package selenium_learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.DriverFactory;

public class XpathLocatorTest {
	
	private WebDriver driver;
	private static final String SITE = "https://www.saucedemo.com/";
	
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
	public void xpathLocatorTest() {
		driver.get(SITE);
		
		WebElement loginEl = driver.findElement(By.cssSelector("div[class='login-box']"));
		Assert.assertTrue(loginEl.isEnabled());
		Assert.assertTrue(loginEl.isDisplayed());
		
		WebElement usernameEl = driver.findElement(By.xpath("//input[@id='user-name']"));
		WebElement passwordEl = driver.findElement(By.xpath("//input[@id='password']"));
		
		usernameEl.sendKeys("standard_user");
		passwordEl.sendKeys("secret_sauce");
		
		delay();
		
		WebElement submitButtonEl = driver.findElement(By.xpath("//*[@id='login-button']"));
		submitButtonEl.click();
		
		delay();
		
		Assert.assertEquals(driver.getCurrentUrl(), SITE + "inventory.html");

		WebElement addToCartBackpackLinkEl = driver.findElement(By.linkText("Sauce Labs Backpack"));
		addToCartBackpackLinkEl.click();
		
		delay();
		
		driver.navigate().back();
		
		WebElement addToCartOnesieLinkEl = driver.findElement(By.partialLinkText("Onesie"));
		addToCartOnesieLinkEl.click();
		
		delay();
		
		driver.navigate().back();
		
	}
	
	@AfterTest
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

}
