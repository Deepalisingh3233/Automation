package Clutch.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetData3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://clutch.co/us/developers/information-technology-industry");
				
//		List<WebElement> providerHighlights = driver.findElements(By.cssSelector(".provider-list-item"));
		WebElement nextPagi = driver.findElement(By.xpath("//a[@title='Go to Next Page']")); 
		int count =1; 
		
		while(nextPagi.isEnabled()) {
			List<WebElement> providerHighlights = driver.findElements(By.cssSelector(".provider-list-item"));

			for (WebElement element : providerHighlights) {
				System.out.println(count+" Company Name  -> "+element.findElement(By.className("provider__title")).getText());
				
				System.out.println("Min Project Size -> "+ element.findElement(By.cssSelector("[class*='min-project-size']")).getText());
				
				System.out.println("Hourly Rate -> "+element.findElement(By.cssSelector("[class*='hourly-rate']")).getText());
				
				System.out.println("Employee Count -> "+element.findElement(By.cssSelector("[class*='employees-count']")).getText());
				
				System.out.println("Location -> "+element.findElement(By.cssSelector("[class*='location']")).getText());
				
				System.out.println("Description -> "+element.findElement(By.cssSelector("[class*='project-highlight-text']")).getText());
				
				element.findElements(By.cssSelector(".provider__services-list-item")).stream().filter(s -> s != null)
				.map(s -> s.getText())
				.filter(s -> s != null && !s.isBlank())
				.forEach(s -> System.out.println("Services provided -> "+s));
				
				//provider__cta-container
				for (WebElement link : element.findElements(By.cssSelector(".provider__cta-container"))) {
					link.findElements(By.cssSelector(".provider__cta-link")).stream()
					.filter(s -> s != null)
					.map(s -> s.getDomAttribute("href"))
					.filter(href -> href != null && !href.isEmpty())
					.forEach(s -> System.out.println("URL -> "+s));
				}
				
				
				System.out.println("--------------------");
				count++;
				
				if(count == 66) {
					Thread.sleep(3000);
					nextPagi.click();
					break;
				}
			}
		}
		
	}

}
