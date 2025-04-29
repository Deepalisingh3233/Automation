package Test;

import java.time.Duration;

import org.testng.annotations.Test;

import eCare.AbstractComponent.AbstractComponents;
import eCare.PageObjects.Registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass {

	@Test
	public void Login() 
		{
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			AbstractComponents loginPage = new AbstractComponents(driver);
			loginPage.goTo();
			loginPage.loginWithValidCredentials("105", "Unicode@2022$");
				
			Registration registration = new Registration(driver);
			registration.registration();
		}
		
		
		
	
}
