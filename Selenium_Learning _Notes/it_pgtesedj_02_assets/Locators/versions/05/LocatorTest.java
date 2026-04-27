package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class LocatorTest {

    private WebDriver driver;

    private static final String SITE = "https://www.demoblaze.com/";

    private static final String CART = SITE + "cart.html";

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.createDriver(DriverFactory.BrowserType.CHROME);
    }

    private static void delay() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void classLocatorsTest() {
        driver.get(SITE);

        WebElement samsungGalaxyEl = driver.findElement(By.className("hrefch"));

        Assert.assertTrue(samsungGalaxyEl.isDisplayed());
        Assert.assertTrue(samsungGalaxyEl.isEnabled());

        samsungGalaxyEl.click();

        WebElement addToCartButtonEl = driver.findElement(By.className("btn-success"));

        addToCartButtonEl.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait for up to 10 seconds
        wait.until(ExpectedConditions.alertIsPresent());

        // We will learn more about alerts in a later learning path
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement cartEl = driver.findElement(By.id("cartur"));

        cartEl.click();

        WebElement cartItemEl = driver.findElement(By.className("success"));

        Assert.assertTrue(cartItemEl.isDisplayed());
        Assert.assertTrue(cartItemEl.isEnabled());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
