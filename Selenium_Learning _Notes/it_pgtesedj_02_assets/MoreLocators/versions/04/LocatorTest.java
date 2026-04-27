package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class LocatorTest {

    private WebDriver driver;

    private static final String SITE = "https://www.saucedemo.com/";

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
    public void xpathLocatorsTest() {
        driver.get(SITE);

        WebElement loginEl = driver.findElement(By.cssSelector("div[class='login-box']"));

        Assert.assertTrue(loginEl.isEnabled());
        Assert.assertTrue(loginEl.isDisplayed());

        WebElement usernameEl = loginEl.findElement(By.xpath(
                "/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        WebElement passwordEl = loginEl.findElement(By.xpath("//*[@id=\"password\"]"));

        usernameEl.sendKeys("standard_user");
        passwordEl.sendKeys("secret_sauce");

        delay();

        WebElement submitButtonEl = loginEl.findElement(By.xpath("//*[@id=\"login-button\"]"));
        submitButtonEl.submit();

        delay();

        Assert.assertEquals(driver.getCurrentUrl(), SITE + "inventory.html");

        WebElement addToCartBackpackLinkEl = driver.findElement(By.linkText("Sauce Labs Backpack"));

        addToCartBackpackLinkEl.click();

        delay();

        driver.navigate().back();

        WebElement addToCartOnesieLinkEl = driver.findElement(By.partialLinkText("Onesie"));

        addToCartOnesieLinkEl.click();

        delay();

        driver.navigate().back();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
