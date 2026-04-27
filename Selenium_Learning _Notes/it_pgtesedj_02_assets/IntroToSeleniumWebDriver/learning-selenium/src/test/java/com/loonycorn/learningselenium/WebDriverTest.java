package com.loonycorn.learningselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class WebDriverTest {

    @Test
    public void navigateToPageUsingChrome() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        driver.quit();
    }

    @Test
    public void navigateToPageUsingFireFox() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://duckduckgo.com");

        driver.quit();
    }

    @Test
    public void navigateToPageUsingEdge() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://bing.com");

        driver.quit();
    }
}
