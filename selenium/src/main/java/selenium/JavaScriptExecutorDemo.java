package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,600)");

        Thread.sleep(2000);

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");


        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;

        for(int i = 0; i < values.size(); i++){
            // System.out.println(Integer.parseInt(values.get(i).getText()));
            sum = sum + Integer.parseInt(values.get(i).getText());
        }

        System.out.println(sum);

        System.out.println(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
        String actualString = driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
        Assert.assertEquals(sum, Integer.parseInt(actualString));


    }
}
