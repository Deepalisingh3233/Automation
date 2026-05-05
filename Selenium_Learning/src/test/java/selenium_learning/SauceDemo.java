package selenium_learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.DriverFactory;

public class SauceDemo {

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
	public void cssSelectorsLocatorsTest() {
		driver.get(SITE);
		
//		"<tagName>[class='<class value>']"
//		WebElement loginEl =driver.findElement(By.cssSelector("div.login-box"));
		WebElement loginEl =driver.findElement(By.cssSelector("div[class='login-box']"));
		
		Assert.assertTrue(loginEl.isEnabled());
		Assert.assertTrue(loginEl.isDisplayed());
		
//		"<tagName>[id='<id value>']"
//		WebElement usernameEl = driver.findElement(By.cssSelector("#user-name"));
//		WebElement passwordEl = driver.findElement(By.cssSelector("input#password"));
		
		WebElement usernameEl = driver.findElement(By.cssSelector("input[id='user-name']"));
		WebElement passwordEl = driver.findElement(By.cssSelector("input[id='password']"));
		
		usernameEl.sendKeys("standard_user");
		passwordEl.sendKeys("secret_sauce");
		
		delay();
		
//		"<tagName>[attr='<attr value>']"
//		WebElement submitButtonEl = driver.findElement(By.cssSelector(".submit-button"));
		WebElement submitButtonEl = driver.findElement(By.cssSelector("input[data-test='login-button']"));

		submitButtonEl.submit();
		
		delay();
		
		Assert.assertEquals(driver.getCurrentUrl(), SITE + "inventory.html");
	}
	
	@Test
	public void addToCart() {
		driver.get(SITE);
		
		WebElement loginEl =driver.findElement(By.cssSelector("div[class='login-box']"));
		
		Assert.assertTrue(loginEl.isEnabled());
		Assert.assertTrue(loginEl.isDisplayed());
				
		WebElement usernameEl = driver.findElement(By.cssSelector("input[id='user-name']"));
		WebElement passwordEl = driver.findElement(By.cssSelector("input[id='password']"));
		
		usernameEl.sendKeys("standard_user");
		passwordEl.sendKeys("secret_sauce");
		
		delay();
		
		WebElement submitButtonEl = driver.findElement(By.cssSelector("input[data-test='login-button']"));

		submitButtonEl.submit();
		
		delay();
		
		Assert.assertEquals(driver.getCurrentUrl(), SITE + "inventory.html");
		
		WebElement addToCartBackpackEl = driver.findElement(By.cssSelector("button.btn_inventory[name='add-to-cart-sauce-labs-backpack']"));
		addToCartBackpackEl.click();
		
		WebElement addToCardOnesiEl = driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-onesie[data-test='add-to-cart-sauce-labs-onesie']"));
		addToCardOnesiEl.click();
		
		delay();
		
		WebElement shoppingCartLinkEl = driver.findElement(By.cssSelector("a[class^='shopping_cart']"));
		shoppingCartLinkEl.click();
		
		delay();
		
		WebElement continueShoppingButtonEl = driver.findElement(By.cssSelector("button[id$='tinue-shopping']"));
		continueShoppingButtonEl.click();
		
		delay();
	}
	
	@AfterTest
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
