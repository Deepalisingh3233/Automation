package com.loonycorn.learningselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.service.DriverFinder;

import org.testng.annotations.Test;

import java.nio.file.Path;

public class BlogTest {

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

//    @Test
//    public void edgeOptionsTest() {
//        EdgeOptions options = new EdgeOptions();
//        options.addArguments("--start-maximized", "--inprivate");
//        WebDriver driver = new EdgeDriver(options);
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
