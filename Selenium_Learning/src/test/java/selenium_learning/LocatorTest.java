package selenium_learning;

import java.time.Duration;
import java.util.List;

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
	
	@Test
	public void tagNameLocatorTest() {
		driver.get(SITE);
		
		WebElement imgEl = driver.findElement(By.tagName("img"));
		
		String srcAttr = imgEl.getAttribute("src");
		
		Assert.assertNotNull(srcAttr);
		
		System.out.println("Image Source: " + srcAttr);
		
	}
	
	@Test
	public void tagNameMultiLocatorsTest() {
		driver.get(SITE);
		
		List<WebElement> imgEls = driver.findElements(By.tagName("img"));
		for(WebElement imgEl : imgEls) {
			String srcAttr = imgEl.getAttribute("src");
			
			System.out.println("Image Source: " + srcAttr);
		}
	}
	
	@Test
	public void complexTagNameLocatorTest() {
		driver.get(SITE);
		
		List<WebElement> catagoriesEls = driver.findElements(By.id("itemc"));
		
		for(WebElement catagoryEl : catagoriesEls) {
			System.out.println("-----------------------");
			System.out.println("Catagory clicked: " + catagoryEl.getText());
			catagoryEl.click();
			
			delay();
			
			WebElement containerEl = driver.findElement(By.id("tbodyid"));
			
			List<WebElement> linkEls = containerEl.findElements(By.tagName("a"));
			
			for (WebElement linkEl : linkEls) {
				String hrefAttr = linkEl.getAttribute("href");
				Assert.assertNotNull(hrefAttr);
				
				System.out.println("URL: "+ hrefAttr);
			}
		}
	}
	
	@Test
	public void paginationTest() {
		driver.get(SITE);
		
		WebElement formEl = driver.findElement(By.name("frm"));
		
		Assert.assertTrue(formEl.isEnabled());
		Assert.assertTrue(formEl.isDisplayed());
		
		List<WebElement> buttonsEl = formEl.findElements(By.tagName("button"));
		
		Assert.assertEquals(buttonsEl.size(), 2);
		Assert.assertTrue(buttonsEl.get(0).isDisplayed());
		Assert.assertTrue(buttonsEl.get(1).isDisplayed());
		
		System.out.println("Button Text: "+buttonsEl.get(0).getText());
		System.out.println("Button Text: "+buttonsEl.get(1).getText());
	}
	
	@AfterTest
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
