package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");

        //driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
        driver.findElement(By.xpath("//div[@class='form-check-inline']/label/following-sibling::label/span/following-sibling::span")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByValue("consult");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
        List<WebElement> items = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
        
        // driver.findElement(By.xpath("//button[@class='btn btn-info'][1]")).click();
        for(int i = 0; i < items.size(); i++){
            driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
        }

        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();


    }


    public static void addItems(WebDriver driver){

    }


}
