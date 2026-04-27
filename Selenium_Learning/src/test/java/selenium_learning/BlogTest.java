package selenium_learning;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class BlogTest {
	
	@Test
	public void edgeOptionsTest() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--start-maximized", "--inprivate");
		WebDriver driver = new EdgeDriver(options);
		driver.get("https://omayo.blogspot.com/");
		delay(5000);
		driver.quit();
	}
	
	@Test
	public void firefoxOptionsTest() {
		FirefoxOptions options = new FirefoxOptions();
//		options.addArguments("--headless");
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://omayo.blogspot.com/");
		driver.quit();
	}

	@Test
	public void navigateToPageUsingChrome() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
//		options.addArguments("--start-maximized","--incognito");

		WebDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		delay(5000);
		driver.quit();
	}
	
	private void delay(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		}catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
