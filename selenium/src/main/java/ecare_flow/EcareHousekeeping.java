package ecare_flow;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.DriverFactory;

public class EcareHousekeeping {

private WebDriver driver;
	
	private static final String SITE = "https://devui-ecare.mightcode.com/";
	
	@BeforeTest
	public void setUp() {
		driver = DriverFactory.createDriver(DriverFactory.BrowserType.CHROME);
	}
	
	public static void delay() {
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void housekeepingTest() {
		
		driver.get(SITE);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'");		
		
		WebElement usernameEl = driver.findElement(By.id("basic_email"));
		WebElement passwordEl = driver.findElement(By.id("basic_password"));
		WebElement submitButtonEl = driver.findElement(By.cssSelector("button[type='submit']"));
		
		usernameEl.sendKeys("hkincharge");
		passwordEl.sendKeys("Hkadmin@123");
		submitButtonEl.submit();
		
		delay();
		
		WebElement statusEl = driver.findElement(By.xpath("//tbody/tr[2]/td[5]/span"));
		String status = statusEl.getText();
		System.out.println(statusEl.getText());
		
		while(statusEl.isDisplayed()) {
			if(status.equals("Pending") || status.equals("Ready To Clean")) {
				delay();
				WebElement editEl = driver.findElement(By.xpath("//tbody/tr[2]/td[6]/span"));
				editEl.click();
				
				delay();
				
				driver.findElement(By.xpath("//input[@placeholder='Start Time']")).click();
				delay();
				driver.findElement(By.xpath("//li[@data-value='am']")).click();
				driver.findElement(By.xpath("//li[@class='ant-picker-ok']")).click();
				
				driver.findElement(By.xpath("//li[@data-value='pm']")).click();
				driver.findElement(By.xpath("//li[@class='ant-picker-ok']")).click();
				delay();
				
				WebElement housekeeperEl = driver.findElement(By.xpath("//input[@id='rc_select_1']"));
				housekeeperEl.sendKeys("Suresh");
				housekeeperEl.sendKeys(Keys.ENTER);
				delay();
//				driver.findElement(By.xpath("//div[@title='Mr suresh ']")).click();
				
				driver.findElement(By.xpath("//span[text()='Submit']")).click();
				delay();
			}
			else {
				delay();
				WebElement editEl = driver.findElement(By.xpath("//tbody/tr[2]/td[6]/span"));
				editEl.click();
				
				delay();
				driver.findElement(By.xpath("//span[text()='Complete']")).click();
				delay();
			}
			
			statusEl = driver.findElement(By.xpath("//tbody/tr[2]/td[5]/span"));
			status = statusEl.getText();
			System.out.println(statusEl.getText());
		}
	}
	
	@AfterTest
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
}
