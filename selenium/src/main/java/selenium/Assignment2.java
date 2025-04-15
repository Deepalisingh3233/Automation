package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Deepali");
        driver.findElement(By.name("email")).sendKeys("deepali7289@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("1234");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(1);
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
        System.out.println(
                driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
    }
}
