package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

        driver.findElement(By.xpath("//div[@class='example']/a")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parenId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        driver.switchTo().window(parenId);
        System.out.println(driver.findElement(By.tagName("h3")).getText());

    }
}
