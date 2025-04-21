package Clutch.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://clutch.co/us/developers/information-technology-industry");
		
		List<WebElement> companyNameEle = driver.findElements(By.className("provider__title"));

		List<String> companyNames = companyNameEle.stream().map(s -> s.getText()).collect(Collectors.toList());
		companyNames.stream().forEach(companyName -> System.out.println("Company Name -> "+companyName));
		
		//.min-project-size
		driver.findElements(By.cssSelector("[class*='min-project-size']")).stream().map(s -> s.getText())
		.forEach(s -> System.out.println("Min Project Size -> "+s));
		
		//hourly-rate ->[class*='hourly-rate']
		driver.findElements(By.cssSelector("[class*='hourly-rate']")).stream().map(s -> s.getText())
		.forEach(s -> System.out.println("Hourly Rate -> "+s));

		//[class*='employees-count'] 
		driver.findElements(By.cssSelector("[class*='employees-count']")).stream().map(s -> s.getText())
		.forEach(s -> System.out.println("Employee Count -> "+s));
		
		//[class*='location']
		driver.findElements(By.cssSelector("[class*='location']")).stream().map(s -> s.getText())
		.forEach(s -> System.out.println("Location -> "+s));
		
		//[class*='project-highlight-text']
		driver.findElements(By.cssSelector("[class*='project-highlight-text']")).stream().map(s -> s.getText())
		.forEach(s -> System.out.println("Description -> "+s));
	}

}
