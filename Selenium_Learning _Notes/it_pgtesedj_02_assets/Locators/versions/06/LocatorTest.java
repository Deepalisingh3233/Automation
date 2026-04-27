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
    public void tagNameLocatorsTest() {
        driver.get(SITE);

        List<WebElement> imgEls = driver.findElements(By.tagName("img"));

        for (WebElement imgEl : imgEls) {
            String srcAttr = imgEl.getAttribute("src");
            Assert.assertNotNull(srcAttr);

            System.out.println("Image source:" + srcAttr);
        }

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
