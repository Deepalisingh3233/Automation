package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//Testng us one of the testing framework
import org.testng.Assert;

public class UpdateDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		// System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		// System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		if ((driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1"))) {
			System.out.println("It is enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		int i = 1;
		// while(i < 5) {
		// driver.findElement(By.id("hrefIncAdt")).click();
		// i++;
		// }

		for (i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

		driver.findElement(By.id("btnclosepaxoption")).click();

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	}

}
