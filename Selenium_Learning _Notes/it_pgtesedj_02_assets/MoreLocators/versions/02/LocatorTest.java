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
    public void cssSelectorsLocatorsTest() {
        driver.get(SITE);

        // "<tagname>[class=’<class value>’]"
        WebElement loginEl = driver.findElement(By.cssSelector("div[class='login-box']"));

        Assert.assertTrue(loginEl.isEnabled());
        Assert.assertTrue(loginEl.isDisplayed());

        // "<tagname>[id=’<id value>’]"
        WebElement usernameEl = loginEl.findElement(By.cssSelector("input[id='user-name']"));
        WebElement passwordEl = loginEl.findElement(By.cssSelector("input[id='password']"));

        usernameEl.sendKeys("standard_user");
        passwordEl.sendKeys("secret_sauce");

        delay();

        // "<tagname>[attr=’<attr value>’]"
        WebElement submitButtonEl = loginEl.findElement(By.cssSelector("input[data-test='login-button']"));
        submitButtonEl.submit();

        delay();

        Assert.assertEquals(driver.getCurrentUrl(), SITE + "inventory.html");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
