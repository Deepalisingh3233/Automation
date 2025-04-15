package selenium;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Switching window
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String parentWindowId = itr.next();
		String childWindowId = itr.next();
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		driver.switchTo().window(parentWindowId);
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(courseName);
		
		//Screenshot
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		//GET height  & Weight of the webelement
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
	}

}
