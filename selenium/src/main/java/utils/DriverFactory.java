package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

	public enum BrowserType {
		CHROME,
		FIREFOX,
		EDGE,
	}
	
	public static WebDriver createDriver(BrowserType browserType) {
		WebDriver driver = null;
		
		switch(browserType) {
		case CHROME:
			ChromeOptions ChromeOptions = new ChromeOptions();
//			ChromeOptions.addArguments("--start-maximized");
			driver = new ChromeDriver(ChromeOptions);
//			driver.manage().window().fullscreen();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			break;
		case FIREFOX:
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOptions);
			break;
		case EDGE:
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--start-maximized");
			driver = new EdgeDriver(edgeOptions);
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser type: "+browserType);
		}
		
		return driver;	
	}
}
