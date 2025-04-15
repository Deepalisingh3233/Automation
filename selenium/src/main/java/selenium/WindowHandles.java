package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
        Set<String> windows = driver.getWindowHandles(); // [parentId, childId]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        System.out.println(childId + " " + parentId);

        driver.switchTo().window(childId);

        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
                .split(" ")[0];
        System.out.println(emailId);

        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailId);

    }
}
