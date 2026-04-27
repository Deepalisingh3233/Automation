package com.loonycorn.learningselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.service.DriverFinder;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class BlogTest {

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

//    @Test
//    public void chromeOptionsTest() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized", "--incognito");
//        WebDriver driver = new ChromeDriver(options);
//
//        driver.get("https://omayo.blogspot.com/");
//
//        delay(5000);
//
//        driver.quit();
//    }

    private void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
