package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println("Total Number of Rows: "+driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size());
        System.out.println("Total Number of Columns: "+driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size());

        System.out.println("Data of second row: ");
        for(int i = 0; i < driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size(); i++){
            System.out.println(driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td")).get(i).getText());
        }
    }
}
