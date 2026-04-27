package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class RelativeLocatorTest {

    private WebDriver driver;

    private static final String SITE = "https://testpages.eviltester.com/styled/index.html";

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
    public void relativeLocatorsTest() {
        driver.get(SITE);

        WebElement basicFormLinkEl = driver.findElement(By.linkText("HTML Form Example"));

        basicFormLinkEl.click();

        delay();

        WebElement commentsInputEl = driver.findElement(By.name("comments"));
        commentsInputEl.clear();
        commentsInputEl.sendKeys("Some comments here");

        WebElement passwordInputEl = driver.findElement(
                RelativeLocator.with(By.tagName("input")).above(commentsInputEl));
        passwordInputEl.sendKeys("password123");

        WebElement usernameInputEl = driver.findElement(
                RelativeLocator.with(By.tagName("input")).above(passwordInputEl));
        usernameInputEl.sendKeys("Bob Baker");

        delay();

        WebElement submitInputEl = driver.findElement(By.cssSelector("input[value='submit']"));
        WebElement cancelInputEl = driver.findElement(RelativeLocator.with(
                By.tagName("input")).toLeftOf(submitInputEl));

        cancelInputEl.click();

        delay();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
