package com.loonycorn.learningselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class BlogTest {

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

    @Test
    public void firefoxOptionsTests() {

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
