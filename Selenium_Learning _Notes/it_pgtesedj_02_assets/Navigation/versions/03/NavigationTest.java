package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NavigationTest {

    private WebDriver driver;

    private static final String SITE = "https://www.skillsoft.com/";

    private static final String ABOUT = SITE + "/about";
    private static final String LEADERSHIP = SITE + "/leadership-team";
    private static final String NEWSROOM = SITE + "/news";

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
    public void navigationTest() {
        driver.get(SITE);

        delay();

        driver.get(ABOUT);

        delay();

        driver.get(LEADERSHIP);

        delay();

        driver.get(NEWSROOM);

        delay();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
