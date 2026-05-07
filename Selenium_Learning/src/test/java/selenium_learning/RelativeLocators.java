package selenium_learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.DriverFactory;

public class RelativeLocators {

	private WebDriver driver;
	private static final String SITE = "https://testpages.eviltester.com/pages/forms/html-form/";
	
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
	public void relativeLocatorsTest() {
		driver.get(SITE);
		
		delay();
		
		WebElement usernameInputEl = driver.findElement(By.name("username"));
		usernameInputEl.sendKeys("Bob Baker");
		
		WebElement passwordInputEl = driver.findElement(
				RelativeLocator.with(By.tagName("input")).below(usernameInputEl));
		passwordInputEl.sendKeys("password123");
		
		WebElement commentInputEl = driver.findElement(
				RelativeLocator.with(By.tagName("textarea")).below(passwordInputEl));
		commentInputEl.clear();
		commentInputEl.sendKeys("Some comments here");
		
		delay();
		
		WebElement submitInputEl = driver.findElement(By.cssSelector("input[value='submit']"));
		submitInputEl.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_valueusername")));
		
		WebElement usernameListItemEl = driver.findElement(By.id("_valueusername"));
		Assert.assertEquals(usernameListItemEl.getText(), "Bob Baker");
		
		WebElement passwordListItemEl = driver.findElement(
				RelativeLocator.with(By.tagName("li")).below(usernameListItemEl));
		Assert.assertEquals(passwordListItemEl.getText(), "password123");
		
		WebElement commentListItemEl = driver.findElement(
				RelativeLocator.with(By.tagName("li")).below(passwordListItemEl));
		Assert.assertEquals(commentListItemEl.getText(), "Some comments here");
		
		delay();
	}
	
	@Test
	public void relativeLocatorsAboveTest() {
		driver.get(SITE);
		
		delay();
		
		WebElement commentInputEl = driver.findElement(By.name("comments"));
		commentInputEl.clear();
		commentInputEl.sendKeys("Some comments here");
		
		WebElement passwordInputEl = driver.findElement(
				RelativeLocator.with(By.tagName("input")).above(commentInputEl));
		passwordInputEl.sendKeys("password123");
		
		WebElement usernameInputEl = driver.findElement(
				RelativeLocator.with(By.tagName("input")).above(passwordInputEl));
		usernameInputEl.sendKeys("Bob Baker");
		
		delay();
		
		WebElement submitInputEl = driver.findElement(By.cssSelector("input[value='submit']"));
		submitInputEl.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_valueusername")));
		
		WebElement commentListItemEl = driver.findElement(By.id("_valuecomments"));
		Assert.assertEquals(commentListItemEl.getText(), "Some comments here");
		
		WebElement passwordListItemEl = driver.findElement(
				RelativeLocator.with(By.tagName("li")).above(commentListItemEl));
		Assert.assertEquals(passwordListItemEl.getText(), "password123");
		
		WebElement usernameListItemEl = driver.findElement(
				RelativeLocator.with(By.tagName("li")).above(passwordListItemEl));
		Assert.assertEquals(usernameListItemEl.getText(), "Bob Baker");
		
		delay();
	}
	
	@Test
	public void relativeLocatorsToLeftOfTest() {
		driver.get(SITE);
		
		delay();
		
		WebElement commentInputEl = driver.findElement(By.name("comments"));
		commentInputEl.clear();
		commentInputEl.sendKeys("Some comments here");
		
		WebElement passwordInputEl = driver.findElement(
				RelativeLocator.with(By.tagName("input")).above(commentInputEl));
		passwordInputEl.sendKeys("password123");
		
		WebElement usernameInputEl = driver.findElement(
				RelativeLocator.with(By.tagName("input")).above(passwordInputEl));
		usernameInputEl.sendKeys("Bob Baker");
		
		delay();
		
		WebElement submitInputEl = driver.findElement(By.cssSelector("input[value='submit']"));
		WebElement cancelInputEl = driver.findElement(
				RelativeLocator.with(By.tagName("input")).toLeftOf(submitInputEl));
		cancelInputEl.click();
		
		delay();
	}
	
	@Test
	public void relativeLocatorsToRightOfTest() {
		driver.get(SITE);
		
		delay();
		
		WebElement commentInputEl = driver.findElement(By.name("comments"));
		commentInputEl.clear();
		commentInputEl.sendKeys("Some comments here");
		
		WebElement passwordInputEl = driver.findElement(
				RelativeLocator.with(By.tagName("input")).above(commentInputEl));
		passwordInputEl.sendKeys("password123");
		
		WebElement usernameInputEl = driver.findElement(
				RelativeLocator.with(By.tagName("input")).above(passwordInputEl));
		usernameInputEl.sendKeys("Bob Baker");
		
		delay();
		
		WebElement cancelInputEl = driver.findElement(By.cssSelector("input[value='cancel']"));
		WebElement submitInputEl = driver.findElement(
				RelativeLocator.with(By.tagName("input")).toRightOf(cancelInputEl));
		submitInputEl.click();
		
		delay();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_valueusername")));
		
		WebElement usernameListItemEl = driver.findElement(By.id("_valueusername"));
		Assert.assertEquals(usernameListItemEl.getText(), "Bob Baker");
		
		WebElement passwordListItemEl = driver.findElement(
				RelativeLocator.with(By.tagName("li")).below(usernameListItemEl));
		Assert.assertEquals(passwordListItemEl.getText(), "password123");
		
		WebElement commentListItemEl = driver.findElement(
				RelativeLocator.with(By.tagName("li")).below(passwordListItemEl));
		Assert.assertEquals(commentListItemEl.getText(), "Some comments here");
		
		delay();
	}
	
	@Test
	public void relativeLocatorsNearTest() {
		driver.get(SITE);
		
		delay();
		
		WebElement usernameInputEl = driver.findElement(By.name("username"));
		usernameInputEl.sendKeys("Bob Baker");
		
		WebElement passwordInputEl = driver.findElement(
				RelativeLocator.with(By.tagName("input")).near(usernameInputEl));
		passwordInputEl.sendKeys("password123");
		
		WebElement commentInputEl = driver.findElement(
				RelativeLocator.with(By.tagName("textarea")).near(passwordInputEl));
		commentInputEl.clear();
		commentInputEl.sendKeys("Some comments here");
		
		delay();
		
		WebElement submitInputEl = driver.findElement(By.cssSelector("input[value='submit']"));
		submitInputEl.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_valueusername")));
		
		WebElement usernameListItemEl = driver.findElement(By.id("_valueusername"));
		Assert.assertEquals(usernameListItemEl.getText(), "Bob Baker");
		
		WebElement passwordListItemEl = driver.findElement(
				RelativeLocator.with(By.tagName("li")).below(usernameListItemEl));
		Assert.assertEquals(passwordListItemEl.getText(), "password123");
		
		WebElement commentListItemEl = driver.findElement(
				RelativeLocator.with(By.tagName("li")).below(passwordListItemEl));
		Assert.assertEquals(commentListItemEl.getText(), "Some comments here");
		
		delay();
	}
	
	@AfterTest
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
