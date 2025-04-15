package selenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamLiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on Column
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// capture all webelements into list
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

		// capture text of all webelements into new(original) list
		List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// sort on the list of step 3 -> sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// compare orginal list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));

		List<String> price;
		// Scan the name column with getText -> Rice -> print the price of rice
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());
			price.forEach(s -> System.out.println(s));
			if((price.size() < 1)) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}while((price.size() < 1));

	}

	private static String getPriceVeggie(WebElement	s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
