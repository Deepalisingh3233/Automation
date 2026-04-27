package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NavigationTest {

    private WebDriver driver;

    private static final String SITE = "https://www.skillsoft.com/";

    private static final String ABOUT = SITE + "about";
    private static final String LEADERSHIP = SITE + "leadership-team";
    private static final String NEWSROOM = SITE + "news";

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
        driver.get(ABOUT);

        driver.navigate().back();

        Assert.assertEquals(driver.getCurrentUrl(), SITE);
        Assert.assertEquals(driver.getTitle(),
                "Employee Development: Online Training Solutions | Skillsoft");

        driver.navigate().forward();

        Assert.assertEquals(driver.getCurrentUrl(), ABOUT);
        Assert.assertEquals(driver.getTitle(),"About Us - Skillsoft");

        driver.navigate().refresh();

        Assert.assertEquals(driver.getCurrentUrl(), ABOUT);
        Assert.assertEquals(driver.getTitle(),"About Us - Skillsoft");

        driver.navigate().to(LEADERSHIP);

        Assert.assertEquals(driver.getCurrentUrl(), LEADERSHIP);
        Assert.assertEquals(driver.getTitle(),"The Skillsoft Leadership Team");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
