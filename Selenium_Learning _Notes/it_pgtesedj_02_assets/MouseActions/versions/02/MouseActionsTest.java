package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseActionsTest {

    private WebDriver driver;

    private static final String SITE = "https://demoqa.com/menu";

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.createDriver(DriverFactory.BrowserType.CHROME);
    }

    private static void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void hoverTest() {
        driver.get(SITE);

        WebElement mainItem2El = driver.findElement(
                By.xpath("//a[text()='Main Item 2']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(mainItem2El).perform();

        delay();

        WebElement subItem1El = driver.findElement(By.xpath("//a[text()='Sub Item']"));
        WebElement subItem2El = driver.findElement(By.xpath("//a[text()='Sub Item']"));
        WebElement subSubItemEl = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));

        Assert.assertTrue(subItem1El.isDisplayed());
        Assert.assertTrue(subItem2El.isDisplayed());
        Assert.assertTrue(subSubItemEl.isDisplayed());

        System.out.println("******************** Main menu hovering is done ********************");

        actions.moveToElement(subSubItemEl).perform();

        delay();

        WebElement subSubItem1El = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
        WebElement subSubItem2El = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));

        Assert.assertTrue(subSubItem1El.isDisplayed());
        Assert.assertTrue(subSubItem2El.isDisplayed());

        System.out.println("******************** Nested hovering is done ********************");

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
