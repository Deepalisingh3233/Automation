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
    public void nameLocatorsTest() {
        driver.get(SITE);

        WebElement formEl = driver.findElement(By.name("frm"));

        Assert.assertTrue(formEl.isEnabled());
        Assert.assertTrue(formEl.isDisplayed());

        List<WebElement> buttonsEl = formEl.findElements(By.tagName("button"));

        // Make sure we have two buttons and both displayed
        Assert.assertEquals(buttonsEl.size(), 2);
        Assert.assertTrue(buttonsEl.get(0).isDisplayed());
        Assert.assertTrue(buttonsEl.get(1).isDisplayed());

        System.out.println("Button text: " + buttonsEl.get(0).getText());
        System.out.println("Button text: " + buttonsEl.get(1).getText());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
