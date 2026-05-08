package selenium_learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.DriverFactory;

public class HoverDragDrop {

	private WebDriver driver;
	private static final String SITE = "https://demoqa.com/menu";
	
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
	public void hoverTest() {
		driver.get(SITE);
		
		WebElement mainItem2El = driver.findElement(By.xpath("//ul[@id='nav']/li[2]/a"));
		
		Actions actions = new Actions(driver);
		
		delay();
		actions.moveToElement(mainItem2El).perform();
		
		delay();
		
		WebElement subItem1El = driver.findElement(By.xpath("//a[text()='Sub Item']"));
		WebElement subItem2El = driver.findElement(By.xpath("//a[text()='Sub Item']"));
		WebElement subSubItemList = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		
		Assert.assertTrue(subItem1El.isDisplayed());
		Assert.assertTrue(subItem2El.isDisplayed());
		Assert.assertTrue(subSubItemList.isDisplayed());
		
		System.out.println("**************************Main Menu hovering is done***************************");
		
		actions.moveToElement(subSubItemList).perform();
		
		delay();
		
		WebElement subSubItem1El = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
		WebElement subSubItem2El = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));
		
		Assert.assertTrue(subSubItem1El.isDisplayed());
		Assert.assertTrue(subSubItem2El.isDisplayed());

		System.out.println("**************************Sub Menu hovering is done***************************");

	}
	
	@AfterTest
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
