package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class End2End {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
                .click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        if ((driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5"))) {
            System.out.println("It is disabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);

        driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
    }
}
