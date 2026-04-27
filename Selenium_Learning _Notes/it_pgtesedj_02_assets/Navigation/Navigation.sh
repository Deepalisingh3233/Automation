
########################### 
demo-15-Navigation 
###########################

# Let's set up the very simplest possible navigation

# Under src/test com.loonycorn.learningselenium create a test class


------------------------------------------------------------
# NavigationTest.java (version 01)


package com.loonycorn.learningselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class NavigationTest {

    private static void delay() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void navigationTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.skillsoft.com/");

        delay();

        driver.quit();
    }

}


# Run this test and show

------------------------------------------------------------
# NavigationTest.java (version 02)


# Let's refactor to set up a driver factory so we can create tests with different browsers as needed

# # Under src/test com.loonycorn.learningselenium create a file

utils/DriverFactory.java


# Set up the code

package com.loonycorn.learningselenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE,
    }

    public static WebDriver createDriver(BrowserType browserType) {
        WebDriver driver = null;

        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }

        return driver;
    }

}


# Now let's update the NavigationTest to use this and also use set up and tear down methods


package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NavigationTest {

    private WebDriver driver;

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
        driver.get("https://www.skillsoft.com/");

        delay();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

# Run this and show


------------------------------------------------------------
# NavigationTest.java (version 03)


# Open this page up on the browser

https://www.skillsoft.com/


# Go to "Company" -> "About" (show the URL)


# Go to "Company" -> "Leadership" (show the URL)


# Go to "Company" -> "About" (show the URL)


# Go to "Company" -> "Newsroom" (show the URL)


# Back to NavigationTest.java - add these

    private static final String SITE = "https://www.skillsoft.com/";

    private static final String ABOUT = SITE + "/about";
    private static final String LEADERSHIP = SITE + "/leadership-team";
    private static final String NEWSROOM = SITE + "/news";


# Replace the test

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


# Run and show    



------------------------------------------------------------
# NavigationTest.java (version 04)
# Accessing and asserting basic details of the site


# Go to

https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html

# Show the options

# Click on 

WebDriver.Navigation

# Show the options for navigation (back(), forward(), refresh())


# Back to IntelliJ

# Update test

    @Test
    public void navigationTest() {
        driver.get(SITE);

        Assert.assertEquals(driver.getCurrentUrl(), SITE);
        Assert.assertEquals(driver.getTitle(),
                "Employee Development: Online Training Solutions | Skillsoft");

        driver.get(ABOUT);

        Assert.assertEquals(driver.getCurrentUrl(), ABOUT);
        Assert.assertEquals(driver.getTitle(),"About Us - Skillsoft");

        driver.get(LEADERSHIP);

        Assert.assertEquals(driver.getCurrentUrl(), LEADERSHIP);
        Assert.assertEquals(driver.getTitle(),"The Skillsoft Leadership Team");

        driver.get(NEWSROOM);

        Assert.assertEquals(driver.getCurrentUrl(), NEWSROOM);
        Assert.assertEquals(driver.getTitle(),"Skillsoft Newsroom - Skillsoft");
    }


# Run and show the test passes


# Cause the test to fail - change this line

        Assert.assertEquals(driver.getTitle(),
                "Employee Development: Online Training Solutions");


# Run and show the test fails

# Undo the changes so the test passes once again



------------------------------------------------------------
# NavigationTest.java (version 05)
# Navigating back and forth


# Just update the test


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



# Run and show that it passes

























