package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsActivities {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		driver.navigate().back();
		driver.navigate().forward();
		
	}

}
