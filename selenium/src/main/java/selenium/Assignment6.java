package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
        // System.out.println(driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText());
        String label = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();

        WebElement element = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(label);

        driver.findElement(By.id("name")).sendKeys(label);
        driver.findElement(By.id("alertbtn")).click();

        Alert alert = new Alert();
        // System.out.println(driver.switchTo().alert().getText());
        String alertMsg = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
        String msg = alertMsg.split(",")[0].trim().split(" ")[1];
        if(label.equals(msg)){
            System.out.println("SUCCESS");
        }
        else{
            System.out.println("FAIL");
        }

        //another method
        if(alertMsg.contains(label))
        {
            System.out.println("Alert message success");
        }else{
            System.out.println("Something wrong with execution");
        }
   
   
   
    }
}
