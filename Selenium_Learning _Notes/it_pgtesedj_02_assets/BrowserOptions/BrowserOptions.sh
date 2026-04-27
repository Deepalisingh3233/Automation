
########################### 
demo-14-SimpleBrowserOptions 
###########################

# Show this page that we use for the demos

https://omayo.blogspot.com/

# Rename the test file BlogTest (can do this behind the scenes)


# Refer BlogTest_v1.java

# Start with this code

package com.loonycorn.learningselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BlogTest {

    @Test
    public void chromeOptionsTest() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://omayo.blogspot.com/");
        driver.quit();
    }
}


# Add a method to simlate delays

    private void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


# Add a delay (after get()) so we can see the browser up

delay(5000);


# Code looks like this

    @Test
    public void chromeOptionsTest() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://omayo.blogspot.com/");

        delay(5000);

        driver.quit();
    }



# It was not with new full screen

# Add import

import org.openqa.selenium.chrome.ChromeOptions;


# Update driver code

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);


# Run the code, and we can see the screen has maximized and redirected to the next page


# Let's make one more change here, just to see that how multiple arguments worked

		options.addArguments("--incognito");


# Run the code and we can see now, it has opened in incognito 

# Can pass multiple arguments in one call

options.addArguments("--start-maximized", "--incognito");

# This will work same as the previous one only


# Let's make one more program with chrome properties

# Add imports

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.service.DriverFinder;
import org.testng.annotations.Test;

import java.nio.file.Path;

# Change test

    @Test
    public void chromeOptionsTest() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("stable");

        WebDriver driver = new ChromeDriver(options);

        Path chromePath = Path.of(DriverFinder.getPath(
                ChromeDriverService.createDefaultService(), options).getBrowserPath());

        System.out.println("Chrome binary location: " + chromePath);

        driver.get("https://omayo.blogspot.com/");

        delay(5000);

        driver.quit();
    }

# Run the code and it is successful and it will show following output
Chrome binary location: /Applications/Google Chrome.app/Contents/MacOS/Google Chrome


# ********************************************
# Microsoft Edge


# Let's next move to edge and how that is working
# Start with a simple edge program


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BlogTest {

    @Test
    public void edgeOptionsTest() {
        WebDriver driver = new EdgeDriver();

        driver.get("https://omayo.blogspot.com/");

        delay(5000);

        driver.quit();
    }


    private void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


# Next let's introduce the options in edge (replace the driver instantiation)

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized", "--inprivate");
        WebDriver driver = new EdgeDriver(options);


# Now add these imports and update the test


# Replace imports

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.service.DriverFinder;

import org.testng.annotations.Test;

import java.nio.file.Path;


# Update test

    @Test
    public void edgeOptionsTest() {
        EdgeOptions options = new EdgeOptions();
        options.setBrowserVersion("stable");

        WebDriver driver = new EdgeDriver(options);

        Path edgePath = Path.of(DriverFinder.getPath(
                EdgeDriverService.createDefaultService(), options).getBrowserPath());

        System.out.println("Edge binary location: " + edgePath);


        driver.get("https://omayo.blogspot.com/");

        delay(5000);

        driver.quit();
    }


# Run and show

Edge binary location: /Applications/Microsoft Edge.app/Contents/MacOS/Microsoft Edge


# ********************************************

# Let's move to Firefox web browser

# Refer BlogOptions_v10.java
# In this code we are introducing Firefox and how it is working

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.Test;

public class BlogTest {

    @Test
    public void firefoxOptionsTest() {

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-headless");

        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://omayo.blogspot.com/");
        driver.quit();

    }

    private void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

# Run the code and we can see the code is running without opening an explicit browser
# This code is running background


# Add imports

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;
import org.testng.annotations.Test;

import java.nio.file.Path;


# Replace test

    @Test
    public void firefoxOptionsTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBrowserVersion("stable");

        SeleniumManagerOutput.Result output =
                DriverFinder.getPath(GeckoDriverService.createDefaultService(), options);
        Path firefoxPath = Path.of(output.getBrowserPath());

        WebDriver driver = new FirefoxDriver(options);

        System.out.println("FireFox binary location: " + firefoxPath);

        driver.get("https://omayo.blogspot.com/");

        delay(5000);

        driver.quit();
    }


 # Run and show


















