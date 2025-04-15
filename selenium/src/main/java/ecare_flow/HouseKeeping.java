package ecare_flow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HouseKeeping {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://devui-ecare.mightcode.com/");
		driver.manage().deleteAllCookies();
		driver.findElement(By.id("basic_email")).sendKeys("hkincharge");
		driver.findElement(By.id("basic_password")).sendKeys("Hkadmin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String status = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[5]/span")).getText();
		System.out.println(status);
		int count = 1;

		// System.out.println(driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[6]")).isDisplayed());

		while (driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[6]")).isDisplayed()) {
			if (status.equals("Pending") || status.equals("Ready To Clean")) {

				driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[6]")).click();
				Thread.sleep(2000);

				// Select Start Time
				driver.findElement(By.xpath("//input[@placeholder='Start Time']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//ul[@data-type='meridiem']/li")).click();
				driver.findElement(By.xpath("//span[text()='OK']")).click();

				// Select End time
				driver.findElement(By.xpath("//ul[@data-type='meridiem']/li[2]")).click();
				driver.findElement(By.xpath("//span[text()='OK']")).click();

				// Select Housekeeper name
				driver.findElement(By.id("rc_select_0")).sendKeys("Suresh");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='ant-select-item-option-content']/div/div[2]")).click();

				// Click on Submit button
				driver.findElement(By.xpath("//span[text()='Submit']")).click();

			} else {
				// (status.equals("In Progress"))
				driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[6]")).click();
				Thread.sleep(2000);

				// Click on Submit button
				driver.findElement(By.xpath("//span[text()='Complete']")).click();

			}
			Thread.sleep(2000);
			status = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[5]/span")).getText();
			System.out.println(status);
			System.out.println("Iteration : " + count++);

		}

	}

}
