package com.loonycorn.learningselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebDriverTest {

    @Test
    public void navigateToPageUsingChrome() {
//        System.setProperty("webdriver.chrome.driver", "/Users/vitthalsrinivasan/chromedriver_mac_arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
    }
}
