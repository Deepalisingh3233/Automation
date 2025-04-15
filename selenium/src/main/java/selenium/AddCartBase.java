package selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCartBase {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String itemsNeeded[] = { "Cucumber", "Brocolli", "Beetroot", "Tomato" };
        Thread.sleep(3000);
        addItems(driver, itemsNeeded, wait);

    }

    public static void addItems(WebDriver driver, String[] itemsNeeded, WebDriverWait wait) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            List itemNeededdList = Arrays.asList(itemsNeeded);

            int j = 0;
            if (itemNeededdList.contains(formattedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                // System.out.println(products.get(i).getText());
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }

        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        ////button[contains(text(),'PROCEED TO CHECKOUT')]
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
        driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath(".//button[@class='promoBtn']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[@class='promoInfo']")));
        System.out.println(driver.findElement(By.xpath(".//span[@class='promoInfo']")).getText());

    }
}
