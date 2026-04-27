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
    public void idLocatorsTest() {
        driver.get(SITE);

        WebElement footerEl = driver.findElement(By.id("footc"));

        Assert.assertNotNull(footerEl);
        Assert.assertTrue(footerEl.isDisplayed());
        Assert.assertTrue(footerEl.isEnabled());

        WebElement cartEl = driver.findElement(By.id("cartur"));

        cartEl.click();

        Assert.assertEquals(driver.getCurrentUrl(), CART);

        // Need to get this element afresh for this page
        footerEl = driver.findElement(By.id("footc"));

        Assert.assertNotNull(footerEl);
        Assert.assertTrue(footerEl.isDisplayed());
        Assert.assertTrue(footerEl.isEnabled());

        delay();

        WebElement logoEl = driver.findElement(By.id("nava"));

        logoEl.click();

        Assert.assertEquals(driver.getCurrentUrl(), SITE + "index.html");

        delay();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
