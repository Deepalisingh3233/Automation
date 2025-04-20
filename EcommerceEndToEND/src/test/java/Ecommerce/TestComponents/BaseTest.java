package Ecommerce.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Ecommerce.PageObjects.LandingPage;

public class BaseTest {

	
	public WebDriver driver;

	public WebDriver initalizeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Ecommerce\\Resouces\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			
//			WebDriverManager.chromeDriver.setup();
			driver = new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
			
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	
	public LandingPage launchApplication() throws IOException {
		driver = initalizeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
}
