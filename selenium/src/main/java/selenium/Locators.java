package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//implicit wait - 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("deepali");
		driver.findElement(By.name("inputPassword")).sendKeys("deepali@123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Deepali");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("anc@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("deepali@mightcode.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9856478596");
		driver.findElement(By.className("reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("deepali");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

	}

}
