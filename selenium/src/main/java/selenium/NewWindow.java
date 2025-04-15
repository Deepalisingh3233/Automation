package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Open the new Tab
//		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);

		
		//Store the open windows count
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> itr = handles.iterator();
		//get the parent window id
		String parentWindowId = itr.next();
		
		//get the child window id
		String childWindowId = itr.next();
		
		//switch to child window
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		//switch to parent window id
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.name("name")).sendKeys(courseName);
		
//		driver.quit();
		
	}

}
