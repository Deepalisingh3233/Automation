package selenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterUsingStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("to");
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filterList = veggies.stream().filter(veggie -> veggie.getText().contains("Tomato")).collect(Collectors.toList());
		
		Assert.assertEquals(veggies.size(), filterList.size());
	}

}
