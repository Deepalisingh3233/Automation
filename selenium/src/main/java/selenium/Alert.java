package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    public static void main(String[] args) throws InterruptedException {
        String text = "Deepali";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text);
        Thread.sleep(1000);
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

    }
}
