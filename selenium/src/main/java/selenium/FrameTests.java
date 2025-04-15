package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTests {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);
        // iframem[class='demo-frame']
        // driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        driver.findElement(By.id("draggable")).click();

        Actions action = new Actions(driver);

        WebElement target = driver.findElement(By.id("droppable"));
        WebElement source = driver.findElement(By.id("draggable"));
        action.dragAndDrop(source, target).build().perform();

        driver.switchTo().defaultContent();
    }
}