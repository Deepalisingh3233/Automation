package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckLabel {

	@Test
	public void checkLabel() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://devui-ecare.mightcode.com/");
		String text = driver.findElement(By.cssSelector("h2[class*='text-center']")).getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("SIGN I N", text);
		System.out.println("test fail or passed");
		driver.close();
	}

}
