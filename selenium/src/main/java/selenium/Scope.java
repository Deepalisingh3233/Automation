package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Give me the count of the link
        System.out.println(driver.findElements(By.tagName("a")).size());

        // Give me the count of the link only of footer section
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // Limiting WebDriver scope
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        // Click on each link in teh column and check if the pages are opening;
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {

            String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);

            Thread.sleep(5);
        }
        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it = abc.iterator();

        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

    }
}
