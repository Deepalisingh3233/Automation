package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		System.out.println(driver.findElement(with(By.tagName("input")).below(dob)).getText());
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		
		WebElement iceCreamLabel = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		
		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
		
	}

}
