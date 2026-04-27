package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LocatorTest {

    private WebDriver driver;

    private static final String SITE = "https://www.demoblaze.com/";

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
    public void idLocatorsTest() {
        driver.get(SITE);

        WebElement logoEl = driver.findElement(By.id("nava"));

        delay();

        System.out.println("Element text: " + logoEl.getText());

        Assert.assertTrue(logoEl.isDisplayed());
        Assert.assertTrue(logoEl.isEnabled());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
