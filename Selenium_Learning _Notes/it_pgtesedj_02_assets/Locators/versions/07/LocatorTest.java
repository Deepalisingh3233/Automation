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

        List<WebElement> categoriesEls = driver.findElements(By.id("itemc"));

        for (WebElement categoryEl : categoriesEls) {

            System.out.println("---------------");
            System.out.println("Category clicked: " + categoryEl.getText());

            categoryEl.click();

            // This is needed to ensure that the categories are updated due to the click
            delay();

            WebElement containerEl = driver.findElement(By.id("tbodyid"));

            // Search a subset of the DOM (to find only the links within the main page)
            List<WebElement> linkEls = containerEl.findElements(By.tagName("a"));

            for (WebElement linkEl : linkEls) {
                String hrefAttr = linkEl.getAttribute("href");
                Assert.assertNotNull(hrefAttr);

                System.out.println("URL:" + hrefAttr);
            }

        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
